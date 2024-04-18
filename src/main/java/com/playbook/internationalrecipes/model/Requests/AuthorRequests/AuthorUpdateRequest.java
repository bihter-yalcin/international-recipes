package com.playbook.internationalrecipes.model.Requests.AuthorRequests;

import lombok.Data;

@Data
public class AuthorUpdateRequest {
    private Long id;
    private String name;
}
