package com.playbook.internationalrecipes.model.author;

import com.playbook.internationalrecipes.model.Requests.AuthorRequests.AuthorUpdateRequest;
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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_id_seq")
    private Long id;

    private String name;


    public static Author create(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }

    public static Author update(Author author, AuthorUpdateRequest updateRequest) {
        author.setName(updateRequest.getName());
        return author;
    }
}
