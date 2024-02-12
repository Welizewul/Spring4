package com.example.International_Review.DAO;

import com.example.International_Review.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * RepositoryH2 - класс, реализующий методы управления данными в БД Н2.
 */
public class RepositoryH2 implements Repository {
    JdbcTemplate jdbc;

    public RepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод getAllProducts выполняет SQL-запрос SELECT * FROM products с помощью JDBC-шаблона,
     * извлекает данные из результирующего набора и создает объекты Product для каждой записи.
     * Затем он возвращает список всех публикаций. Для каждой записи в результате запроса создается
     * объект Product, в который затем устанавливаются значения из соответствующих столбцов результата запроса,
     * после чего этот объект добавляется в итоговый список.
     *
     * @return - список всех полученных публикаций.
     */
    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * From products";
        return jdbc.query(sql, (resultSet, i) -> {
            Product product = new Product();
            product.setArticle(resultSet.getInt("article"));
            product.setCost(resultSet.getDouble("cost"));
            product.setTitle(resultSet.getString("title"));
            product.setDescription(resultSet.getString("description"));
            product.setImageURL(resultSet.getString("imageURL"));
            return product;
        });
    }

    /**
     * getProductByArticle выполняет SQL-запрос для извлечения публикации по заданному id (артикулу).
     * Происходит подстановка артикула в параметр запроса, затем вызывается jdbc.queryForObject
     * для выполнения запроса и преобразования результата в объект Product.
     * Полученный объект Product затем возвращается в качестве результата метода.getProductByArticle.
     *
     * @return - объект Product.
     */
    @Override
    public Product getProductByArticle(int article) {
        String sql = "select * from products where article = ?";
        return jdbc.queryForObject(sql, Product.class, article);
    }

    // Методы, подлежащие реализации.
    @Override
    public List<Product> findProduct(String pattern) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        String sql = "Insert into products ()";
    }

    @Override
    public void delProductByArticle(int article) {
    }
}