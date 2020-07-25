package Amazon;

import java.util.Arrays;
import java.util.List;

/**
 * Created by maharsu on 6/29/20.
 */
public class test3 {

    static int[] valid_neighbor_X = new int[]{-1, 0, 0, 1,};
    static int[] valid_neighbor_Y = new int[]{0, -1, 1, 0};

    static boolean isValidNeighbor(int x, int y, int rows, int columns) {
        return (x >= 0 && x < rows) && (y >= 0 && y < columns);
    }

    static void DFS(int x, int y, int[][] arrays, boolean[][] visited, int rows, int columns) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int _x = x + valid_neighbor_X[i];
            int _y = y + valid_neighbor_Y[i];
            if (isValidNeighbor(_x, _y, rows, columns)) {
                if (!visited[_x][_y] && arrays[_x][_y] == 1) {
                    DFS(_x, _y, arrays, visited, rows, columns);
                }
                visited[_x][_y] = true;
            }
        }
    }

    static int numberAmazonTreasureTrucks(int rows, int column,
                                          List<List<Integer>> grid) {

        int[][] arrays = new int[rows][column];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                arrays[i][j] = grid.get(i).get(j);
            }
        }

        boolean[][] visited = new boolean[rows][column];

        int count = 0;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < column; y++) {
                if (arrays[x][y] == 1 && !visited[x][y]) {
                    DFS(x, y, arrays, visited, rows, column);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(1, 1, 0, 0);
        List<Integer> row2 = Arrays.asList(0, 0, 0, 0);
        List<Integer> row3 = Arrays.asList(0, 0, 1, 1);
        List<Integer> row4 = Arrays.asList(0, 0, 0, 0);
        int count = numberAmazonTreasureTrucks(4, 4, Arrays.asList(row1, row2, row3, row4));
        System.out.println("Graph count: " + count);

        List<Integer> row_1 = Arrays.asList(1, 0, 0, 0, 0, 0, 0);
        List<Integer> row_2 = Arrays.asList(0, 1, 0, 0, 0, 0, 0);
        List<Integer> row_3 = Arrays.asList(0, 0, 1, 0, 0, 0, 0);
        List<Integer> row_4 = Arrays.asList(0, 0, 0, 1, 0, 0, 0);
        List<Integer> row_5 = Arrays.asList(0, 0, 0, 0, 1, 0, 0);
        List<Integer> row_6 = Arrays.asList(0, 0, 0, 0, 0, 1, 0);
        List<Integer> row_7 = Arrays.asList(0, 0, 0, 0, 0, 0, 1);
        int count1 = numberAmazonTreasureTrucks(7, 7, Arrays.asList(row_1, row_2, row_3, row_4, row_5, row_6, row_7));
        System.out.println("Graph count: " + count1);
    }
}
