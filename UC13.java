import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    public static boolean reverseStringMethod(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        return str.equals(reversed);
    }

    public static boolean charArrayMethod(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start1 = System.nanoTime();
        boolean result1 = reverseStringMethod(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = charArrayMethod(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = stackMethod(input);
        long end3 = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Reverse String Method: " + result1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Character Array Method: " + result2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Stack Method: " + result3 + " | Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}
