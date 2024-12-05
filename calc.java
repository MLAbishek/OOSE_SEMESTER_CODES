import java.util.*;

public class calc {
    public static void add(int x, int y) {
        System.out.println(x + y);
    }

    public static void sub(int x, int y) {
        System.out.println(x - y);
    }

    public static void mul(int x, int y) {
        System.out.println(x * y);
    }

    public static void div(int x, int y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("Cannot divide by zero");

        }
        System.out.println(x / y);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.print("Enter the option:");
            int o = sc.nextInt();
            System.out.println("Enter the numbers");
            int a = sc.nextInt();
            int b = sc.nextInt();
            switch (o) {
                case 1:
                    add(a, b);
                    return;
                case 2:
                    sub(a, b);
                    return;
                case 3:
                    mul(a, b);
                    return;
                case 4:
                    div(a, b);
                    return;
                case 5:
                    break;
                default:
                    throw new IllegalArgumentException("Not a number");

            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException f) {
            System.out.println(f.getMessage());
        } catch (Exception g) {
            System.out.println(g.getMessage());
        } finally {
            sc.close();
        }
    }
}
