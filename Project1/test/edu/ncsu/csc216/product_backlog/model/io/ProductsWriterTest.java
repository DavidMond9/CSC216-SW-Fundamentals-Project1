package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

class ProductsWriterTest {

	private final String exp_task_backlog = "test-files/exp_task_backlog";
	private final String expTask = "test-files/exp_tasks.txt";
	private final String task1 = "test-files/tasks1.txt";
	private final String task2 = "test-files/tasks2.txt";
	private final String task3 = "test-files/tasks3.txt";
	private final String testOutput = "newOutput.txt";
	
	private final ArrayList<String> testNotes1 = new ArrayList<String>();
	private final ArrayList<String> testNotes2 = new ArrayList<String>();
	private final ArrayList<Product> testProductList = new ArrayList<Product>();
	
	private final Product testProduct1 = new Product("Product");
	private final Task testTask1 = new Task(1, "Backlog", "title1", "B", "creator1", "unowned", "false", testNotes1 );
	@Test
	void testWriteProductsToFile() {
		try {
			ProductsWriter.writeProductsToFile(testOutput, ProductsReader.readProductsFile(expTask));
			ArrayList<Product> p1 = ProductsReader.readProductsFile(testOutput);
			ArrayList<Product> p2 = ProductsReader.readProductsFile(expTask);
			assertEquals(p1.size(), p2.size());	
			assertEquals(p1.get(0).getTasks().toString(), p2.get(0).getTasks().toString());
			assertEquals(p1.get(0).getProductName().toString(), p2.get(0).getProductName().toString());
		}
	
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
