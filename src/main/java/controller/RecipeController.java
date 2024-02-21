package controller;

import model.preference.ConsumerPreferences;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    private final ConsumerPreferences defaultConsumerPreferences;


    public RecipeController(ConsumerPreferences defaultConsumerPreferences) {
        this.defaultConsumerPreferences = defaultConsumerPreferences;
    }


}
