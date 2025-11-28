package com.mphasis;

public class Fruits {

	private String fruitName;
	private String fruitColor;
	private double fruitCost;
	
	public void calculateCostPerDozen(Fruits farr[]) {
	    if (farr != null) {
	        for (Fruits f : farr) {
	            if (f != null) {
	                double dozenCost = f.fruitCost * 12;
	                System.out.println(f.fruitName + " cost per dozen: " + dozenCost);
	            }
	        }
	    }
	}

	
	
	public Fruits(String fruitName, String fruitColor, double fruitCost) {
		super();
		this.fruitName = fruitName;
		this.fruitColor = fruitColor;
		this.fruitCost = fruitCost;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public String getFruitColor() {
		return fruitColor;
	}
	public void setFruitColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}
	public double getFruitCost() {
		return fruitCost;
	}
	public void setFruitCost(double fruitCost) {
		this.fruitCost = fruitCost;
	}
	
	@Override
	public String toString() {
		return "Fruits [fruitName=" + fruitName + ", fruitColor=" + fruitColor + ", fruitCost=" + fruitCost + "]";
	}
	
	
	
}
