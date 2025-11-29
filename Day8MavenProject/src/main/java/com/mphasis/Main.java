package com.mphasis;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[1_000_000]); // allocate 1M ints repeatedly
        }
    }
}
