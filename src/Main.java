public class Main {
    public static void main(String[] args) {
        System.out.println("Dungeon Map:");
        for (int y = 0; y < DungeonMap.MAP.length; y++) {
            for (int x = 0; x < DungeonMap.MAP[y].length; x++) {
                System.out.print(DungeonMap.MAP[y][x] + " ");
            }
            System.out.print("\n");
        }

        Adventurer adventurer = new Adventurer();
        adventurer.solveMap(DungeonMap.MAP);

        // TODO: Complete this lab!
    }
}