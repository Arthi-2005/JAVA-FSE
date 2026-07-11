public class ExceptionDebugDemo {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", null, "Charlie"};
        
        for (int i = 0; i <= names.length; i++) {
            try {
                int length = names[i].length();
                System.out.println(names[i] + " has " + length + " characters.");
            } catch (NullPointerException e) {
                System.out.println("Null value at index " + i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + i + " is out of bounds.");
            }
        }
    }
}
