package structures;

import model.Patient;

public class EmergencyQueue {
    
    
    private class Node {
        Patient patient;
        Node next;
        
        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }
    
    private Node front, rear; 
    
    public EmergencyQueue() {
        this.front = this.rear = null;
    }
    
    //  ENQUEUE 
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
           
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient added to emergency queue: " + patient.getName());
    }
    
    //  DEQUEUE -
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty! No patients waiting.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null; // queue එකේ last item එක ගත්තාම rear null වෙන්න ඕන
        }
        System.out.println("Patient removed for treatment: " + patient.getName());
        return patient;
    }
    
    // DISPLAY QUEUE
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients waiting in emergency queue.");
            return;
        }
        System.out.println("--- Emergency Waiting List ---");
        Node temp = front;
        while (temp != null) {
            System.out.println("ID: " + temp.patient.getPatientId() 
                    + " | Name: " + temp.patient.getName());
            temp = temp.next;
        }
    }
    
    
    public boolean isEmpty() {
        return front == null;
    }
}