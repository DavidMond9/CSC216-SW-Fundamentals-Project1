package edu.ncsu.csc216.product_backlog.model.product;

import java.util.ArrayList;
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
	 * Field to hold list of tasks.
	 */
	private ArrayList<Task> list;
	
	/**
	 * Constructor for product, creates a Product and has a name.
	 * @param name Name of the product
	 */
	public Product(String name) {
		setProductName(name);
		list = new ArrayList<Task>();
		counter = 1;
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
		if(productName == null || "".equals(productName)) {
			throw new IllegalArgumentException("Invalid product name.");
		}
		this.productName = productName;
	}
	/**
	 * Sets the task counter.
	 */
	/*private void setTaskCounter() {
		int maxId = 0;
		if(list.size() == 0) {
			counter = 1;
		}
		else {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getTaskId() > maxId) {
					maxId = list.get(i).getTaskId();
				}
			}
		}
		counter = maxId + 1;
	}*/
	/**
	 * Add a task.
	 * @param task to add.
	 */
	public void addTask(Task task) {
		int idx = list.size();
		for(int i = 0; i < list.size(); i++) {
			if(task.getTaskId() == list.get(i).getTaskId()) {
				throw new IllegalArgumentException("Task cannot be added.");
			}
		}
		//loop to get index to insert
		for(int i = 0; i < list.size(); i++) {
			if(task.getTaskId() <= list.get(i).getTaskId()) {
				idx = i;
				break;
			}
		}
		
		list.add(idx, task);
		
		//update counter
		counter += 1;
	}
	/**
	 * Add a task with title type creator and note.
	 * @param title of task
	 * @param type of task
	 * @param creator of task
	 * @param note of task
	 */
	public void addTask(String title, Type type, String creator, String note) {
		Task task = new Task(counter, title, type, creator, note);
		//update counter
		counter += 1;
	}
	/**
	 * Get list of tasks.
	 * @return Returns the list of tasks.
	 */
	public ArrayList<Task> getTasks(){
		return list;
	}
	/**
	 * Get a task by id.
	 * @param id the id to get the task.
	 * @return Returns a Task.
	 */
	public Task getTaskById(int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTaskId() == id) {
				return list.get(i);
			}
		}
		return null;
	}
	/**
	 * Execute a command by ID and specific command.
	 * @param id the id to find out what command.
	 * @param c the command itself.
	 */
	public void executeCommand(int id, Command c) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTaskId() == id) {
				list.get(i).update(c);
			}
		}
	}
	/**
	 * Delete a task by ID
	 * @param id the id used to delete a task.
	 */
	public void deleteTaskById(int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTaskId() == id) {
				list.remove(list.get(i));
			}
		}
	}
}
