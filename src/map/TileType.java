package map;

public enum TileType {
    GRASS(true, 0),
    WATER(false, -1),
    MOUNTAIN(true, -1);

    public final boolean accessible;
    public final int bonus;

    TileType(boolean accessible, int bonus) {
        this.accessible = accessible;
        this.bonus = bonus;
    }
}
