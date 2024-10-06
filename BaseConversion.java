import java.util.Scanner;

/**
 * The BaseConversion class converts both positive and
 * negative decimal numbers into a new user-specified base
 * by utilizing a recursive base expansion / base conversion
 * algorithm. This class also converts numbers greater than ten
 * to characters of the alphabet.
 *
 * @author Jake Alsept
 * @version 1.1
 */
public class BaseConversion {

    /**
     * @param q - the decimal number being converted.
     * @param b - the base to convert to.
     * @param a - a string that will hold the base expansion.
     * @return - the converted number in string form.
     */
    private static String convert(int q, int b, String a) {

        int remainder;

        if (q == 0 && !(a.isEmpty())) {
            return a;
        }

        remainder = q % b;
        if (remainder > 9) {
            a = (char)('A' + (remainder - 10)) + a;
        } else {
            a = (q % b) + a;
        }
        return convert((q / b), b, a);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int q, b;
        String conversion, response;
        boolean repeat = true;
        boolean isNegative = false;

        while (repeat) {
            System.out.print("Enter an integer to convert: ");
            q = scanner.nextInt();
            if (q < 0) {
                isNegative = true;
                q *= -1;
            }

            System.out.print("Enter a new base from 2 to 20: ");
            b = scanner.nextInt();
            if (b < 2 || b > 20) {
                System.out.println("** ERROR: New base must be between 2 and " +
                        "20. **");
                while (b < 2 || b > 20) {
                    System.out.print("Please enter a base from 2 to 20: ");
                    b = scanner.nextInt();
                }
            }

            conversion = convert(q, b, "");

            if (isNegative) {
                System.out.println("\n" + q + " in base " + b + " is: -" + conversion + "\n");
            }
            else {
                System.out.println("\n" + q + " in base " + b + " is: " + conversion + "\n");
            }
            scanner.nextLine();

            System.out.print("Would you like to perform another conversion?" + "\nY / N: ");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("no") ||
                    response.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                repeat = false;
            }
        }
    }
}