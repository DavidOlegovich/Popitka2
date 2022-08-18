import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Class {


        static Scanner scanner = new Scanner(System.in);
        static int number;
        static char operation;
        static String result;

        public static void main(String[] args) {
            System.out.println("Suda to chyo chitat' ");
            String userInput = scanner.nextLine();
            char[] uchar = new char[26];
            ArrayList<String> strBlock00 = new ArrayList<>(10);
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
                String st02 = blocks[2];
                String st03 = blocks[3];
                String st04 = blocks[4];
                System.out.println("-" + st00 + "-");
                System.out.println("-" + st01 + "-");
                System.out.println("-" + st02 + "-");
                System.out.println("-" + st03 + "-");
                System.out.println("-" + st04 + "-");
                System.out.println(Arrays.toString(blocks));
                System.out.println(operation);
                result = calculated(st01, st04, operation);
                System.out.println(result);
            } else {
                String st01 = blocks[1];
                String st03 = blocks[3];
                System.out.println("-" + st01 + "-");
                System.out.println("-" + st03 + "-");
                System.out.println(Arrays.toString(blocks));
                System.out.println(operation);
                number = Integer.parseInt(st03);
                result = calculated(st01, number, operation);
                System.out.println(result);

            }


        }


        public static String calculated(String num1, String num2, char op) {

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    int resultA = num1.length() - num2.length();
                    result = num1.substring(0, resultA);
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
                        int resultB = num1.length() / num;
                        result = num1.substring(0, resultB);
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

