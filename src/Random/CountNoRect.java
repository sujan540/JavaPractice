package Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by root on 2020-02-06.
 */
public class CountNoRect {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(String point) {
            String[] coordinates = point.split(",");
            this.x = Integer.parseInt(coordinates[0]);
            this.y = Integer.parseInt(coordinates[1]);
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }
    }

    static class Diagonal {
        Point point1;
        Point point2;

        double length;

        Diagonal(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
            this.length = Math.sqrt((point1.x - point2.x) * (point1.x - point2.x) + (point1.y - point2.y) * (point1.y - point2.y));
        }

        @Override
        public boolean equals(Object o) {
            Diagonal d = (Diagonal) o;
            return (d.point1.equals(point1) && d.point2.equals(point2)) || (d.point1.equals(point2) && d.point2.equals(point1));
        }

    }

    static List<Point> matchingX(Point point, List<Point> points) {
        List<Point> results = points.stream().filter(p -> !p.equals(point)).filter(p -> p.x == point.x).collect(Collectors.toList());
        return results;
    }

    public static void main(String[] args) throws IOException {

//        System.out.println("Enter points...");
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputPoints = "3,3 4,3 4,1 1,1 3,1 1,3".replaceAll("\\s+$", "").split(" ");
        final List<Point> points = Stream.of(inputPoints).map(point -> new Point(point)).collect(Collectors.toList());

        List<Diagonal> diagonals = new ArrayList<>();
        for (Point point1 : points) {
            for (Point point2 : points) {
                if (point1.equals(point2)) {
                    continue;
                }
                if (point1.y == point2.y) {
                    for (Point point3 : matchingX(point2, points)) {
                        Point point4 = new Point(point1.x, point3.y);
                        if (matchingX(point1, points).contains(point4)) {

                            Diagonal d = new Diagonal(point1, point3);

                            if (!diagonals.contains(d)) {
                                diagonals.add(d);
                            }
                        }
                    }
                }
            }

        }

        System.out.println("Count of rectangle:" + diagonals.size()/2);

    }
}
