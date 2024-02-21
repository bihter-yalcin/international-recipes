package model.preference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerPreferences {
    private boolean isVegan;
    private boolean isVegetarian;
    private boolean isGlutenFree;
    private boolean isDairyFree;
    private boolean isSoyFree;
    private boolean isLowFat;

    public ConsumerPreferences(boolean isVegan, boolean isVegetarian, boolean isGlutenFree) {
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
        this.isGlutenFree = isGlutenFree;
    }
}
