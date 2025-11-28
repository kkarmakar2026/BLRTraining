package com.mphasis;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class DemoOnHashSet {

	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(56);
		hashSet.add(34);
		hashSet.add(32);
		hashSet.add(23);
		hashSet.add(56);
		System.out.println(hashSet);
		
		for(Integer i :hashSet)
			System.out.println(i);
		
		Iterator<Integer> itr = hashSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		hashSet.forEach(i->System.out.println(i));
		hashSet.forEach(System.out::println);
		hashSet.add(null);
		
		System.out.println(hashSet);
		hashSet.add(null);
		System.out.println(hashSet);
		
		LinkedList<Integer> llHashSet = new LinkedList<Integer>();
		llHashSet.add(90);
		llHashSet.add(56);
		llHashSet.add(34);
		llHashSet.add(99);
		llHashSet.add(23);
		llHashSet.add(12);
		
		System.out.println(llHashSet);
	}
}
