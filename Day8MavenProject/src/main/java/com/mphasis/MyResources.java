package com.mphasis;

public class MyResources implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Resource closed");
		
	}
	
	public static void main(String[] args) throws Exception {
		MyResources rs = getResources();
		System.out.println("Requsting gc");
		System.gc();
	}
	
	public static MyResources getResources() throws Exception {
		try(MyResources resource = new MyResources();){
			System.out.println("Resource using");
			return resource;
		}
	}
	
}
