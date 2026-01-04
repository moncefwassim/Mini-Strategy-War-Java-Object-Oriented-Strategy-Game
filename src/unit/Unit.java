package unit;

import java.util.Random;

public abstract class Unit {
    protected int hp;
    protected int attack;
    protected int defense;

    public Unit(int hp, int attack, int defense) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public void attack(Unit enemy) {
        Random r = new Random();
        int damage = attack - enemy.defense + r.nextInt(5);
        enemy.hp -= Math.max(damage, 0);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}