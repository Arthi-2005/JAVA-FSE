// Global Exception Handler = One place to handle ALL errors
// No more try-catch in every method!

public class ExceptionHandlerDemo {
    public static void main(String[] args) {
        System.out.println("=== Global Exception Handler ===");
        System.out.println();
        System.out.println("Problem: try-catch in EVERY controller method");
        System.out.println();
        System.out.println("Solution: ONE global handler");
        System.out.println("  @RestControllerAdvice");
        System.out.println("  class GlobalExceptionHandler {");
        System.out.println("      @ExceptionHandler(ResourceNotFound.class)");
        System.out.println("      public ResponseEntity<?> handleNotFound() {");
        System.out.println("          return ResponseEntity.status(404).body('Not found');");
        System.out.println("      }");
        System.out.println("  }");
        System.out.println();
        System.out.println("Now controllers just throw exceptions!");
        System.out.println("  throw new ResourceNotFoundException('User not found');");
        System.out.println("  -> Automatically returns 404 with message");
    }
}