package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;



class ProductsReadersTest {
	
	/**
	 * Test task for ReadProductsFile.
	 */
	private final String expTask = "test-files/exp_tasks.txt";
	
	
	
	
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
