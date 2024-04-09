package com.playbook.internationalrecipes.model.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    private String id;

    private String name;

    public Author(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }


}
