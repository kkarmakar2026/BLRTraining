package com.mphasis;

@FunctionalInterface
interface StringLength {
    int[] findLength(String[] input);
}

public class StringLengthArray {
    public static void main(String[] args) {
        String arr[] = {"Apple", "Banana", "Grapes"};

        // Lambda returns an array of lengths
        StringLength str = (String[] st) -> {
            int[] lengths = new int[st.length];
            for (int i = 0; i < st.length; i++) {
                lengths[i] = st[i].length();
            }
            return lengths;
        };

        // Print results
        int[] result = str.findLength(arr);
        for (int len : result) {
            System.out.println(len);
        }
    }
}
