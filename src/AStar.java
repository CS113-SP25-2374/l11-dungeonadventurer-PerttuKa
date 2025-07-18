import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {

    static int heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int[][] moves = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<Node> shortestPath(char[][] map, Node start, Node finish) {

        PriorityQueue<Node> open = new PriorityQueue<>();
        boolean[][] visited  = new boolean[map.length][map[0].length];

        int g = 0;
        int h = heuristic(start.x , start.y, finish.x, finish.y);

        Node current = new Node(start.x, start.y, start.name, g, h);
        open.add(current);

        while (!open.isEmpty()) {
            current = open.poll();

            if (current.x == finish.x && current.y == finish.y) {
                return rebuildPath(current);
            }

            visited[current.y][current.x] = true;

            for (int[] move : moves) {
                int x = current.x + move[0];
                int y = current.y + move[1];

                if (y < 0 || y >= map.length || x < 0 || x >= map[0].length) continue;
                if (!DungeonMap.isValid(x, y) || visited[y][x]) continue;

                g = current.g + 1;
                h = heuristic(x, y, finish.x, finish.y);

                Node next = new Node(x, y, map[y][x], g, h, current);
                open.add(next);
            }
        }

        return null;
    }

    private static List<Node> rebuildPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(0,current);
            current = current.parent;
        }
        return path;
    }

}
