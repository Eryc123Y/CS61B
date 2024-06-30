import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        //basePrint();
        //angleConvert2(-720);
        //System.out.println(biggest());
        //randLong();
        lottery();
    }

    // 1. Convert a decimal to bin oct and hex.
    public static void basePrint() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        while (true) {
            System.out.println("Enter an integer: ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }

        String bin = Integer.toBinaryString(num);
        String oct = Integer.toOctalString(num);
        String hex = Integer.toHexString(num);


        StringBuilder output = new StringBuilder();
        output.append("Binary: ").append(bin).append("\n");
        output.append("Octal: ").append(oct).append("\n");
        output.append("Hexadecimal: ").append(hex);

        System.out.println(output);
    }

    public static void angleConvert(int angle) {
        if (angle < 0) {
            angle = (angle % 360 + 360) % 360;
        } else {
            angle %= 360;
        }

        System.out.printf("The angle is %d degree.%n", angle);
    }


    public static void angleConvert2(int angle) {
        angle = Math.floorMod(angle, 360);
        System.out.printf("The angle is %d degree.%n", angle);
    }

    public static int biggest() {
        var in = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            System.out.printf("Input the %dth number\n", i+1);
            int num = in.nextInt();
            nums.add(num);
        }
        var max = Float.NEGATIVE_INFINITY;
        for (int num: nums) {
            if (num > max) {
                max = num;
            }
        }

        return (int) max;
    }

    public static void randLong() {
        var rand = new Random();
        var num = rand.nextLong();
        var str = Long.toString(num, 36);

        System.out.print(str);
    }

    public static void lottery() {
        var numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }

        StringBuilder res = new StringBuilder();
        var rand = new Random();
        for (int i = 0; i < 6; i++) {
            int rd = rand.nextInt(1, 49);
            while (!numbers.contains(rd)) {
                rd = rand.nextInt(1, 49);
            }
            res.append(Integer.toString(rd));
            res.append(' ');
            numbers.remove(rd);
        }
        var last = res.lastIndexOf(" ");
        res.deleteCharAt(last);
        System.out.printf("The lottery number is: %s.", res);
    }
}
