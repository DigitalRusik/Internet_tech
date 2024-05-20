package com.marketplace.marketproject.controllers;
import javax.servlet.http.HttpSession;

import com.marketplace.marketproject.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PageController {
    @Autowired
    private SupportService supportService;
    private final ProductService productService;
    private final UserService userService;
    @GetMapping("/")
    public String main(HttpSession session,Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/greeting";
        }
        else
        {
            return "redirect:/mainpage";
        }
    }
    @GetMapping("/greeting")
    public String login(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "greeting";
        }
        else
        {

            if (session.getAttribute("username").equals("Administrator"))
                return "redirect:/adminPage";
            else return "redirect:/mainpage";
        }
    }
    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }
    @GetMapping("/adminPage")
    public String adminSignIn(HttpSession session, Model model) {
        if (session.getAttribute("username").equals("Administrator")) {
            return "adminPage";
        }
        else
        {
            return "redirect:/greeting";
        }
    }
    @GetMapping("/adminPage/userList")
    public String adminUserlist(HttpSession session, @RequestParam(name = "username", required = false) String username, Model model) {
        if (session.getAttribute("username").equals("Administrator")) {
            model.addAttribute("users", userService.getAllUsers(username));
            return "userList";
        }
        else
        {
            return "redirect:/greeting";
        }
    }
    @GetMapping("/adminPage/productAdmin")
    public String adminProducts(HttpSession session, @RequestParam(name = "title", required = false) String title, Model model) {
        if (session.getAttribute("username").equals("Administrator")) {
            model.addAttribute("products", productService.getAllProducts(title));
            return "productAdmin";
        }
        else
        {
            return "redirect:/greeting";
        }

    }
    @GetMapping("/adminPage/supportAdmin")
    public String supportAdmin(HttpSession session, Model model) {
        if (session.getAttribute("username").equals("Administrator")) {
            String receiver = (String) session.getAttribute("username");
            String writer = (String) session.getAttribute("username");
            List<Question> questions = supportService.getAllMessages(receiver, writer);
            model.addAttribute("questions", questions);
            return "supportAdmin";
        } else {
            return "redirect:/greeting";
        }
    }
    @RequestMapping(value = "/adminPage/supportAdmin/addmsg", method = RequestMethod.POST)
    public String submitQuestion(HttpSession session, @RequestParam("question") String answer, @RequestParam("receiver") String receiver) {
        String writer = (String) session.getAttribute("username");
        supportService.addMessage(answer, writer, receiver);
        return "redirect:/adminPage/supportAdmin";
    }
    @PostMapping("/adminPage/productAdmin/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/adminPage/productAdmin";
    }
    @PostMapping("/adminPage/userList/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        User user = userOptional.get();
        String username = user.getName();
        if (!(username.equals( "Administrator"))) {
            userService.deleteUser(id);
            }
        return "redirect:/adminPage/userList";
    }
}
