import java.util.concurrent.ThreadLocalRandom;
import model.Department;
import model.ResultTO;
import model.User;

public class OptionalDemoApp {
    public static void main(String[] args) {
        ResultTO<User> resultTO = getUserByName("demo");
        String result = NullWrapper.ofNullable(resultTO)
                .map(ResultTO::getData)
                .map(User::getDepartment)
                .map(Department::getName)
                .orElse("未知部门");
        System.out.println(result);
    }

    public static ResultTO<User> getUserByName(String username) {
        if (username == null || "".equals(username)) {
            return null;
        }

        Department department;
        User user;

        if (ThreadLocalRandom.current().nextBoolean()) {
            department = new Department("总裁办", 10086);
        } else {
            department = new Department("空财办", 10086);;
        }
        if (ThreadLocalRandom.current().nextBoolean()) {
            user = new User("周董", 18, department);
            user.setDepartment(department);
        } else {
            user = new User("我也无", 18, department);
            user.setDepartment(department);
        }

        return ResultTO.buildSuccess(user);
    }

}
