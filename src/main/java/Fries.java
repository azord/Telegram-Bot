import java.util.ArrayList;

public class Fries {
    private ArrayList<String> fry;

    Fries() {
        fry = new ArrayList<>();
        fry.add("Fries - 450");
    }

    public int getFrySize() {
        return fry.size();
    }

    public String getFry(int index) {
        return fry.get(index);
    }
}
