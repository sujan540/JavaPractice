package DataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2020-02-07.
 */
public class TransitiveClosure {

    public static int NODE = 4;

    static class Vertex {
        int value;
        List<Vertex> vertices = new ArrayList<>();

        Vertex(int value) {
            this.value = value;
        }

    }

    static int[][] tc = new int[NODE][NODE];

    public static void dfs(Vertex node) {
        for (Vertex v : node.vertices) {
            if (tc[node.value][v.value] == 1) {
                continue;
            }
            tc[node.value][v.value] = 1;
            dfs(v);
        }
    }

    public static void main(String[] args) {
        Vertex zero = new Vertex(0);
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);

        zero.vertices.add(one);
        zero.vertices.add(two);

        one.vertices.add(two);
        two.vertices.add(zero);
        two.vertices.add(three);

        dfs(zero);

        for (int i = 0; i < NODE; i++) {
            for (int j = 0; j < NODE; j++) {
                System.out.print(tc[i][j] + " ");
            }
            System.out.println("");

        }


    }


}
