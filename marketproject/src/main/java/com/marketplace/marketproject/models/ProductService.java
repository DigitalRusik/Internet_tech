package com.marketplace.marketproject.models;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private static UserRepository userRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void createProduct(Product product/*, MultipartFile file1, MultipartFile file2, MultipartFile file3*/) {
        /*Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0){
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0){
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }*/
        Product productFromDb = productRepository.save(product);
        //productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    public List<Product> getAllProducts(String title) {
        if (title != null && title != "")
            return productRepository.findByTitle(title);
        return productRepository.findAll();
    }
    public List<Product> getAllProductsExceptAuthor(String author, String title)
    {
        if (title != null && title != "")
            return productRepository.findByTitle(title);
        return productRepository.findByAuthorIsNot(author);
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getProductByTitle(String title) {if (title != null)  return productRepository.findByTitle(title);
        return productRepository.findAll();}
    public List<Product> getProductsByAuthor(String author) {
        return productRepository.findByAuthor(author);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
