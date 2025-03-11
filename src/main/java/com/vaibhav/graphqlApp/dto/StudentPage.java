package com.vaibhav.graphqlApp.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentPage {
    private List<Student> content = new ArrayList<>();
    private PageInfo pageInfo = new PageInfo();
}
