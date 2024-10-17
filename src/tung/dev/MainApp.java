package tung.dev;

import tung.dev.data.dao.CategoryDao;
import tung.dev.data.dao.Database;
import tung.dev.data.dao.DatabaseDao;
import tung.dev.data.dao.OrderDao;
import tung.dev.data.dao.OrderItemDao;
import tung.dev.data.dao.ProductDao;
import tung.dev.data.dao.UserDao;
import tung.dev.data.impl.CategoryImpl;
import tung.dev.data.impl.UserImpl;
import tung.dev.data.model.Category;
import tung.dev.data.model.Order;
import tung.dev.data.model.OrderItem;
import tung.dev.data.model.Product;
import tung.dev.data.model.User;
import tung.dev.data.seeder.CategorySeeder;
import tung.dev.data.seeder.ProductSeeder;
import tung.dev.data.seeder.UserSeeder;

import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			DatabaseDao.init(new Database());
			Faker faker = new Faker();
			
			// Lấy đối tượng UserDao thông qua DatabaseDao
	        UserDao userDao = DatabaseDao.getInstance().getUserDao();

	        // Khởi tạo UserSign với UserDao đã lấy được
	        UserSeeder userSign = new UserSeeder(userDao);

	        // Gọi phương thức seedUsers để tạo dữ liệu giả cho bảng user
	        userSign.seedUsers(0);

	        
	        
	        // Category Seeder
	        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
	        CategorySeeder categorySeeder = new CategorySeeder(categoryDao);
	        categorySeeder.seedCategories(0);

	        // Product Seeder
	        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
	        ProductSeeder productSeeder = new ProductSeeder(productDao, categoryDao);
	        productSeeder.seedProducts(2);
	        
	        System.out.println("Seeded fake users successfully!");
			
	}
	
}
