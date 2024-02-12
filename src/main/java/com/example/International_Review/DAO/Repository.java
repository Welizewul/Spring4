package com.example.International_Review.DAO;

import com.example.International_Review.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Repository - интерфейс, реализующий методы управления базой данных.
 */
@Service
public interface Repository {
    List<Product> getAllProducts();            // Получить все публикации.

    Product getProductByArticle(int article);  // Получить публикацию по id.

    List<Product> findProduct(String pattern); // Поиск публикации по строке запроса.

    void saveProduct(Product product);          // Запрос статьи из БД.

    void delProductByArticle(int article);     // Удаление статьи из БД.
}