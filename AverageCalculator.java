import java.util.ArrayList;

public class AverageCalculator {
    public static void main(String[] args) {
        // Create an ArrayList to store numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add numbers to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Calculate the sum of the numbers
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Calculate the average of the numbers
        double average = (double) sum / numbers.size();

        // Print the average
        System.out.println("The average of the numbers is: " + average);
    }
}