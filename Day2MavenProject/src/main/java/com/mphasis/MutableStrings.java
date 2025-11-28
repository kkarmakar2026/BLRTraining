package com.mphasis;

import java.util.StringJoiner;
import java.util.StringTokenizer;


public class MutableStrings {
	public static void main(String a[]) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("koushik");
		sb.append(" karmakar");
		
		System.out.println(sb);
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		
		StringBuffer sb1 = new StringBuffer();
		sb1.append("name");
		System.out.println(sb1.capacity());
		sb1.ensureCapacity(30);
		System.out.println(sb1.capacity());
		
		StringBuilder sb2 = new StringBuilder("Koushik Karmakar");
		sb2.reverse();
		System.out.println(sb2);
		sb2.replace(2, 9, "I have a toy in my workshop");
		System.out.println(sb2);
		
		String str ="koushik,balai";
		StringTokenizer tokenizer = new StringTokenizer(str,",");
		while(tokenizer.hasMoreElements())
			System.out.println(tokenizer.nextToken());
		

		
		        StringJoiner sj = new StringJoiner(", ");
		        sj.add("Java");
		        sj.add("Python");
		        sj.add("C++");
		        System.out.println(sj);
		    }
		

	}


