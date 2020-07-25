package DataStructure.graph;

/**
 * Created by root on 2020-02-06.
 */
public class TwoDtoGraph {

    static int X = 5;
    static int Y = 5;

    static boolean[][] visited = new boolean[X][Y];

    static int[] neighbor_X = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] neighbor_Y = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean isValidNeighbor(int x, int y) {
        return (x >= 0 && x < X) && (y >= 0 && y < Y);
    }


    static void DFS(int x, int y, int[][] arrays) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int _x = x + neighbor_X[i];
            int _y = y + neighbor_Y[i];
            if (isValidNeighbor(_x, _y)) {
                if (!visited[_x][_y] && arrays[_x][_y] == 1) {
                    DFS(_x, _y, arrays);
                }
                visited[_x][_y] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0}
        };
        int count = 0;
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                if (arrays[x][y] == 1 && !visited[x][y]) {
                    DFS(x, y, arrays);
                    count++;
                }
                visited[x][y] = true;
            }
        }
        System.out.println("Graph count: " + count);
    }
}
