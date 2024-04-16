package com.playbook.internationalrecipes.utils;

import com.playbook.internationalrecipes.model.author.Author;

public class TestUtils {

    public static Author createTestAuthor1(){
        return Author.builder().id(1L).name("William Shakespeare").build();
    }

    public static Author createTestAuthor2(){
        return Author.builder().id(2L).name("Lev Tolstoy").build();
    }
}
