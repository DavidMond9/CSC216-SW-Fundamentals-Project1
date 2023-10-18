/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.backlog;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.io.ProductsReader;
import edu.ncsu.csc216.product_backlog.model.io.ProductsWriter;
import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * BacklogManager class represents the backlog of the system. It has many methods as well as its own constructor to create
 * a BacklogManager.
 */
public class BacklogManager {
	private static BacklogManager instance;
	private Product currProduct;
	private ArrayList<Product> products;
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
		if(instance == null) {
			instance = new BacklogManager();
		}
		return instance;
	}
	/**
	 * Saves to file.
	 * @param fileName name of file.
	 */
	public void saveToFile(String fileName) {
		try {
			ProductsWriter.writeProductsToFile(fileName, products);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	/**
	 * Loads from file.
	 * @param fileName name of file.
	 */
	public void loadFromFile(String fileName) {
		products = ProductsReader.readProductsFile(fileName);
		currProduct = products.get(0);
	}
	/**
	 * Loads the product.
	 * @param productName name of product.
	 */
	public void loadProduct(String productName) {
		Product productToLoad = null;
		
		for(int i = 0; i < products.size(); i++) {
			if(productName.equals(products.get(i).getProductName())) {
				productToLoad = products.get(i);
				currProduct = productToLoad;
			}
		}
		
		if(productToLoad == null) {
			throw new IllegalArgumentException("Product not available.");
		}
	}
	/**
	 * Checks to see if duplicate.
	 * @param product Product name.
	 */
	private void isDuplicateProduct(String product) {
		if(product == null || product.length() == 0) {
			throw new IllegalArgumentException("Invalid product name.");
		}
		for(int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if(p.getProductName().toLowerCase().equals(product.toLowerCase())) {
				throw new IllegalArgumentException("Invalid product name.");
			}
		}
	}
	/**
	 * Get tasks as array.
	 * @return 2d task array.
	 */
	public String[][] getTasksAsArray(){
		ArrayList<Task> tasks = currProduct.getTasks();
		String[][] res = new String[tasks.size()][4];
		
		for(int i = 0; i < tasks.size(); i++) {
			res[i][0] = Integer.toString(tasks.get(i).getTaskId());
			res[i][1] = tasks.get(i).getStateName();
			res[i][2] = tasks.get(i).getTypeLongName();
			res[i][3] = tasks.get(i).getTitle();
		}
		
		return res;
	}
	/**
	 * Get task by id.
	 * @param id to get task with.
	 * @return the task that you get with the id.
	 */
	public Task getTaskById(int id) {
		return currProduct.getTaskById(id);
	}
	/**
	 * Execute a command with this method.
	 * @param id of the task.
	 * @param c represents the command.
	 */
	public void executeCommand(int id, Command c) {
		currProduct.executeCommand(id, c);
	}
	/**
	 * Deletes the task by ID.
	 * @param id to be checked for deleting the task.
	 */
	public void deleteTaskById(int id) {
		Task t = getTaskById(id);
		currProduct.getTasks().remove(t);
	}
	/**
	 * Add task to the product.
	 * @param s First string parameter.
	 * @param type Type of product.
	 * @param a Third string parameter.
	 * @param b Fourth string parameter.
	 */
	public void addTaskToProduct(String title, Type type, String prodName, String note) {
		currProduct.addTask(title, type, prodName, note);
	}
	/**
	 * Get product name.
	 * @return returns the product name.
	 */
	public String getProductName() {
		if(currProduct == null) {
			return null;
		}
		return currProduct.getProductName();
	}
	/**
	 * Get product list.
	 * @return returns the product list.
	 */
	public String[] getProductList(){
		return products.toArray(new String[0]);
	}
	/**
	 * Clear the products.
	 */
	public void clearProducts() {
		products.clear();
		currProduct = null;
	}
	/**
	 * Edit the products.
	 * @param productName to be edited.
	 */
	public void editProduct(String productName) {
		if(currProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		isDuplicateProduct(productName);
		currProduct.setProductName(productName);
	}
	/**
	 * Add a product.
	 * @param productName name to be added.
	 */
	public void addProduct(String productName) {
		isDuplicateProduct(productName);
		products.add(new Product(productName));
		loadProduct(productName);
	}
	/**
	 * Delete a product.
	 */
	public void deleteProduct() {
		if(currProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		int idx = products.indexOf(currProduct);
		products.remove(idx);
		if(products.isEmpty()) {
			currProduct = null;
		}
		else {
			currProduct = products.get(0);
		}
	}
	/**
	 * Reset the manager.
	 */
	protected void resetManager() {
		instance = null;
	}
}
