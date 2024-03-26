package com.playbook.internationalrecipes.controller;

import com.playbook.internationalrecipes.config.RecipeConfig;
import com.playbook.internationalrecipes.model.preference.ConsumerPreferences;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preferences")
public class PreferenceController {
    private final RecipeConfig config;

    public PreferenceController(RecipeConfig config) {
        this.config = config;
    }

    @GetMapping("/default")
    public ConsumerPreferences getDefaultPreferences() {
        return config.veganConsumerPreferences();
    }

    @GetMapping("/vegan")
    public ConsumerPreferences getVeganPreferences() {
        return config.defaultConsumerPreferences();
    }


}
