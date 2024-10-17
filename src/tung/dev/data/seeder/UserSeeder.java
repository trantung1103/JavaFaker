package tung.dev.data.seeder;

import tung.dev.data.dao.Database;
import tung.dev.data.dao.DatabaseDao;
import tung.dev.data.dao.UserDao;
import tung.dev.data.model.User;

import com.github.javafaker.Faker;

public class UserSeeder {
	// Khai báo thuộc tính userDao
    private UserDao userDao;

    // Khởi tạo đối tượng Faker
    private Faker faker;
    
	public UserSeeder(UserDao userDao) {
		 this.faker = new Faker();
	     this.userDao = userDao;
	}
	
	public void seedUsers(int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            // Tạo thông tin người dùng giả mạo
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();
            String role = faker.job().position();

            // Khởi tạo đối tượng User với thông tin giả mạo
            User user = new User(email, password, role);

            // Chèn người dùng vào cơ sở dữ liệu
            userDao.insert(user);

            // In ra thông tin người dùng để kiểm tra
            System.out.println("Inserted User: " + email + " | " + password + " | " + role);
        }
    }
	
}
