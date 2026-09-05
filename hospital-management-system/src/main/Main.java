package main;

import java.util.Scanner;
import model.Patient;
import model.Visit;
import model.TreatmentRecord;
import structures.PatientBST;
import structures.EmergencyQueue;
import structures.TreatmentStack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        
        int choice;
        do {
            System.out.println("\n╔══════════════════════════════════════════════════════╗");
            System.out.println("║   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM          ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  [BST] PATIENT RECORDS                               ║");
            System.out.println("║    1. Register New Patient                           ║");
            System.out.println("║    2. Search Patient by ID                           ║");
            System.out.println("║    3. Delete Patient                                 ║");
            System.out.println("║    4. Display All Patients (In-Order)                ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  [QUEUE] EMERGENCY PATIENTS                          ║");
            System.out.println("║    5. Add Patient to Emergency Queue                 ║");
            System.out.println("║    6. Treat Next Patient (Dequeue → Stack)           ║");
            System.out.println("║    7. Display Emergency Queue                        ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  [STACK] TREATMENT HISTORY                           ║");
            System.out.println("║    8. Display Treatment History                      ║");
            System.out.println("║    9. Remove Last Treatment Record (Pop)             ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  [LINKED LIST] PATIENT VISIT HISTORY                 ║");
            System.out.println("║   10. Add Visit to Patient History                   ║");
            System.out.println("║   11. Display Patient Visit History                  ║");
            System.out.println("║   12. Remove Patient Visit                           ║");
            System.out.println("║   13. Search Patient Visit                           ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║    0. Exit                                           ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1: registerPatient(sc, bst); break;
                case 2: searchPatient(sc, bst); break;
                case 3: deletePatient(sc, bst); break;
                case 4: bst.displayInOrder(); break;
                case 5: addToEmergencyQueue(sc, bst, queue); break;
                case 6: treatNextPatient(queue, stack, bst); break;
                case 7: queue.displayQueue(); break;
                case 8: stack.displayStack(); break;
                case 9: stack.pop(); break;
                case 10: addVisit(sc, bst); break;
                case 11: displayVisits(sc, bst); break;
                case 12: removeVisit(sc, bst); break;
                case 13: searchVisit(sc, bst); break;
                case 0: System.out.println("Thank you! Exiting system..."); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
    
    // BST OPERATIONS 
    private static void registerPatient(Scanner sc, PatientBST bst) {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = sc.nextLine();
        bst.insert(new Patient(id, name, age, contact, condition));
    }
    
    private static void searchPatient(Scanner sc, PatientBST bst) {
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();
        Patient p = bst.search(id);
        if (p != null) {
            System.out.println("✓ Patient Found: " + p);
        } else {
            System.out.println("✗ Patient not found!");
        }
    }
    
    private static void deletePatient(Scanner sc, PatientBST bst) {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();
        bst.delete(id);
    }
    
    //  QUEUE OPERATIONS 
    private static void addToEmergencyQueue(Scanner sc, PatientBST bst, EmergencyQueue queue) {
        System.out.print("Enter Patient ID to add to queue: ");
        int id = sc.nextInt(); sc.nextLine();
        Patient p = bst.search(id);
        if (p != null) {
            queue.enqueue(p);
        } else {
            System.out.println("✗ Patient not found! Register patient first.");
        }
    }
    
    // Treat Next Patient (Queue → Stack → Linked List) 
    private static void treatNextPatient(EmergencyQueue queue, TreatmentStack stack, PatientBST bst) {
        if (queue.isEmpty()) {
            System.out.println("No patients in emergency queue!");
            return;
        }
        Patient patient = queue.dequeue();
        if (patient != null) {
            System.out.print("Enter Record ID: ");
            Scanner sc = new Scanner(System.in);
            int recordId = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Treatment Description: ");
            String treatment = sc.nextLine();
            System.out.print("Enter Completion Date (DD/MM/YYYY): ");
            String date = sc.nextLine();
            
            // Push to Stack
            TreatmentRecord record = new TreatmentRecord(recordId, patient.getPatientId(), 
                    patient.getName(), treatment, date);
            stack.push(record);
            
            // Also add to patient's visit history
            System.out.print("Enter Visit ID for history: ");
            int visitId = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Doctor Name: ");
            String doctor = sc.nextLine();
            System.out.print("Enter Diagnosis: ");
            String diagnosis = sc.nextLine();
            
            Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
            patient.getVisitHistory().addVisit(visit);
            
            System.out.println("✓ Treatment completed and recorded successfully!");
        }
    }
    
    //  LINKED LIST OPERATIONS 
    private static void addVisit(Scanner sc, PatientBST bst) {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt(); sc.nextLine();
        Patient p = bst.search(pid);
        if (p == null) {
            System.out.println("✗ Patient not found!");
            return;
        }
        System.out.print("Enter Visit ID: ");
        int vid = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Date (DD/MM/YYYY): ");
        String date = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();
        
        Visit visit = new Visit(vid, date, doctor, diagnosis, treatment);
        p.getVisitHistory().addVisit(visit);
    }
    
    private static void displayVisits(Scanner sc, PatientBST bst) {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt(); sc.nextLine();
        Patient p = bst.search(pid);
        if (p == null) {
            System.out.println("✗ Patient not found!");
            return;
        }
        p.getVisitHistory().displayHistory();
    }
    
    private static void removeVisit(Scanner sc, PatientBST bst) {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt(); sc.nextLine();
        Patient p = bst.search(pid);
        if (p == null) {
            System.out.println("✗ Patient not found!");
            return;
        }
        System.out.print("Enter Visit ID to remove: ");
        int vid = sc.nextInt();
        p.getVisitHistory().removeVisit(vid);
    }
    
    private static void searchVisit(Scanner sc, PatientBST bst) {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt(); sc.nextLine();
        Patient p = bst.search(pid);
        if (p == null) {
            System.out.println("✗ Patient not found!");
            return;
        }
        System.out.print("Enter Visit ID to search: ");
        int vid = sc.nextInt();
        p.getVisitHistory().searchVisit(vid);
    }
}