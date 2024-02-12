package com.example.International_Review.controller;

import com.example.International_Review.model.Product;
import com.example.International_Review.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * ArticlesController - класс обработки запросов на добавление и удаление публикаций, используемый редактором.
 */
@Controller
@Log
public class ArticlesController {
    Product publication;
    @Autowired
    ProductService productService;

    /**
     * Адрес стартовой страницы: "/"
     */
    @GetMapping("/")
    public String indexHtml(Model model) {
        model.addAttribute(productService.getAllProducts());
        return "index";
    }

    /**
     * addProduct - метод обработки запроса на добавление публикаций.
     *
     * @param product - публикация
     * @param model   - модель
     * @return возвращает стартовую страницу
     */
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Product product, Model model) {
        System.out.println(product);
        productService.saveProduct(product);
        model.addAttribute(productService.getAllProducts());
        return "index";
    }

    /**
     * delProduct - метод обработки запроса на удаление публикации с заданным ID.
     *
     * @param article - номер артикула
     * @param model   - модель.
     * @return переход на стартовую страницу.
     */
    @GetMapping("/del/{article}")
    public String delProduct(@PathVariable int article, Model model) {
        System.out.println(article);
        productService.delProductByArticle(article);
        model.addAttribute(productService.getAllProducts());
        return "index";
    }
}
