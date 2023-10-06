/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.backlog;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * BacklogManager class represents the backlog of the system. It has many methods as well as its own constructor to create
 * a BacklogManager.
 */
public class BacklogManager {
	/**
	 * Constructor for BacklogManager.
	 */
	private BacklogManager() {
		
	}
	/**
	 * Gets instance of BacklogManager.
	 * @return Returns BacklogManager.
	 */
	public static BacklogManager getInstance() {
		return null;
	}
	/**
	 * Saves to file.
	 * @param fileName name of file.
	 */
	public void saveToFile(String fileName) {
		
	}
	/**
	 * Loads from file.
	 * @param fileName name of file.
	 */
	public void loadFromFile(String fileName) {
		
	}
	/**
	 * Loads the product.
	 * @param productName name of product.
	 */
	public void loadProduct(String productName) {
		
	}
	/**
	 * Checks to see if duplicate.
	 * @param product Product name.
	 */
	private void isDuplicateProduct(String product) {
		
	}
	/**
	 * Get tasks as array.
	 * @return 2d task array.
	 */
	public String[][] getTasksAsArray(){
		return null;
	}
	/**
	 * Get task by id.
	 * @param id to get task with.
	 * @return the task that you get with the id.
	 */
	public Task getTaskById(int id) {
		return null;
	}
	/**
	 * Execute a command with this method.
	 * @param id of the task.
	 * @param c represents the command.
	 */
	public void executeCommand(int id, Command c) {
		
	}
	/**
	 * Deletes the task by ID.
	 * @param id to be checked for deleting the task.
	 */
	public void deleteTaskById(int id) {
		
	}
	/**
	 * Add task to the product.
	 * @param s First string parameter.
	 * @param type Type of product.
	 * @param a Third string parameter.
	 * @param b Fourth string parameter.
	 */
	public void addTaskToProduct(String s, Type type, String a, String b) {
		
	}
	/**
	 * Get product name.
	 * @return returns the product name.
	 */
	public String getProductName() {
		return null;
	}
	/**
	 * Get product list.
	 * @return returns the product list.
	 */
	public String[] getProductList(){
		return null;
	}
	/**
	 * Clear the products.
	 */
	public void clearProducts() {
		
	}
	/**
	 * Edit the products.
	 * @param product to be edited.
	 */
	public void editProduct(String product) {
		
	}
	/**
	 * Add a product.
	 * @param product name to be added.
	 */
	public void addProduct(String product) {
		
	}
	/**
	 * Delete a product.
	 */
	public void deleteProduct() {
		
	}
	/**
	 * Reset the manager.
	 */
	public void resetManager() {
		
	}
}
