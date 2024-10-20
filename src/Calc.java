import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int x;
        int y;
        String operation;
        String result;
        String[] operands = expression.split("[*/+-]");
        if (operands.length != 2) throw new Exception("Должно быть два операнда.");
        operation = detectOperation(expression);
        if (operation == null) throw new Exception("Допущена ошибка при вводе операции.");
        x = Integer.parseInt(operands[0]);
        y = Integer.parseInt(operands[1]);
        if (x > 10 || y > 10) {
            throw new Exception("Числа должны быть не больше 10.");
        }
        int numb = calc(x, y, operation);
        if (x <= 0 || y <= 0) {
            throw new Exception("Числа дожны быть больше нуля.");
        } else {
            result = String.valueOf(numb);
        }
        return result;
    }

    public static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    public static int calc(int x, int y, String operation) {
        if (operation.equals("+")) return x + y;
        else if (operation.equals("-")) return x - y;
        else if (operation.equals("*")) return x * y;
        else if (operation.equals("/")) return x / y;
        else throw new IllegalArgumentException("Неизвестная операция: " + operation);
    }
}
