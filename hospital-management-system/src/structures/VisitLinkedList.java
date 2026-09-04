package structures;

import model.Visit;

public class VisitLinkedList {
    
    
    private class Node {
        Visit visit;
        Node next;
        
        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }
    
    private Node head; 
    
    public VisitLinkedList() {
        this.head = null;
    }
    
    // ADD VISIT — List 
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
            System.out.println("Visit added successfully!");
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Visit added successfully!");
    }
    
    // REMOVE VISIT 
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visits found!");
            return;
        }
        
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed!");
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next; 
            System.out.println("Visit removed!");
        } else {
            System.out.println("Visit not found!");
        }
    }
    
    //  SEARCH VISIT 
    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                System.out.println("Visit Found: " + current.visit.getVisitDate() 
                        + " | Doctor: " + current.visit.getDoctorName());
                return current.visit;
            }
            current = current.next;
        }
        System.out.println("Visit not found!");
        return null;
    }
    
    //  DISPLAY HISTORY 
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        System.out.println("--- Visit History ---");
        Node current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }
}