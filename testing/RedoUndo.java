package com.testing;

public class RedoUndo {

	public enum ForwardStatus {

		Redo("Redo"), Undo("Undo");

		/** The status. */
		private String status;

		private ForwardStatus(String status) {
			this.status = status;
		}

		/**
		 * Gets the status.
		 * 
		 * @return the status
		 */
		public String getForwardStatus() {
			return status;
		}

		/**
		 * Sets the status.
		 * 
		 * @param status the new status
		 */
		public void setForwardStatus(String status) {
			this.status = status;
		}
	}
	
	
	private ForwardStatus forwardStatus;
	
	public ForwardStatus getForwardStatus() {
		return forwardStatus;
	}

	public void setForwardStatus(ForwardStatus forwardStatus) {
		this.forwardStatus = forwardStatus;
	}

	public static void main(String[] args) {

		System.out.println(ForwardStatus.Redo.getClass().getSimpleName());
		System.out.println(ForwardStatus.Redo.getForwardStatus().getClass().getSimpleName());
		
		RedoUndo ru = new RedoUndo();
		
		String status = ForwardStatus.Redo.getForwardStatus();
		
		ru.setForwardStatus(ForwardStatus.valueOf(status));
		
		System.out.println(ru.getForwardStatus());

	}

}
