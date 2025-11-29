package com.mphasis;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GcInfo {
    public static void main(String[] args) {
        // Allocate lots of objects to trigger GC
        for (int i = 0; i < 1000000; i++) {
            String s = new String("garbage" + i);
        }

        // Suggest GC
        System.gc();

        // Get GC stats
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("Name: " + gcBean.getName());
            System.out.println("Collections: " + gcBean.getCollectionCount());
            System.out.println("Time (ms): " + gcBean.getCollectionTime());
            System.out.println("-----------------------------------");
        }
    }
}
