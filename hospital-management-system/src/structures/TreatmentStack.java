package structures;

import model.TreatmentRecord;

public class TreatmentStack {
	private class Node{
		TreatmentRecord record;
        Node next;
        
        Node(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
	}
	private Node top; 
	
	public TreatmentStack() {
        this.top = null;
    }
	
	 public void push(TreatmentRecord record) {
	        Node newNode = new Node(record);
	        newNode.next = top;
	        top = newNode;
	        System.out.println("Treatment record added: " + record.getRecordId());
	    }
	    
	 public TreatmentRecord pop() {
	        if (isEmpty()) {
	            System.out.println("No treatment records available! Stack is empty.");
	            return null;
	        }
	        TreatmentRecord record = top.record;
	        top = top.next;
	        System.out.println("Removed record: " + record.getRecordId());
	        return record;
	    }
	 
	 public void displayStack() {
	        if (isEmpty()) {
	            System.out.println("Treatment history is empty.");
	            return;
	        }
	        System.out.println("--- Treatment History (Most Recent First) ---");
	        Node temp = top;
	        while (temp != null) {
	            System.out.println(temp.record);
	            temp = temp.next;
	        }
	    }
	 
	 public boolean isEmpty() {
	        return top == null;
	    }
}
