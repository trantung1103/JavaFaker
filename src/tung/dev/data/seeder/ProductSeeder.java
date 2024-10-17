package tung.dev.data.seeder;

import tung.dev.data.dao.CategoryDao;
import tung.dev.data.dao.ProductDao;
import tung.dev.data.model.Category;
import tung.dev.data.model.Product;

import com.github.javafaker.Faker;

import java.util.List;

public class ProductSeeder {
    private ProductDao productDao;
    private CategoryDao categoryDao;
    private Faker faker;

    public ProductSeeder(ProductDao productDao, CategoryDao categoryDao) {
        this.faker = new Faker();
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    public void seedProducts(int numberOfProducts) {
        List<Category> categories = categoryDao.findAll();
        for (int i = 0; i < numberOfProducts; i++) {
            String name = faker.commerce().productName();
            String description = faker.lorem().paragraph();
            String thumbnail = faker.internet().avatar();
            double price = faker.number().randomDouble(2, 10, 500);
            int quantity = faker.number().numberBetween(1, 100);
            int view = 0; // Giá trị mặc định cho cột view

            // Lấy ngẫu nhiên một Category
            int randomIndex = faker.random().nextInt(categories.size());
            Category category = categories.get(randomIndex);

            // Khởi tạo đối tượng Product với thông tin giả mạo và giá trị view
            Product product = new Product(0, name, description, thumbnail, price, quantity, view, category.getId(), null);

            // Chèn Product vào cơ sở dữ liệu
            productDao.insert(product);

            // In ra thông tin Product để kiểm tra
            System.out.println("Inserted Product: " + name + " | " + price + " | " + category.getName());
        }
    }
}
