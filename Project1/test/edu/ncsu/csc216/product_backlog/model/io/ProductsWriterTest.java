package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;

class ProductsWriterTest {

	private final String expTask = "test-files/exp_tasks.txt";
	private final String testOutput = "newOutput.txt";
		
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
