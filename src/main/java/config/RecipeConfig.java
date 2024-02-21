package config;

import model.preference.ConsumerPreferences;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfig {

    @Bean
    public ConsumerPreferences defaultConsumerPreferences() {
        return new ConsumerPreferences(false, false, false);
    }

    @Bean
    public ConsumerPreferences veganConsumerPreferences() {
        ConsumerPreferences veganConsumerPreferences = new ConsumerPreferences();
        veganConsumerPreferences.setVegan(true);
        veganConsumerPreferences.setVegetarian(false);
        veganConsumerPreferences.setGlutenFree(false);
        veganConsumerPreferences.setDairyFree(false);

        return veganConsumerPreferences;
    }
}
