package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;



class ProductsReadersTest {
	
	private final String exp_task_backlog = "test-files/exp_task_backlog";
	private final String expTask = "test-files/exp_tasks.txt";
	private final String task1 = "test-files/tasks1.txt";
	private final String task2 = "test-files/tasks2.txt";
	private final String task3 = "test-files/tasks3.txt";
	
	private final ArrayList<String> testNotes1 = new ArrayList<String>();
	private final ArrayList<String> testNotes2 = new ArrayList<String>();
	
	private final Product testProduct1 = new Product("Product");
	private final Task testTask1 = new Task(1, "Backlog", "title1", "B", "creator1", "unowned", "false", testNotes1 );
	
	
	
	@Test
	void testReadProductsFile() {
		try {
			ArrayList<Product> products = ProductsReader.readProductsFile(expTask);
			assertEquals(1, products.size());			
			
			Task t1 = products.get(0).getTasks().get(0);
			assertEquals(3, t1.getTaskId());
			assertEquals("Owned", t1.getStateName());
			assertEquals("Test task 2", t1.getTitle());
			assertEquals(Type.KNOWLEDGE_ACQUISITION, t1.getType());
			assertEquals("sesmith", t1.getCreator());
			assertEquals("owner", t1.getOwner());
			assertEquals(false, t1.isVerified());
			
			
			Task t2 = products.get(0).getTasks().get(1);
			assertEquals(7, t2.getTaskId());
			assertEquals("Backlog", t2.getStateName());
			assertEquals("Test task 1", t2.getTitle());
			assertEquals(Type.BUG, t2.getType());
			assertEquals("sesmith5", t2.getCreator());
			assertEquals("unowned", t2.getOwner());
			assertEquals(false, t2.isVerified());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	

}
