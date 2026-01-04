package player;

import unit.Unit;
import resource.ResourceType;
import java.util.*;

public class Player {
    private String name;
    private Map<ResourceType, Integer> resources;
    private List<Unit> units;

    public Player(String name) {
        this.name = name;
        resources = new HashMap<>();
        units = new ArrayList<>();

        resources.put(ResourceType.GOLD, 100);
        resources.put(ResourceType.FOOD, 100);
    }

    public boolean spend(ResourceType r, int amount) {
        if (resources.get(r) >= amount) {
            resources.put(r, resources.get(r) - amount);
            return true;
        }
        return false;
    }

    public Map<ResourceType, Integer> getResources() {
        return resources;
    }

    public List<Unit> getUnits() {
        return units;
    }
}