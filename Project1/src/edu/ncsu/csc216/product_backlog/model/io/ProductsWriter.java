/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import edu.ncsu.csc216.product_backlog.model.product.Product;

/**
 * ProductsWriter class writes the products and has one method called writeProductsToFile to assist this duty.
 */
public class ProductsWriter {
	/**
	 * Constructor for ProductsWriter, actually creates the ProductsWriter.
	 */
	public ProductsWriter() {
		
	}
	/**
	 * Writes the products to file.
	 * @param fileName Name of file.
	 * @param productList List of products being written.
	 * @throws FileNotFoundException throws exception if file not found.
	 */
	public static void writeProductsToFile(String fileName, List<Product> productList) {
		try {
			PrintStream fileWriter = new PrintStream(new File(fileName));
			for (int i = 0; i < productList.size(); i++) {
				Product product = productList.get(i);
			    fileWriter.println("# " + product.getProductName());
			    for(int j = 0; j < product.getTasks().size(); j++) {
			    	fileWriter.println(product.getTasks().get(j).toString());
			    }
			}
			fileWriter.close();
		} catch(Exception e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
