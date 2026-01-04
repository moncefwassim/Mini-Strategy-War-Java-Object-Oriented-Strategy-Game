package game;

import player.Player;
import map.GameMap;
import unit.*;

public class Game {
    public Player player;
    public Player ai;
    public GameMap map;

    public Game() {
        player = new Player("Player");
        ai = new Player("AI");
        map = new GameMap(5);
    }

    public void nextTurn() {

        // 1. L’IA crée une unité si possible
        if (ai.getResources().get(resource.ResourceType.GOLD) >= 30) {
            ai.getUnits().add(new unit.Soldier());
            ai.getResources().put(resource.ResourceType.GOLD,
                    ai.getResources().get(resource.ResourceType.GOLD) - 30);
        }

        // 2. Combat si les deux ont des unités
        if (!player.getUnits().isEmpty() && !ai.getUnits().isEmpty()) {
            Unit pUnit = player.getUnits().get(0);
            Unit aUnit = ai.getUnits().get(0);

            pUnit.attack(aUnit);
            if (aUnit.isAlive()) {
                aUnit.attack(pUnit);
            }
        }

        // 3. Nettoyage des unités mortes
        player.getUnits().removeIf(u -> !u.isAlive());
        ai.getUnits().removeIf(u -> !u.isAlive());

        // 4. Gain de ressources par tour
        player.getResources().put(
            resource.ResourceType.GOLD,
            player.getResources().get(resource.ResourceType.GOLD) + 20
        );
    }

}