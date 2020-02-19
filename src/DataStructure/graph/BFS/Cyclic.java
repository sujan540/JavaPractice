package DataStructure.graph.BFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 2020-02-19.
 */
public class Cyclic {

    static class Graph {
        private int V;
        private LinkedList adj[];

        Graph(int v) {
            adj[v] = new LinkedList();
        }

        void addEdge(int a, int b) {
            adj[a].add(b);
            adj[b].add(a);
        }


        Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
            // Mark the current node as visited
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();

                // If an adjacent is not visited, then recur for that
                // adjacent
                if (!visited[i]) {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                }

                // If an adjacent is visited and not parent of current
                // vertex, then there is a cycle.
                else if (i != parent)
                    return true;
            }
            return false;
        }

        // Returns true if the graph contains a cycle, else false.
        Boolean isCyclic() {
            // Mark all the vertices as not visited and not part of
            // recursion stack
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to detect cycle in
            // different DFS trees
            for (int u = 0; u < V; u++)
                if (!visited[u]) // Don't recur for u if already visited
                    if (isCyclicUtil(u, visited, -1))
                        return true;

            return false;
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
    }
}
