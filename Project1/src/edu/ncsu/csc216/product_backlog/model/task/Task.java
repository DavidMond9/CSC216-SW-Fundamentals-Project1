/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.task;

import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;

/**
 * Task class. Represents the task with many useful methods and fields such as title, creator, id, and more. 
 */
public class Task {
	/**
	 * Represents the taskId.
	 */
	private int taskId;
	/**
	 * Represents the title.
	 */
	private String title;
	/**
	 * Represents the creator.
	 */
	private String creator;
	/**
	 * Represents the owner.
	 */
	private String owner;
	/**
	 * Represents isVerified condition.
	 */
	private boolean isVerified;
	/**
	 * Represents the notes list.
	 */
	private ArrayList<String> notes;
	
	/**
	 * Represents the current state of the task.
	 */
	private TaskState currentState;
	
	/**
	 * Represents the backlog name.
	 */
	public static final String BACKLOG_NAME = "Backlog";
	/**
	 * Represents the owned name.
	 */
	public static final String OWNED_NAME = "Owned";
	/**
	 * Represents the processing name.
	 */
	public static final String PROCESSING_NAME = "Processing";
	/**
	 * Represents the verifying name.
	 */
	public static final String VERIFYING_NAME = "Verifying";
	/**
	 * Represents the done name.
	 */
	public static final String DONE_NAME = "Done";
	/**
	 * Represents the rejected name.
	 */
	public static final String REJECTED_NAME = "Rejected";
	/**
	 * Represents the feature name.
	 */
	public static final String FEATURE_NAME = "Feature";
	/**
	 * Represents the bug name.
	 */
	public static final String BUG_NAME = "Bug";
	/**
	 * Represents the technical work name.
	 */
	public static final String TECHNICAL_WORK_NAME = "Technical Work";
	/**
	 * Represents the knowledge acquisition name.
	 */
	public static final String KNOWLEDGE_ACQUISITION_NAME = "Knowledge Acquisition";
	/**
	 * Represents the t feature.
	 */
	public static final String T_FEATURE = "F";
	/**
	 * Represents the t bug.
	 */
	public static final String T_BUG = "B";
	/**
	 * Represents the t technical work.
	 */
	public static final String T_TECHNICAL_WORK = "TW";
	/**
	 * Represents the t knowledge acquisition.
	 */
	public static final String T_KNOWLEDGE_ACQUISITION = "KA";
	/**
	 * Represents the owned state.
	 */
	public static final String UNOWNED = "unowned";
	/**
	 * Represents the type enum.
	 */
	public enum Type { FEATURE, BUG, TECHNICAL_WORK, KNOWLEDGE_ACQUISITION }
	
