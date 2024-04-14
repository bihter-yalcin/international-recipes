package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresDbAuthorRepository extends JpaRepository<Author, Long> {

}
