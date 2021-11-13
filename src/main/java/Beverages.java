import java.util.ArrayList;

public class Beverages {
    private ArrayList<String> beverages;

    Beverages() {
        beverages = new ArrayList<>();
        beverages.add("Coke - 200");
        beverages.add("Sprite - 190");
        beverages.add("Fanta - 200");

    }

    public int getBeverageSize() {
        return beverages.size();
    }

    public String getBeverages(int index) {
        return beverages.get(index);
    }


}
