import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取矩阵的大小
        System.out.print("Enter the size of the square matrix (n): ");
        int n = scanner.nextInt();

        // 读取矩阵元素
        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 判断是否为幻方
        if (isMagicSquare(matrix, n)) {
            System.out.println("The matrix is a magic square.");
        } else {
            System.out.println("The matrix is not a magic square.");
        }
    }

    // 判断矩阵是否为幻方
    public static boolean isMagicSquare(int[][] matrix, int n) {
        int magicSum = 0;
        for (int i = 0; i < n; i++) {
            magicSum += matrix[0][i];
        }

        // 检查每一行的和
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        // 检查每一列的和
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        // 检查对角线的和
        int diag1Sum = 0;
        int diag2Sum = 0;
        for (int i = 0; i < n; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][n - 1 - i];
        }
        if (diag1Sum != magicSum || diag2Sum != magicSum) {
            return false;
        }

        // 检查矩阵是否包含从1到n^2的所有整数
        boolean[] seen = new boolean[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 1 || matrix[i][j] > n * n || seen[matrix[i][j]]) {
                    return false;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return true;
    }
}
