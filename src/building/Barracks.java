package building;


public class Barracks extends Building {
    public Barracks() {
        cost = 40;
    }

    public void action() {
        System.out.println("Training units");
    }
}
