package edu.ncsu.csc216.product_backlog.model.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.task.Task;

class ProductTest {
	private Product testProduct1 = new Product("Product");
	private ArrayList<String> testNotes1 = new ArrayList<String>();
	private ArrayList<String> testNotes2 = new ArrayList<String>();
	private ArrayList<Product> testProductList = new ArrayList<Product>();
	
	private Task testTask1 = new Task(1, "Backlog", "title1", "B", "creator1", "unowned", "false", testNotes1);
	private Task testTask2 = new Task(5, "Owned", "title1", "B", "creator5", "unowned", "true", testNotes2);
	

	@Test
	void testTaskCounter() {
		
	}
	void testGetTaskById() {
		
	}
	void testExecuteCommand() {
		
	}
	void testDeleteTaskById() {
		
	}

}
