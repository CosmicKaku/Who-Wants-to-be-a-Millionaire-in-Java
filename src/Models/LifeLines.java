package Models;

import java.util.ArrayList;

public class LifeLines {

    private static ArrayList<Boolean> LifeLines;

    public void setLifeLines() {
        LifeLines = new ArrayList<>();

        // 3 lifelines for user to use
        for (int x = 0; x < 3; x++) {
            LifeLines.add(false);
        }

    }
    public Boolean getLifeLines(int index) {
        return LifeLines.get(index);
    }
    
    public void usedLifeLine(int index) {
        LifeLines.set(index, true);
    }
    
}
