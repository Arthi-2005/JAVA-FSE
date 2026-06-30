// REST = Representational State Transfer
// API style using HTTP methods

public class RESTDemo {
    public static void main(String[] args) {
        System.out.println("=== REST API Basics ===");
        System.out.println();
        System.out.println("HTTP Methods (CRUD):");
        System.out.println("  GET     - Read data");
        System.out.println("  POST    - Create new");
        System.out.println("  PUT     - Update existing");
        System.out.println("  DELETE  - Remove");
        System.out.println();
        System.out.println("Status Codes:");
        System.out.println("  200 OK      - Success");
        System.out.println("  201 Created - Resource created");
        System.out.println("  400 Bad Request - Invalid input");
        System.out.println("  404 Not Found   - Resource missing");
        System.out.println("  500 Server Error - Something broke");
        System.out.println();
        System.out.println("REST in Spring:");
        System.out.println("  @RestController - API class");
        System.out.println("  @GetMapping     - Handle GET");
        System.out.println("  @PostMapping    - Handle POST");
        System.out.println("  @PathVariable   - From URL: /users/{id}");
        System.out.println("  @RequestBody    - JSON body");
    }
}