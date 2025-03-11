package com.vaibhav.graphqlApp.dto;

import lombok.Data;

@Data
public class PageInfo {
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private long totalElements;
    private int totalPages;
}
