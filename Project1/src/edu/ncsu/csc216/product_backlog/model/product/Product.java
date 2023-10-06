package edu.ncsu.csc216.product_backlog.model.product;

import java.util.List;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Product class defines what a product is with multiple fields including a name and counter, and it 
 * also has many methods that can add, edit, or even delete products.
 */
public class Product {
	/**
	 * Product name field.
	 */
	private String productName;
	/**
	 * Counter for the product field.
	 */
	private int counter;
	
	/**
	 * Constructor for product, creates a Product and has a name.
	 * @param name Name of the product
	 */
	public Product(String name) {
		
	}

	/**
	 * Gets the productName.
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the productName.
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * Sets the task counter.
	 */
	private void setTaskCounter() {
		
	}
	/**
	 * Checks for an emptyList.
	 */
	private void emptyList() {
		
	}
	/**
	 * Add a task.
	 * @param task to add.
	 */
	public void addTask(Task task) {
		
	}
	/**
	 * Add a task with title type creator and note.
	 * @param title of task
	 * @param type of task
	 * @param creator of task
	 * @param note of task
	 */
	public void addTask(String title, Type type, String creator, String note) {
		
	}
	/**
	 * Get list of tasks.
	 * @return Returns the list of tasks.
	 */
	public List<Task> getTasks(){
		return null;
	}
	/**
	 * Get a task by id.
	 * @param id the id to get the task.
	 * @return Returns a Task.
	 */
	public Task getTaskById(int id) {
		return null;
	}
	/**
	 * Execute a command by ID and specific command.
	 * @param id the id to find out what command.
	 * @param c the command itself.
	 */
	public void executeCommand(int id, Command c) {
		
	}
	/**
	 * Delete a task by ID
	 * @param id the id used to delete a task.
	 */
	public void deleteTaskById(int id) {
		
	}
}
