public class ConditionalDebugDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Checking index " + i + ": " + numbers[i]);
            if (numbers[i] == target) {
                System.out.println("Found target at index " + i);
            }
        }
    }
}
