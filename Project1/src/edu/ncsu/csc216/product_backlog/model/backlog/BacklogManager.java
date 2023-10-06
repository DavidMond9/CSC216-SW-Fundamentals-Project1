/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.backlog;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * 
 */
public class BacklogManager {
	private BacklogManager() {
		
	}
	public static BacklogManager getInstance() {
		return null;
	}
	
	public void saveToFile(String fileName) {
		
	}
	public void loadFromFile(String fileName) {
		
	}
	public void loadProduct(String productName) {
		
	}
	private void isDuplicateProduct(String product) {
		
	}
	public String[][] getTasksAsArray(){
		return null;
	}
	public Task getTaskById(int id) {
		return null;
	}
	public void executeCommand(int id, Command c) {
		
	}
	public void deleteTaskById(int id) {
		
	}
	public void addTaskToProduct(String s, Type type, String a, String b) {
		
	}
	public String getProductName() {
		return null;
	}
	public String[] getProductList(){
		return null;
	}
	public void clearProducts() {
		
	}
	public void editProduct(String product) {
		
	}
	public void addProduct(String product) {
		
	}
	public void deleteProduct() {
		
	}
	public void resetManager() {
		
	}
}
