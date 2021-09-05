import dao.UserDao;
import model.User;

public class JpaDemoApplication {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("river-and-boat", 20);
        userDao.add(user);
    }
}
