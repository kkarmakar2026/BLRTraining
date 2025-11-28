package com.mphasis;

import java.util.Iterator;
import java.util.TreeSet;

public class DemoOnTreeTest {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(63);
		treeSet.add(26);
		treeSet.add(56);
		treeSet.add(46);
		treeSet.add(89);
		
		System.out.println(treeSet);
		System.out.println(treeSet.ceiling(30));
		System.out.println(treeSet.floor(30));
		
		Iterator<Integer> itr = treeSet.descendingIterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println(treeSet.tailSet(60));
		System.out.println(treeSet.higher(56));
		
		
		TreeSet<Student> st = new TreeSet<Student>();
		st.add(new Student(101, "Koushik", 23, "Kolkata", 89));
		st.add(new Student(105, "Sham", 22, "Chennai", 92));
		st.add(new Student(108, "Naresh", 23, "Hyderbad",85));
		
		System.out.println(st);
	}
}
