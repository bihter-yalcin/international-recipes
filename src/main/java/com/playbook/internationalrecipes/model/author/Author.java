package com.playbook.internationalrecipes.model.author;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

    @Id
    private UUID id;

    private String name;

    public static Author create(String name) {
        Author author = new Author();
        author.setId(UUID.randomUUID());
        author.setName(name);
        return author;
    }


}
