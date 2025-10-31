public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("I add two numbers");
        int firstNumber = 5;
        int secondNumber = 7;
        int sum = add(firstNumber, secondNumber);
        System.out.println("Sum: " + sum);
    }
    public static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}