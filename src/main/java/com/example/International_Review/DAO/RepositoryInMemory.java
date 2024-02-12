package com.example.International_Review.DAO;

import com.example.International_Review.model.Product;
import lombok.NonNull;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * RepositoryInMemory - репозиторий внутреннего хранилища в ОЗУ без базы данных.
 */
@Service
@Primary
public class RepositoryInMemory implements Repository {
    List<Product> productList;
    private final ReentrantLock lock = new ReentrantLock();

    public RepositoryInMemory(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * getAllProducts - метод вывода всех публикаций.
     *
     * @return - список статей.
     */
    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    /**
     * Поиск публикации по ее id.
     *
     * @param article номер публикации.
     * @return товар
     */
    @Override
    public Product getProductByArticle(int article) {
        if (productList.isEmpty()) return null;
        lock.lock();
        Product result = productList.stream()
                .filter(product -> product.getArticle() == article)
                .findFirst().orElse(null);
        lock.unlock();
        return result;
    }

    /**
     * findProduct - метод, реализующий поиск публикации по строке запроса.
     *
     * @param pattern строка запроса.
     * @return список статей.
     */
    @Override
    public List<Product> findProduct(@NonNull String pattern) {
        if (productList.isEmpty()) return new ArrayList<>();
        lock.lock();
        List<Product> result = productList.stream()
                .filter(product -> {
                    try {
                        if (product.getTitle().contains(pattern) ||
                                product.getDescription().contains(pattern)) return true;
                        return product.getArticle() == Integer.parseInt(pattern) ||
                                product.getCost() == Double.parseDouble(pattern);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }).collect(Collectors.toList());
        lock.unlock();
        return result;
    }

    /**
     * saveProduct - метод сохранения публикации в базу данных.
     *
     * @param product публикация.
     */
    @Override
    public synchronized void saveProduct(@NonNull Product product) {
        lock.lock();
        productList.add(product);
        lock.unlock();
    }

    /**
     * delProductByArticle - удаление публикации по id.
     *
     * @param article артикул публикации.
     */
    @Override
    public synchronized void delProductByArticle(int article) {
        if (productList.isEmpty()) return;
        lock.lock();
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product pr = iterator.next();
            if (pr.getArticle() == article) {
                iterator.remove();
                break;
            }
        }
        lock.unlock();
    }
}