import java.util.ArrayList;

public class Burgers {
    private ArrayList<String> burgers;

    Burgers() {
        burgers = new ArrayList<>();
        burgers.add("Chicken burger - 600 tg");
        burgers.add("Beef burger - 800 tg");

    }

    public int getBurgerSize() {
        return burgers.size();
    }

    public String getBurger(int index) {
        return burgers.get(index);
    }


}
