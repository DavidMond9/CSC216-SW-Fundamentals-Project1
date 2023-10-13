package edu.ncsu.csc216.product_backlog.model.backlog;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.io.ProductsReader;
import edu.ncsu.csc216.product_backlog.model.io.ProductsWriter;
import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

class BacklogManagerTest {
	private final String exp_task_backlog = "test-files/exp_task_backlog";
	private final String expTask = "test-files/exp_tasks.txt";
	private final String task1 = "test-files/tasks1.txt";
	private final String task2 = "test-files/tasks2.txt";
	private final String task3 = "test-files/tasks3.txt";
	private final String testOutput = "output.txt";
	private final String testOutput2 = "output2.txt";
	
	BacklogManager testBacklog = BacklogManager.getInstance();
	
	@Test
	void testSaveToFileAndLoadToFile() throws FileNotFoundException {
		testBacklog.loadFromFile(task1);
		testBacklog.saveToFile(testOutput2);
		assertEquals(ProductsReader.readProductsFile(task1), ProductsReader.readProductsFile(testOutput2));
	}
	@Test
	void testLoadProduct() {
		
	}
	@Test
	void testIsDuplicateProduct() {
		
	}
	@Test
	void testGetTasksAsArray() {
		
	}
	@Test
	void testGetTaskById() {
		testBacklog.addProduct("product");
		testBacklog.addTaskToProduct("title", Task.Type.BUG, "product", "a");
		Task task = testBacklog.getTaskById(1);
		assertEquals(1, task.getTaskId());
		assertEquals("title", task.getTitle());
	}
	@Test
	void testExecuteCommand() {
		
	}
	@Test
	void testDeleteTaskById() {
		
	}
	@Test
	void testAddTaskToProduct() {
		
	}
	@Test
	void testGetProductName() {
		
	}
	@Test
	void testGetProductList() {
		
	}
	@Test
	void testClearProducts() {
		
	}
	@Test
	void testEditProduct() {
		testBacklog.addProduct("product");
		testBacklog.editProduct("new");
		String currProduct = testBacklog.getProductName();
		assertEquals("new", currProduct);
	}
	@Test
	void testAddProduct() {
		
	}
	@Test
	void testDeleteProduct() {
		
	}

}
