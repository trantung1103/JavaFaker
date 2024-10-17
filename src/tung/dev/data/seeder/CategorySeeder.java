package tung.dev.data.seeder;

import tung.dev.data.dao.CategoryDao;
import tung.dev.data.model.Category;

import com.github.javafaker.Faker;

public class CategorySeeder {
	private CategoryDao categoryDao;
    private Faker faker;
    
    public CategorySeeder(CategoryDao categoryDao) {
        this.faker = new Faker();
        this.categoryDao = categoryDao;
    }
    
    public void seedCategories(int numberOfCategories) {
        for (int i = 0; i < numberOfCategories; i++) {
            String name = faker.commerce().department();
            String description = faker.lorem().sentence();

            // Khởi tạo đối tượng Category với thông tin giả mạo
            Category category = new Category(name, description);

            // Chèn Category vào cơ sở dữ liệu
            categoryDao.insert(category);

            // In ra thông tin Category để kiểm tra
            System.out.println("Inserted Category: " + name + " | " + description);
        }
    }
}
