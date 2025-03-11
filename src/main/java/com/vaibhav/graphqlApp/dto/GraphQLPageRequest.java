package com.vaibhav.graphqlApp.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GraphQLPageRequest {
    private Integer page = 0;
    private Integer size = 10;
    private List<String> sort = new ArrayList<>();
}
