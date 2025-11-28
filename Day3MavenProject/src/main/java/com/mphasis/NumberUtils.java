package com.mphasis;

import java.util.function.Function;
import java.util.function.Predicate;

public class NumberUtils {
    
    public static double log(double num) {
        return Math.log(num);
    }
    
    public static double cubic(double num) {
        return num * num * num;
    }
    
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        
        Function<Double, Double> logUsingMR = NumberUtils::log;
        System.out.println(logUsingMR.apply(8.0));
        
        Function<Double, Double> cubicUsingMR = NumberUtils::cubic;
        System.out.println(cubicUsingMR.apply(4.0));
        
        Predicate<Integer> isEvenUsingMR = NumberUtils::isEven;
        System.out.println(isEvenUsingMR.test(7));
    }
}
