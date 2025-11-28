package com.mphasis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DemoOnArrayList {

	public static void main(String[] args) {
		
		ArrayList alist = new ArrayList();
		alist.add(56);
		alist.add("Koushik");
		alist.add(true);
		alist.add(89.76);
		Person p = new Person("Balai", 12345);
		alist.add(p);
		System.out.println(alist);
		System.out.println(alist.get(2));
		
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("Amit");
		nameList.add("Ram");
		nameList.add("Sham");
		System.out.println("Using object");

		System.out.println(nameList);
		
		System.out.println("Using enhanced for loop");

		for(String name: nameList) {
			System.out.println(name);
		}
		
		System.out.println("Using Iterator");
		Iterator<String> itr = nameList.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		System.out.println("Using list iterator");
		ListIterator<String> litr = nameList.listIterator();

		// Forward traversal
		System.out.println("Forward:");
		while(litr.hasNext()) {
		    System.out.println(litr.next());
		}

		// Backward traversal
		System.out.println("Backward:");
		while(litr.hasPrevious()) {
		    System.out.println(litr.previous());
		}
		
		System.out.println(nameList.contains("Amit"));
		nameList.forEach(name->System.out.println(name));
		nameList.forEach(System.out::println);
		
		nameList.remove(2);
		
		Integer [] arr = {2,3,4,5,6,7};
		Integer [] brr = {2,3,4,5};
		
		List<Integer> numList1 = new ArrayList(Arrays.asList(arr));
		List<Integer> numList2 = new ArrayList(Arrays.asList(brr));
		
		numList1.retainAll(numList2);
		System.out.println(numList1);
		
		System.out.println("NameList: "+nameList);
		Collections.sort(nameList);
		
		System.out.println(nameList);
		
		ArrayList<String> clonedNameList = (ArrayList<String>)nameList.clone();
		System.out.println(nameList.hashCode());
		System.out.println(clonedNameList.hashCode());
		
		//studentList.sort(new CityComparator());
		
	}
}
