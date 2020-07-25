package Facebook;

public class SprialArray {

    public static int[][] anotherTry(int n) {

        int a = 0;
        int b = n - 1;
        int c = 0;
        int d = n - 1;

        int result[][] = new int[n][n];
        int counter = 1;
        while (counter <= n * n) {
            for (int i = a; i <= b; i++) {
                result[c][i] = counter++;
            }

            for (int i = c + 1; i <= d; i++) {
                result[i][b] = counter++;
            }
            c++;
            b--;
            for (int i = b; i >= a; i--) {
                result[d][i] = counter++;
            }
            for (int i = d - 1; i >= c; i--) {
                result[i][a] = counter++;
            }
            a++;
            d--;
        }

        return result;
    }

    public static int[][] genSpiral(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be >0");
        }
        int[] rowDirection = new int[]{0, 1, 0, -1};

        int[] colDirection = new int[]{1, 0, -1, 0};

        int direction = 0;
        int row = 0;
        int column = 0;

        int[][] matrix = new int[n][n];

        for (int val = 1; val <= n * n; val++) {
            matrix[row][column] = val;
            row = rowDirection[direction] + row;
            column = colDirection[direction] + column;
            System.out.println(val);
            if (isInvalid(matrix, row, column)) {
                row = row - rowDirection[direction];
                column = column - colDirection[direction];
                direction = (direction + 1) % 4;
                System.out.print("direction - ");
                System.out.println(direction);
                row = rowDirection[direction] + row;
                column = colDirection[direction] + column;
            }
        }
        return matrix;
    }

    private static boolean isInvalid(int[][] m, int row, int column) {
        return row < 0 || column < 0 || row >= m.length || column >= m.length || m[row][column] != 0;
    }

    static int[][] sprial(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] result = new int[n][n];

        int counter = 0;

        for (int loop = 0; loop <= n / 2; loop++) {
            for (int i = loop; i < n - loop; i++) {
                result[loop][i] = ++counter;
            }
            for (int i = 1 + loop; i < n - loop; i++) {
                result[i][n - 1 - loop] = ++counter;
            }

            result = rotate180(result);

            for (int i = 1 + loop; i < n - loop; i++) {
                result[loop][i] = ++counter;
            }
            for (int i = 1 + loop; i < n - 1 - loop; i++) {
                result[i][n - 1 - loop] = ++counter;
            }

            result = rotate180(result);
        }
        return result;
    }

    static int[][] rotate180(int[][] array) {

        int[][] temp = new int[array.length][array.length];

        for (int x = array.length - 1; x >= 0; x--) {
            for (int y = array.length - 1; y >= 0; y--) {
                temp[(array.length - 1) - x][(array.length - 1) - y] = array[x][y];
            }
        }
        return temp;
    }

    public static void main(String[] args) {

        int[][] result = anotherTry(4);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print("[" + result[i][j] + "]");
            }
            System.out.println();
        }

    }
}
