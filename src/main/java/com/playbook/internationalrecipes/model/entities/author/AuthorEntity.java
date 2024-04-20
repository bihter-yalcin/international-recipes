package com.playbook.internationalrecipes.model.entities.author;

import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_id_seq")
    private Long id;

    @Column(unique = true)
    private String name;


    public static AuthorEntity create(String name) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        return authorEntity;
    }

    public static AuthorEntity update(AuthorEntity authorEntity, AuthorDTO updateAuthorDto) {
        authorEntity.setName(updateAuthorDto.getName());
        return authorEntity;
    }
}
