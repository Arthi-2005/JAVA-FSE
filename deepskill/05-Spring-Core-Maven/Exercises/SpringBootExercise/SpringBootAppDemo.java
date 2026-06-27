import java.util.*;

public class SpringBootAppDemo {

    static class GreetingController {
        public String sayHello(String name) {
            return "Hello, " + name + "! Welcome to Spring Boot!";
        }

        public String sayGoodbye(String name) {
            return "Goodbye, " + name + "! Have a great day!";
        }
    }

    static class UserService {
        private Map<Long, String> users = new HashMap<>();
        private long nextId = 1;

        public long addUser(String name) {
            long id = nextId++;
            users.put(id, name);
            System.out.println("User added: id=" + id + ", name=" + name);
            return id;
        }

        public String getUser(Long id) {
            return users.get(id);
        }

        public List<String> getAllUsers() {
            return new ArrayList<>(users.values());
        }

        public boolean deleteUser(Long id) {
            return users.remove(id) != null;
        }
    }

    static class ApplicationRunner {
        public void run(String[] args) {
            System.out.println("========================================");
            System.out.println("  Spring Boot Application Started");
            System.out.println("========================================");

            GreetingController controller = new GreetingController();
            System.out.println(controller.sayHello("Arthi"));
            System.out.println(controller.sayGoodbye("Arthi"));

            UserService userService = new UserService();
            userService.addUser("Alice");
            userService.addUser("Bob");
            userService.addUser("Charlie");

            System.out.println("\n--- All Users ---");
            for (String user : userService.getAllUsers()) {
                System.out.println(" - " + user);
            }

            System.out.println("\n--- Get User 2 ---");
            System.out.println("User 2: " + userService.getUser(2L));

            System.out.println("\n--- Delete User 1 ---");
            userService.deleteUser(1L);

            System.out.println("\n--- After Deletion ---");
            for (String user : userService.getAllUsers()) {
                System.out.println(" - " + user);
            }

            System.out.println("\n========================================");
            System.out.println("  Spring Boot Application Stopped");
            System.out.println("========================================");
        }
    }

    public static void main(String[] args) {
        ApplicationRunner runner = new ApplicationRunner();
        runner.run(args);
    }
}
