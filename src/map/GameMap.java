package map;


import java.util.Random;

public class GameMap {
    private Tile[][] grid;

    public GameMap(int size) {
        grid = new Tile[size][size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                TileType[] values = TileType.values();
                grid[i][j] = new Tile(values[r.nextInt(values.length)]);
            }
        }
    }

    public Tile[][] getGrid() {
        return grid;
    }
}
