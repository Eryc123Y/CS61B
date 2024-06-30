import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取行数
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int numRows = scanner.nextInt();

        // 生成帕斯卡三角形
        List<List<Integer>> pascalTriangle = generatePascalTriangle(numRows);

        // 打印帕斯卡三角形
        printPascalTriangle(pascalTriangle);
    }

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void printPascalTriangle(List<List<Integer>> pascalTriangle) {
        for (List<Integer> row : pascalTriangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
