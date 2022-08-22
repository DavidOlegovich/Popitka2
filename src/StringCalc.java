import java.util.Scanner;

public class StringCalc {
    private static final Scanner scanner = new Scanner(System.in);
    private static String result = "";

    public static void main(String[] args) throws Exception {
        String userInput = scanner.nextLine();

        String oper = userInput.replaceAll("[^+\\-*/]", "");

        String[] blocks = userInput.split("[" + oper + "]");
        if (!blocks[0].startsWith("\"")) {
            throw new Exception("Pervim operantom doljen bit tekst");
        }

        String left = blocks[0].trim().replaceAll("\"", "");
        String right = blocks[1].trim().replaceAll("\"", "");
        if (left.length() > 10 || right.length() > 10) {
            throw new Exception("Dlina stroki bolee 10 simvolov");
        }


        String result = "";
        switch (oper) {
            case "+": {
                result = left.concat(right);
                break;
            }
            case "-": {
                result = left.replaceAll(right, "");
                break;
            }
            case "*": {
                int n = Integer.parseInt(right);
                if (n < 1 || n > 10) {
                    throw new Exception("Nedopystimoe chislo");
                }
                for (int i = 0; i < n; i++) {
                    result += left;
                }
                break;
            }
            case "/": {
                int n = Integer.parseInt(right);
                if (n < 1 || n > 10) {
                    throw new Exception("Nedopystimoe chislo");
                }
                result = left.substring(0, left.length() / n);
                break;
            }
        }
        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }
        System.out.println("\"" + result + "\"");
    }
}
