import java.util.InputMismatchException;
import java.util.Scanner;

public class Class {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result = "";

    private static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    public static void main(String[] args) {
        while (true) {
            result = "";
            System.out.println("Suda to chyo chitat' ");

            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                exit();
            }
            char[] uchar = new char[26];
            for (int i = 0; i < userInput.length(); i++) {
                uchar[i] = userInput.charAt(i);
                if (uchar[i] == '+') {
                    operation = '+';
                }
                if (uchar[i] == '-') {
                    operation = '-';
                }
                if (uchar[i] == '*') {
                    operation = '*';
                }
                if (uchar[i] == '/') {
                    operation = '/';
                }
            }

            String[] blocks = userInput.split("[+-/*\"]");

            if (blocks.length == 5) {
                String st00 = blocks[0];
                String st01 = blocks[1];
                String st04 = blocks[4];
                result = calculated(st01, st04, operation);
                if (result.length() > 10) {
                    String rez = result.substring(0, 10);
                    System.out.println("fatal error");
                    break;
                } else {
                    System.out.println(result);
                }
            } else {
                String st01 = blocks[1];
                String st03 = null;
                try {
                    st03 = blocks[3];
                } catch (ArrayIndexOutOfBoundsException e) {


                    System.out.println("Tut chto-to ne to");
                }
                try {
                    number = Integer.parseInt(st03);
                    result = calculated(st01, number, operation);
                } catch (NumberFormatException e) {

                    System.out.println("Tut chto-to ne to");
                }

                if (result.length() > 10) {
                    String rez = result.substring(0, 10);
                    System.out.println("fatal error");
                    break;
                } else {
                    System.out.println(result);
                }
            }
        }
    }


    public static String calculated(String num1, String num2, char op) {

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                boolean cb = num1.contains(num2);
                if (cb) {
                    int resA = num1.length() - num2.length();
                    result = num1.substring(0, resA);
                } else {
                    result = num1;
                }
                if (cb & num1.length() == num2.length()) {
                    result = "0";
                }
                break;
            case '*':
                System.out.println("Umnojat nelzia");
                break;
            case '/':
                System.out.println("Delit nelzia");
                break;
            default:
                throw new IllegalArgumentException("Tut chto-to ne to");
        }
        return result;
    }

    public static String calculated(String num1, int num, char op) {

        switch (op) {
            case '+':
                System.out.println("summirovat' nelzia");

                break;
            case '-':
                System.out.println("Vichitat' nelzia");
                break;
            case '*':
                for (int u = 0; u < num; u++) {
                    result = result + num1;
                }
                break;
            case '/':
                try {
                    int resB = num1.length() / num;
                    if (num1.length() == num) {
                        result = "1";
                    } else {
                        result = num1.substring(0, resB);
                    }
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Tak ne poidet" );
                    break;
                } finally {
                    if (num1.length() < num) {
                        System.out.println("Mi v minus ne idem, chao");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Tut chto-to ne to");
        }
        return result;
    }
}