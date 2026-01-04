package gui;


import javax.swing.*;
import game.Game;
import unit.*;

public class GameUI extends JFrame {
    private Game game;
    private JTextArea area;

    public GameUI(Game game) {
        this.game = game;

        setTitle("JavaConquest");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        area = new JTextArea();
        JButton addSoldier = new JButton("Add Soldier");
        JButton nextTurn = new JButton("Next Turn");

        addSoldier.addActionListener(e -> {
            game.player.getUnits().add(new Soldier());
            refresh();
        });

        nextTurn.addActionListener(e -> {
            game.nextTurn();
            refresh();
        });

        JPanel p = new JPanel();
        p.add(addSoldier);
        p.add(nextTurn);

        add(new JScrollPane(area), "Center");
        add(p, "South");

        refresh();
        setVisible(true);
    }

    private void refresh() {
        area.setText("");

        area.append("=== PLAYER ===\n");
        area.append("Gold: " + game.player.getResources().get(resource.ResourceType.GOLD) + "\n");
        area.append("Units: " + game.player.getUnits().size() + "\n\n");

        area.append("=== AI ===\n");
        area.append("Units: " + game.ai.getUnits().size() + "\n");
    }
}

