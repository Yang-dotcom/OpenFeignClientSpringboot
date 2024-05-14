package com.example.democlient.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;


/**
 * Lombak's @Builder annotation to
 * allow build construction pattern
 */
@Builder
@Data
public class MultipleProducts {
    private List<Product> products;
    private int total;
    private int skip;
    private int limit;
}
