package edu.ncsu.csc216.product_backlog.model.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

class TaskTest {

	@Test
	void testTaskFields() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		assertEquals(task1.getTaskId(), 5);
		assertEquals(task1.getStateName(), "Owned");
		assertEquals(task1.getTitle(), "test");
		assertEquals(task1.getType(), Type.BUG);
		assertEquals(task1.getCreator(), "david");
		assertEquals(task1.getOwner(), "owned");
		assertEquals(task1.isVerified(), false);
		assertEquals(task1.getNotes().size(), 0);
	}
	
	@Test
	void testGetTypeShortName() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		assertEquals("B", task1.getTypeShortName());
		Task task2 = new Task(5, "test title", Type.FEATURE, "lile", "b");
		assertEquals("F", task2.getTypeShortName());
		Task task3 = new Task(5, "test title", Type.BUG, "lile", "b");
		assertEquals("B", task3.getTypeShortName());
		
		Task task4 = new Task(5, "test title", Type.TECHNICAL_WORK, "lile", "b");
		assertEquals("TW", task4.getTypeShortName());
		
		Task task5 = new Task(5, "test title", Type.KNOWLEDGE_ACQUISITION, "lile", "b");
		assertEquals("KA", task5.getTypeShortName());
		

	}
	@Test
	void testGetTypeLongName() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		assertEquals("Bug", task1.getTypeLongName());
	}
	@Test
	void testIsVerified() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		assertFalse(task1.isVerified());
		Task task2 = new Task(5, "Owned", "test", "B", "david", "owned", "true", new ArrayList<String>());
		assertTrue(task2.isVerified());
	}
	@Test
	void testGetNotesList() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		task1.addNoteToList("x");
		task1.addNoteToList("y");
		assertEquals("- [Owned] x\n- [Owned] y\n", task1.getNotesList());
		assertEquals(2, task1.getNotes().size());
	}
	@Test
	void testGetNotesArray() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		task1.addNoteToList("x");
		task1.addNoteToList("y");
		task1.addNoteToList("z");
		
		String[] chars = new String[3];
		chars[0] = "x";
		chars[1] = "y";
		chars[2] = "z";
		
		String[] notesList = task1.getNotesArray();
		assertEquals(chars[0], notesList[0]);
		assertEquals(chars[1], notesList[1]);
		assertEquals(chars[2], notesList[2]);


	}
	@Test
	void testGetStateName() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		Task task2 = new Task(5, "Backlog", "test", "B", "david", "owned", "false", new ArrayList<String>());
		assertEquals("Owned", task1.getStateName());
		assertEquals("Backlog", task2.getStateName());
	}
	@Test
	void testToString() {
		Task task1 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		assertEquals("* 5,Owned,B,david,owned,false\n", task1.toString());
	}
	@Test
	void testUpdate() {
		Task task1 = new Task(5, "Backlog", "test", "B", "david", "owned", "false", new ArrayList<String>());
		Task task2 = new Task(5, "Owned", "test", "B", "david", "owned", "false", new ArrayList<String>());
		Task task3 = new Task(5, "Verifying", "test", "B", "david", "owned", "false", new ArrayList<String>());

		Command c = new Command(CommandValue.CLAIM, "a", "a");
		Command c2 = new Command(CommandValue.COMPLETE, null, "c");
		Command c3 = new Command(CommandValue.PROCESS, null, "d");
		task1.update(c);
		assertEquals("Owned", task1.getStateName());
		task2.update(c3);
		assertEquals("Processing", task2.getStateName());
		task3.update(c2);
		assertEquals("Done", task3.getStateName());
	}
	
}
