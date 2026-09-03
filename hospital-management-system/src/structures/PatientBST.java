package structures;

import model.Patient;

public class PatientBST {
    
    // Inner Node class 
    private class Node {
        Patient patient;
        Node left, right;
        
        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root; 
    
    public PatientBST() {
        this.root = null;
    }
    
    // INSERT PATIENT 
    public void insert(Patient patient) {
        root = insertHelper(root, patient);
    }
    
    private Node insertHelper(Node node, Patient patient) {
        if (node == null) {
            return new Node(patient);
        }
        if (patient.getPatientId() < node.patient.getPatientId()) {
            node.left = insertHelper(node.left, patient);
        } else if (patient.getPatientId() > node.patient.getPatientId()) {
            node.right = insertHelper(node.right, patient);
        } else {
            // Duplicate ID 
            System.out.println("Patient ID already exists!");
        }
        return node;
    }
    
    //  SEARCH PATIENT 
    public Patient search(int patientId) {
        return searchHelper(root, patientId);
    }
    
    private Patient searchHelper(Node node, int patientId) {
        if (node == null) {
            return null;
        }
        if (patientId == node.patient.getPatientId()) {
            return node.patient; 
        }
        if (patientId < node.patient.getPatientId()) {
            return searchHelper(node.left, patientId);
        } else {
            return searchHelper(node.right, patientId);
        }
    }
    
   
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients in the system.");
            return;
        }
        System.out.println("--- Patients (Sorted by ID) ---");
        displayInOrderHelper(root);
    }
    
    private void displayInOrderHelper(Node node) {
        if (node != null) {
            displayInOrderHelper(node.left);  
            System.out.println(node.patient); 
            displayInOrderHelper(node.right); 
        }
    }
    
    //  DELETE PATIENT 
    public void delete(int patientId) {
        root = deleteHelper(root, patientId);
    }
    
    private Node deleteHelper(Node node, int patientId) {
        if (node == null) {
            System.out.println("Patient not found!");
            return null;
        }
        
        if (patientId < node.patient.getPatientId()) {
            node.left = deleteHelper(node.left, patientId);
        } else if (patientId > node.patient.getPatientId()) {
            node.right = deleteHelper(node.right, patientId);
        } else {
           
        	
            if (node.left == null && node.right == null) {
                System.out.println("Patient deleted successfully!");
                return null;
            }
            
            
            if (node.left == null) {
                System.out.println("Patient deleted successfully!");
                return node.right;
            }
            if (node.right == null) {
                System.out.println("Patient deleted successfully!");
                return node.left;
            }
            
           
            Node successor = findMin(node.right);
            node.patient = successor.patient;
            node.right = deleteHelper(node.right, successor.patient.getPatientId());
        }
        return node;
    }
    
    
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}