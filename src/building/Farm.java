package building;


public class Farm extends Building {
    public Farm() {
        cost = 30;
    }

    public void action() {
        System.out.println("Producing food");
    }
}
