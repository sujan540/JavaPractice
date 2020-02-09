package DataStructure.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by root on 2020-02-07.
 */
public class Google1 {
    static class Relative {
        String parent;
        String child;

        Relative(String parent, String child) {
            this.parent = parent;
            this.child = child;
        }
    }

    public static void printTree(List<Relative> lists) {

        Map<String, List<String>> adjList = new HashMap<>();

        Set<String> child = new HashSet<>();

        for (Relative relative : lists) {
            if (!adjList.containsKey(relative.parent)) {
                adjList.put(relative.parent, Arrays.asList(relative.child));
            } else {
                List<String> list = new ArrayList<>();
                list.addAll(adjList.get(relative.parent));
                list.add(relative.child);
                adjList.put(relative.parent, list);
            }
            child.add(relative.child);
        }

        final String root = getRoot(adjList, child);
        DFS(adjList, root, 0);
    }

    public static void DFS(Map<String, List<String>> maps, String root, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("\t");
        }
        System.out.println(root);
        List<String> children;
        if (maps.containsKey(root)) {
            children = maps.get(root);
        } else {
            return;
        }

        for (String child : children) {
            DFS(maps, child, index + 1);
        }
    }

//    public static void DFS_Stack(Map<String, List<String>> maps, String root, int index) {
//        Stack stack = new Stack();
//        stack.push(root);
//        stack
//        System.out.println(root);
//
//
//    }

    public static String getRoot(Map<String, List<String>> adjList, Set<String> children) {
        List<String> root = adjList.entrySet().stream().filter(entry -> !children.contains(entry.getKey()))
                .map(maps -> maps.getKey())
                .collect(Collectors.toList());
        if (!root.isEmpty()) {
            return root.get(0);
        }
        return "";
    }

    public static class Node {
        String value;
        List<Node> child = new ArrayList<>();
        boolean visited;

        Node(String value) {
            this.value = value;
        }
    }



    public static Node createTree(Node root, Map<String, List<String>> maps) {
        if (maps.containsKey(root.value) && root!=null) {
            for (String child : maps.get(root.value)) {
                Node node = new Node(child);
                List<Node> childern = new ArrayList<>();
                childern.addAll(root.child);
                childern.add(createTree(node, maps));
                return node;
            }
        }
        return null;
    }


    public static void print(Node root) {
        if (root != null && !root.child.isEmpty()) {
            return;
        }
        System.out.println(root.value);
        for (Node node : root.child) {
            print(node);
        }
    }

    public static void main(String[] args) {
        List<Relative> graph = new ArrayList<>();
        graph.add(new Relative("animal", "mammal"));
        graph.add(new Relative("animal", "bird"));
        graph.add(new Relative("lifeform", "animal"));
        graph.add(new Relative("cat", "lion"));
        graph.add(new Relative("mammal", "cat"));
        graph.add(new Relative("animal", "fish"));

        Set<String> parents = graph.stream().map(relative -> relative.parent).collect(Collectors.toSet());
        Set<String> children = graph.stream().map(relative -> relative.child).collect(Collectors.toSet());

        Map<String, List<String>> maps = new HashMap<>();

        for (Relative relative : graph) {
            if (!maps.containsKey(relative.parent)) {
                maps.put(relative.parent, Arrays.asList(relative.child));
            } else {
                List<String> childs = new ArrayList<>();
                childs.addAll(maps.get(relative.parent));
                childs.add(relative.child);
                maps.put(relative.parent, childs);
            }
        }

        String root = "";
        for (String parent : parents) {
            if (!children.contains(parent)) {
                root = parent;
                break;
            }
        }

        Node parent = new Node(root);
        createTree(parent, maps);
        print(parent);


        System.out.println(root);
        //printTree(graph);


    }
}
