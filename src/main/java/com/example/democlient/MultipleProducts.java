package com.example.democlient;

import lombok.Data;

import java.util.List;

@Data
public class MultipleProducts {
    private List<MyEntity> products;
    private int total;
    private int skip;
    private int limit;
}
