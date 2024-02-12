package com.example.International_Review.model;

import lombok.*;

/**
 * Publication - класс, определяющие характеристики информационного продукта.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private String title;         // Автор.
    private int article;          // ID публикации.
    private String description;   // Текст статьи.
    private double cost;          // Гонорар.
    private String imageURL;      // Иллюстрация к статье.

    /**
     * Метод добавления иллюстрации к статье.
     * @param imageURL - фото.
     */
    public void setImageURL(String imageURL) {
        if ("".equals(imageURL)) this.imageURL = "/img/no-photo.jpg";
        else this.imageURL = imageURL;
    }
}