	/**
	 * Represents the type of the task.
	 */
	private Type type;
	/**
	 * Task constructor with 5 parameters.
	 * @param taskId Represents the id of the task.
	 * @param title Represents the title of the task.
	 * @param type Represents the type of the task.
	 * @param creator Represents the creator of the task.
	 * @param note Represents the note of the task.
	 */
	public Task(int taskId, String title, Type type, String creator, String note) {
		
		this(taskId, BACKLOG_NAME, title, T_FEATURE, creator, UNOWNED, "false", new ArrayList<String>());
		setType(type);
		addNoteToList(note);
	
	}
	/**
	 * Task constructor with 8 parameters.
	 * @param taskId Represents the id of the task.
	 * @param state Represents the state of the task.
	 * @param title Represents the title of the task.
	 * @param type Represents the type of the task.
	 * @param creator Represents the creator of the task.
	 * @param owner Represents the owner of the task.
	 * @param verified Represents the verified state of the task.
	 * @param notes Represents the notes of the task.
	 */
	public Task(int taskId, String state, String title, String type, String creator, String owner, String verified, ArrayList<String> notes) {
		setTaskId(taskId);
		setState(state);
		setTypeFromString(type);
		setTitle(title);
		setCreator(creator);
		setOwner(owner);
		setVerified(verified);
		setNotes(notes);
	}
	/**
	 * Gets the taskId
	 * @return the taskId 
	 */
	public int getTaskId() {
		return taskId;
	}
	/**
	 * Sets the taskId
	 * @param taskId the taskId to set
	 */
	private void setTaskId(int taskId) {
		if(taskId <= 0) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.taskId = taskId;
	}
	/**
	 * Gets the title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Sets the title
	 * @param title the title to set
	 */
	private void setTitle(String title) {
		if(title == null || "".equals(title)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.title = title;
	}
	
	/**
	 * Gets the creator.
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * Sets the creator.
	 * @param creator the creator to set
	 */
	private void setCreator(String creator) {
		if(creator == null || "".equals(creator)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.creator = creator;
	}
	/**
	 * Gets the owner.
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * Sets the owner.
	 * @param owner the owner to set
	 */
	private void setOwner(String owner) {
		if(owner == null || "".equals(owner)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.owner = owner;
	}
	/**
	 * Checks isVerified.
	 * @return the isVerified
	 */
	public boolean isVerified() {
		return isVerified;
	}
	/**
	 * Sets isVerified.
	 * @param isVerified the isVerified to set
	 */
	private void setVerified(String isVerified) {
		if("true".equals(isVerified)) {
			this.isVerified = true;

		}
		else if("false".equals(isVerified)) {
			this.isVerified = false;

		}
		else {
			throw new IllegalArgumentException("Invalid input.");
		}
	}
	/**
	 * Gets list of notes.
	 * @return the notes
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}
	/**
	 * Set list of notes.
	 * @param notes the notes to set
	 */
	private void setNotes(ArrayList<String> notes) {
		if(notes == null) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.notes = notes;
	}
	/**
	 * Set type.
	 * @param type Returns type of type
	 */
	private void setType(Type type) {
		//sets the type
		if(type == null) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.type = type;
	}
	/**
	 * Adds note to list.
	 * @param note String of note.
	 * @return Returns an int for note.
	 */
	public int addNoteToList(String note) {
		if(note == null || "".equals(note)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		notes.add(note);
		return 0;
	}
	/**
	 * Sets the state.
	 * @param state to set.
	 */
	private void setState(String state) {
		//sets the state
		if(state.equals(BACKLOG_NAME)) {
			currentState = new BacklogState();
		}
		else if(state.equalsIgnoreCase(VERIFYING_NAME)) {
			currentState = new VerifyingState();
		}
		else if(state.equalsIgnoreCase(OWNED_NAME)) {
			currentState = new OwnedState();
		}
		else if(state.equalsIgnoreCase(PROCESSING_NAME)) {
			currentState = new ProcessingState();
		}
		else if(state.equalsIgnoreCase(DONE_NAME)) {
			currentState = new DoneState();
		}
		else if(state.equalsIgnoreCase(REJECTED_NAME)) {
			currentState = new RejectedState();
		}
		else {
			throw new IllegalArgumentException("Invalid task information.");
		}
	}
	/**
	 * Gets the state name.
	 * @return the state name.
	 */
	public String getStateName() {
		return currentState.getStateName();
	}
	/**
	 * Set the type from string.
	 * @param type in string format.
	 */
	private void setTypeFromString(String type) {
		//sets type from string
		if("".equals(type) || type == null) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		if(type.equals(T_FEATURE) || type.equals(FEATURE_NAME)) {
			this.type = Type.FEATURE;
		}
		else if(type.equals(T_TECHNICAL_WORK) || type.equals ( TECHNICAL_WORK_NAME)) {
			this.type = Type.TECHNICAL_WORK;
		}
		else if(type.equals(T_BUG) || type.equals(BUG_NAME)) {
			this.type = Type.BUG;
		}
		else if(type.equals(T_KNOWLEDGE_ACQUISITION) || type.equals(KNOWLEDGE_ACQUISITION_NAME)) {
			this.type = Type.KNOWLEDGE_ACQUISITION;
		}
		else {
			System.out.println(type);
			throw new IllegalArgumentException("Invalid task information.");
		}
	}
	
	/**
	 * Gets the type
	 * @return Returns the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Gets type short name.
	 * @return Returns type short name.
	 */
	public String getTypeShortName() {
		if(type.equals(Type.FEATURE)) {
			return T_FEATURE;
		} else if(type.equals(Type.BUG)) {
			return T_BUG;		
		} else if(type.equals(Type.KNOWLEDGE_ACQUISITION)) {
			return T_KNOWLEDGE_ACQUISITION;
		} else if(type.equals(Type.TECHNICAL_WORK)) {
			return T_TECHNICAL_WORK;
		} else {
			throw new IllegalArgumentException("Invalid task information.");
		}
		
	}
	/**
	 * Gets type long name.
	 * @return Returns type long name.
	 */
	public String getTypeLongName() {
		if(type.equals(Type.FEATURE)) {
			return FEATURE_NAME;
		} else if(type.equals(Type.BUG)) {
			return BUG_NAME;
		} else if(type.equals(Type.KNOWLEDGE_ACQUISITION)) {
			return KNOWLEDGE_ACQUISITION_NAME;
		} else if(type.equals(Type.TECHNICAL_WORK)) {
			return TECHNICAL_WORK_NAME;
		} else {
			throw new IllegalArgumentException("Invalid task information.");
		}
		
	}
	/**
	 * Gets the notes list.
	 * @return Returns the notes list.
	 */
	public String getNotesList() {
		String res = "";
		for(String n : notes) {
			res += "-  " + n;
		}
		return res;
	}
	/**
	 * Updates the task
	 * @param c Represents the command.
	 */
	public void update(Command c) {
		//updates state
		currentState.updateState(c);
	}
	/**
	 * Gets notes array.
	 * @return 2d String array of notes.
	 */
	public String[] getNotesArray() {
		String[] notesArray = notes.toArray(new String[0]);
		return notesArray;
	}
	/**
	 * toString method for Task class.
	 * @return String combined string for each field.
	 */
	@Override
	public String toString() {
		return "* " + taskId + "," + getStateName() + "," + getTitle() + "," + getTypeShortName() + "," + creator + "," + owner + "," + isVerified + "\n" + getNotesList();
	}
	/**
	 * Interface for states in the Task State Pattern.  All 
	 * concrete task states must implement the TaskState interface.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
	 */
	private interface TaskState {
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		void updateState(Command c);
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		String getStateName();
	
	}
	/**
	 * BacklogState class, implements TaskState and has two useful methods updateState and getStateName.
	 */
	public class BacklogState implements TaskState {
		/**
		 * Constructor for this specific state.
		 */
		private BacklogState() {
			
		}
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		@Override
		public void updateState(Command c) {
			if(c.getCommand().equals(CommandValue.CLAIM)) {
				setState(OWNED_NAME);
			} else if(c.getCommand().equals(CommandValue.REJECT)) {
				setState(REJECTED_NAME);
			} else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
			
		}
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		@Override
		public String getStateName() {
			return BACKLOG_NAME;
		}
		
	}
	/**
	 * OwnedState class, implements TaskState and has two useful methods updateState and getStateName.
	 */
	public class OwnedState implements TaskState {
		/**
		 * Constructor for this specific state.
		 */
		private OwnedState() {
			
		}
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		@Override
		public void updateState(Command c) {
			if(c.getCommand().equals(CommandValue.PROCESS)) {
				setState(PROCESSING_NAME);
			} else if(c.getCommand().equals(CommandValue.REJECT)) {
				setState(REJECTED_NAME);
			} else if(c.getCommand().equals(CommandValue.BACKLOG)) {
				setState(BACKLOG_NAME);
			} else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
			
		}
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		@Override
		public String getStateName() {
			return OWNED_NAME;
		}
		
	}
	/**
	 * ProcessingState class, implements TaskState and has two useful methods updateState and getStateName.
	 */
	public class ProcessingState implements TaskState {
		/**
		 * Constructor for this specific state.
		 */
		private ProcessingState() {
			
		}
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		@Override
		public void updateState(Command c) {
			if(c.getCommand().equals(CommandValue.PROCESS)) {
				setState(PROCESSING_NAME);
			}
			else if(c.getCommand().equals(CommandValue.VERIFY)) {
				if(type.equals(Type.FEATURE) || type.equals(Type.TECHNICAL_WORK) || type.equals(Type.BUG)) {
					setState(VERIFYING_NAME);
				}
				else {
					throw new UnsupportedOperationException("Invalid transition.");
				}
			} else if(c.getCommand().equals(CommandValue.COMPLETE) && type.equals(Type.KNOWLEDGE_ACQUISITION)) {
				setState(DONE_NAME);
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		@Override
		public String getStateName() {
			return PROCESSING_NAME;
		}
		
	}
	/**
	 * VerifyingState class, implements TaskState and has two useful methods updateState and getStateName.
	 */
	public class VerifyingState implements TaskState {
		/**
		 * Constructor for this specific state.
		 */
		private VerifyingState() {
			
		}
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		@Override
		public void updateState(Command c) {
			if(c.getCommand().equals(CommandValue.COMPLETE)) {
				setState(DONE_NAME);
			}
			else if(c.getCommand().equals(CommandValue.PROCESS)) {
				setState(PROCESSING_NAME);
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
			
		}
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		@Override
		public String getStateName() {
			return VERIFYING_NAME;
		}
		
	}
	/**
	 * DoneState class, implements TaskState and has two useful methods updateState and getStateName.
	 */
	public class DoneState implements TaskState {
		/**
		 * Constructor for this specific state.
		 */
		private DoneState() {
			
		}
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		@Override
		public void updateState(Command c) {
			if(c.getCommand().equals(CommandValue.PROCESS)) {
				setState(PROCESSING_NAME);
			}
			else if(c.getCommand().equals(CommandValue.BACKLOG)) {
				setState(BACKLOG_NAME);
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
			
		}
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		@Override
		public String getStateName() {
			return DONE_NAME;
		}
		
	}
	/**
	 * RejectedState class, implements TaskState and has two useful methods updateState and getStateName.
	 */
	public class RejectedState implements TaskState {
		/**
		 * Constructor for this specific state.
		 */
		private RejectedState() {
			
		}
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		@Override
		public void updateState(Command c) {
			if(c.getCommand().equals(CommandValue.BACKLOG)) {
				setState(BACKLOG_NAME);
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		@Override
		public String getStateName() {
			return REJECTED_NAME;
		}		
	}
		
}
