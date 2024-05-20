package com.marketplace.marketproject.models;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
    List<Product> findByAuthor(String author);
    List<Product> findByAuthorIsNot(String author);
}
