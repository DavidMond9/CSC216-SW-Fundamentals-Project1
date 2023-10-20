/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * ProductsReader class reads a product, and has many methods to help perform this requirement.
 */
public class ProductsReader {
	/**
	 * Constructor for ProductsReader that creates the ProductsReader.
	 */
	public ProductsReader() {
		//Products constructor
	}
	/**
	 * Method that reads the products file and returns an ArrayList of the products.
	 * @param fileName Name of the file.
	 * @return An ArrayList of products.
	 */
	public static ArrayList<Product> readProductsFile(String fileName)  {
		Scanner fileReader;
		ArrayList<Product> products = new ArrayList<Product>();

		Task task = null;
		String pFile = "";
		Product product = null;
		try {
			fileReader = new Scanner(new FileInputStream(fileName));
			while(fileReader.hasNextLine()) {
				pFile += fileReader.nextLine() + "\n";
			}
			fileReader.close();
			
			Scanner scanP = new Scanner(pFile);
			
			scanP.useDelimiter("\\r?\\n?[#]");
			String liner = "";
			while (scanP.hasNext()) {
				liner = scanP.nextLine();
				if(liner.charAt(0) == '#') {	
					String productLine = liner.substring(2);
					product = processProduct(productLine);				
					if (product != null) {
						products.add(product);
					}
				}
				if(liner.charAt(0) == '*') {				
					String newLine = liner.substring(2);
					newLine = newLine.trim();
					task = processTask(newLine);
					if (task != null) { 
						product.addTask(task);
					}
				}
				if(liner.charAt(0) == '-') {
					//int idx = liner.lastIndexOf(']');
					String noteLine = liner.substring(2);
					noteLine = noteLine.trim();
					task.addNoteToList(noteLine);
				}
			}



			scanP.close();
			return products;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Unable to load file.");
		}

		
		
	

	}
	/**
	 * Processes a product
	 * @param productName name of the product.
	 * @return The product being processed.
	 */
	private static Product processProduct(String productName) {
		Scanner a = new Scanner(productName);
		Product product = null;
		try {
			String own = a.nextLine();
			product = new Product(own);
			a.close();
			return product;
		} catch (Exception e) {
			a.close();
			return product;
		}
	}
	/**
	 * Processes a task.
	 * @param taskName Name of the task.
	 * @return The task being processed.
	 */
	private static Task processTask(String taskName) {
		Scanner a = new Scanner(taskName);
		a.useDelimiter(",");
		ArrayList<String> note = new ArrayList<String>();
		Task task = null;
		try {
			int id = a.nextInt();
			String state = a.next();
			String title = a.next();
			String type = a.next();
			String creator = a.next();
			String owner = a.next();
			String verified = a.next();
			task = new Task(id, state, title, type, creator, owner, verified, note);
			a.close();
			return task;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IllegalArgumentException();
		}

		
	}
}
