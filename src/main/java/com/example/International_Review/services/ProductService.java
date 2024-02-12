package com.example.International_Review.services;

import com.example.International_Review.DAO.Repository;
import com.example.International_Review.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductService - служебный класс, реализующий методы работы с репозиторием.
 */
@Service
public class ProductService {
    @Autowired
    Repository productsRepository;

    /**
     * getAllProducts - метод получения всех публикаций.
     *
     * @return - список статей.
     */
    public List<Product> getAllProducts() {
        return productsRepository.getAllProducts();
    }

    /**
     * getProductByArticle - метод получения публикации по ее номеру.
     *
     * @param article - номер статьи.
     * @return - статья.
     */
    public Product getProductByArticle(int article) {
        return productsRepository.getProductByArticle(article);
    }

    /**
     * findProduct - метод получения списка публикаций по совпадению строки поиска.
     *
     * @param pattern - строка поиска.
     * @return - список публикаций.
     */
    public List<Product> findProduct(String pattern) {
        return productsRepository.findProduct(pattern);
    }

    /**
     * saveProduct - метод добавления публикации в базу данных.
     *
     * @param product - статья.
     */
    public void saveProduct(Product product) {
        productsRepository.saveProduct(product);
    }

    /**
     * delProductByArticle - метод удаления публикации из базы данных по ее id.
     */
    public void delProductByArticle(int article) {
        productsRepository.delProductByArticle(article);
    }
}