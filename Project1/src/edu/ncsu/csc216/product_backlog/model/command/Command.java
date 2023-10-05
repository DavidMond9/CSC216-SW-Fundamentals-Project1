/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.command;

/**
 * Command class represents a command, has fields that represent the note, owner, and type of command.
 * Has getter methods to get the fields.
 */
public class Command {
	
	/**
	 * Private field for the note.
	 */
	private String note;
	/**
	 * Private field for the owner.
	 */
	private String owner;
	
	/**
	 * Error message for command.
	 */
	private static final String COMMAND_ERROR_MESSAGE = "Invalid command.";
	/**
	 * Enum for the representation of CommandValue.
	 */
	public enum CommandValue {BACKLOG, CLAIM, PROCESS, VERIFY, COMPLETE, REJECT}
	
	/**
	 * Creates a command.
	 * @param c Represents the CommandValue.
	 * @param owner Represents the owner of the command.
	 * @param noteText Represents the note text.
	 */
	public Command(CommandValue c, String owner, String noteText) {
		if(c == null || noteText == null || "".equals(noteText)){
			throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
		}
		if(c.equals(CommandValue.CLAIM)) {
			if(owner == null || "".equals(owner)) {
				throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
			}
		}
		else {
			if(owner != null) {
				throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Gets the command.
	 * @return the command
	 */
	public CommandValue getCommand() {
		return null;
	}
	/**
	 * Gets the note.
	 * @return the note
	 */
	public String getNoteText() {
		return note;
	}
	

	/**
	 * Gets the owner.
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

}
