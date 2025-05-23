public class DungeonMap {
    public static final char WALL = '#';
    public static final char OPEN = '.';

    public static final char ENTRANCE = 'E';
    public static final char CHEST = 'C';
    public static final char STATUE = 'S';
    public static final char GEM = 'G';
    public static final char EXIT = 'X';

    public static boolean isValid(int x, int y) {
        if (y < 0 || y >= MAP.length || x < 0 || x >= MAP[0].length) return false;

        return MAP[y][x] != WALL;
    }

    public static final char[][] MAP = {
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','E','.','.','.','.','.','.','X','#'},
            {'#','.','.','.','#','G','.','.','.','#'},
            {'#','.','.','.','#','.','.','.','.','#'},
            {'#','.','.','.','#','.','.','.','.','#'},
            {'#','.','#','.','#','.','#','#','.','#'},
            {'#','C','#','.','#','.','#','S','.','#'},
            {'#','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
    };
}