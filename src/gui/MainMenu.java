package gui;

import javax.swing.*;
import game.Game;

public class MainMenu {
    public static void main(String[] args) {
        int choice = JOptionPane.showConfirmDialog(null, "Start new game?");
        if (choice == JOptionPane.YES_OPTION) {
            new GameUI(new Game());
        }
    }
}