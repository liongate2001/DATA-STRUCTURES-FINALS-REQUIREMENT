import java.util.Scanner;

public class FinalRequirementYambotAndTequillo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter a comma-separated list of alphabetic characters in both lower and upper case:");

        // Read input from the user
        String input = scanner.nextLine();

        // Validate input and ask for input again if invalid
        if (!isValidInput(input)) {
            System.out.println("Invalid input. Please make sure to enter a valid list of alphabetic characters separated by commas.");
            main(args); // Recursively ask for input again
        } else {
            // Split the input into an array of strings
            String[] inputArray = input.split(",");

            // Convert array to char array for sorting
            char[] charArray = new char[inputArray.length];
            for (int i = 0; i < inputArray.length; i++) {
                charArray[i] = inputArray[i].charAt(0);
            }

            // Sort the array using Shell sort
            shellSort(charArray);

            // Display the sorted output
            System.out.println("Sorted Output:");
            for (char character : charArray) {
                System.out.print(character + " ");
            }
            System.out.println();

            // Ask user to run again or exit
            System.out.println("Do you want to run again? (yes/no)");
            String runAgain = scanner.nextLine().toLowerCase();
            if (runAgain.equals("yes")) {
                main(args); // Recursively run the program again
            } else {
                System.out.println("Exiting program. Goodbye!");
            }
        }
    }

    // Function to validate input
    private static boolean isValidInput(String input) {
        // Check for at least one alphabet character followed by zero or more alphabet characters separated by commas
        return input.matches("^[azA-Z]+(,[a-zA-Z]+)*$") && !containsNumeric(input) && !containsFloatingPoint(input) && !containsSpecialCharacter(input);
    }

    // Check if input contains numerical characters
    private static boolean containsNumeric(String input) {
        return input.matches(".*\\d.*");
    }

    // Check if input contains floating point numbers
    private static boolean containsFloatingPoint(String input) {
        return input.matches(".*\\d+\\.\\d+.*");
    }

    // Check if input contains special characters
    private static boolean containsSpecialCharacter(String input) {
        return !input.matches("^[a-zA-Z]+(,[a-zA-Z]+)*$");
    }

    // Shell sort implementation for char array
    private static void shellSort(char[] array) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                char temp = array[i];
                int j;

                for (j = i; j >= gap && temp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }
        }
    }
}
