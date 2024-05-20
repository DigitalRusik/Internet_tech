package com.marketplace.marketproject.controllers;
import com.marketplace.marketproject.models.Product;
import com.marketplace.marketproject.models.ProductService;
//import jakarta.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;
    @GetMapping("/mainpage/productlist")
    public String products(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            model.addAttribute("username", user);
            return "productlist.html";
        }
        else
        {
            return "redirect:/greeting";
        }
    }
    @GetMapping("/mainpage/myProducts")
    public String myProducts(HttpSession session,@RequestParam(name = "title", required = false) String title, Model model) {
        if (session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            model.addAttribute("username", user);//
            model.addAttribute("products", productService.getProductsByAuthor(user));
            if (title != null)
                model.addAttribute("products", productService.getAllProducts(title));
            return "myProducts";
        }
        else
        {
            return "redirect:/greeting";
        }
    }
    @GetMapping("/mainpage/productsFromUsers")
    public String productsFromUsers(HttpSession session, @RequestParam(name = "title", required = false) String title, Model model) {
        if (session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            model.addAttribute("products", productService.getAllProductsExceptAuthor(user, title));
            return "productsFromUsers";
        }
        else return "redirect:/greeting";
    }
    @GetMapping("/mainpage/myProducts/{id}")
    public String productInfo(HttpSession session, @PathVariable Long id, Model model){
        if (session.getAttribute("username") != null) {
            Product product = productService.getProductById(id);
            model.addAttribute("product", product);
            model.addAttribute("images", product.getImages());
            return "productinfo";
        }
        else return "redirect:/greeting";
    }
    @PostMapping("/product/create")
    public String createProduct(/*@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,*/ Product product) {
        productService.createProduct(product/*, file1, file2, file3*/);
        return "redirect:/mainpage/myProducts";
    }
    @PostMapping("/mainpage/myProducts/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/mainpage/myProducts";
    }
}
