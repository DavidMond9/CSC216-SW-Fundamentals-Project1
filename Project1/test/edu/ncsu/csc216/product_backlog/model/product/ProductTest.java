package edu.ncsu.csc216.product_backlog.model.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

class ProductTest {
	/**
	 * Test Product.
	 */
	private Product testProduct1 = new Product("Product");
	/**
	 * Test notes list 1.
	 */
	private ArrayList<String> testNotes1 = new ArrayList<String>();
	/**
	 * Test notes list 2.
	 */
	private ArrayList<String> testNotes2 = new ArrayList<String>();
	/**
	 * Test product list.
	 */
	private ArrayList<Product> testProductList = new ArrayList<Product>();
	/**
	 * Test command.
	 */
	private Command testCommand = new Command(CommandValue.CLAIM, "owner", "note");
	/**
	 * Test task 1.
	 */
	private Task testTask1 = new Task(1, "Backlog", "title1", "B", "creator1", "unowned", "false", testNotes1);
	/**
	 * Test task 2.
	 */
	private Task testTask2 = new Task(5, "Owned", "title1", "B", "creator5", "unowned", "true", testNotes2);
	/**
	 * Test task 3.
	 */
	private Task testTask3 = new Task(1, "Owned", "title1", "B", "creator1", "unowned", "false", testNotes1);

	@Test
	void testSetTaskCounter() {
		//testProduct1.setTaskCounter();
	}
	@Test
	void testAddTask() {
		testProduct1.addTask(testTask1);
		testProduct1.addTask("title", Type.FEATURE, "creator", "note");
		assertEquals(testProduct1.getTaskById(1), testTask1);
		assertEquals(testProduct1.getTaskById(5), null);
		
	}
	
	@Test
	void testExecuteCommand() {
		testProduct1.addTask(testTask1);
		testProduct1.addTask("title", Type.FEATURE, "creator", "note");
		assertEquals(testProduct1.getTasks().get(0), testTask1);
		testProduct1.executeCommand(1, testCommand);
		assertEquals(testProduct1.getTasks().get(0).getStateName(), "Owned");
		
	}
	@Test
	void testDeleteTaskById() {
		testProduct1.addTask(testTask1);
		testProduct1.addTask("title", Type.FEATURE, "creator", "note");
		testProduct1.deleteTaskById(1);
		assertEquals(testProduct1.getTaskById(1), null);
	}

}
