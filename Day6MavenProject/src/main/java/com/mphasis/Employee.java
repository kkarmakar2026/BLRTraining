package com.mphasis;

public class Employee {

	private int empId;
	private String empName;
	private double salary;
	private String desg;
	private String dept;
	public Employee(int empId, String empName, double salary, String desg, String dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.desg = desg;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", desg=" + desg + ", dept="
				+ dept + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
