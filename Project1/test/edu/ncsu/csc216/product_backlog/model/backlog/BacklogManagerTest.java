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
	private final String testOutput2 = "newFile.txt";
	
	BacklogManager testBacklog = BacklogManager.getInstance();
	
	@Test
	void testSaveToFileAndLoadToFile() throws FileNotFoundException {
		testBacklog.loadFromFile(task1);
		testBacklog.saveToFile(testOutput2);
		ArrayList<Product> p1 = ProductsReader.readProductsFile(task1);
		ArrayList<Product> p2 = ProductsReader.readProductsFile(testOutput2);
		assertEquals(p1.size(), p2.size());	
		assertEquals(p1.get(0).getTasks().toString(), p2.get(0).getTasks().toString());
		assertEquals(p1.get(0).getProductName().toString(), p2.get(0).getProductName().toString());
		testBacklog.resetManager();
	}
	@Test
	void testIsDuplicateProduct() {
		
	}
	@Test
	void testGetTasksAsArray() {
		testBacklog.loadFromFile(task1);
		String[][] arr = testBacklog.getTasksAsArray();
		assertEquals(arr[0][0], "1");
		assertEquals(arr[0][1], "Backlog");
		assertEquals(arr[0][2], "Feature");
		assertEquals(arr[0][3], "Express Carts");
		assertEquals(arr[1][0], "2");
		assertEquals(arr[1][1], "Owned");
		assertEquals(arr[1][2], "Feature");
		assertEquals(arr[1][3], "Regular Carts");
		assertEquals(arr[2][0], "3");
		assertEquals(arr[2][1], "Processing");
		assertEquals(arr[2][2], "Knowledge Acquisition");
		assertEquals(arr[2][3], "Java Swing");
		assertEquals(arr[3][0], "5");
		assertEquals(arr[3][1], "Verifying");
		assertEquals(arr[3][2], "Bug");
		assertEquals(arr[3][3], "Calculating Wait Time");
	}
	@Test
	void testGetTaskById() {
		testBacklog.loadFromFile(task1);
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
		testBacklog.loadFromFile(task1);
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
