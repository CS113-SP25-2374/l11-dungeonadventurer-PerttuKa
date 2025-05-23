import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adventurer {
    char[][] map;
    List<Node> pointOfInterest = new ArrayList<>();
    Map<String, Route> routes  = new HashMap<>();


    public Adventurer(){

    }

    public void solveMap(char[][] map) {
        this.map = map;

        findPOI();
        findPaths();
        findMST();
    }

    void findPOI() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                char c = map[y][x];
                if (c == DungeonMap.WALL || c == DungeonMap.OPEN) continue;
                pointOfInterest.add(new Node(x, y, c));
            }
        }
    }

    void findPaths() {
        for (int a = 0; a < pointOfInterest.size(); a++) {
            for (int b = a + 1; b < pointOfInterest.size(); b++) {

                List<Node> path = AStar.shortestPath(
                        map, pointOfInterest.get(a), pointOfInterest.get(b));

                if (path == null || path.isEmpty()) continue;

                Route r = new Route(path);
                routes.put(r.key(), r);
                routes.put(Route.key(r.end(), r.start()), r);
            }
        }
    }

    void findMST() {
        List<Route> mts = Prims.findMST(pointOfInterest, routes);
        System.out.println(mts);
    }

}
