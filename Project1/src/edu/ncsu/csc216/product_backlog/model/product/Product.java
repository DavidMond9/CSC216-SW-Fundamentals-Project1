package edu.ncsu.csc216.product_backlog.model.product;

import java.util.List;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

public class Product {
	private String productName;
	private int counter;
	
	public Product(String name) {
		
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	private void setTaskCounter() {
		
	}
	private void emptyList() {
		
	}
	public void addTask(Task task) {
		
	}
	public void addTask(String title, Type type, String creator, String note) {
		
	}
	public List<Task> getTasks(){
		return null;
	}
	public Task getTaskById(int id) {
		return null;
	}
	public void executeCommand(int id, Command c) {
		
	}
}
