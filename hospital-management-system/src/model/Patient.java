package model;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;

    // Constructor
    public Patient(int patientId, String name, int age, 
                   String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    // Getters
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
    public String getMedicalCondition() { return medicalCondition; }

    // Setters
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setMedicalCondition(String medicalCondition) { this.medicalCondition = medicalCondition; }

    @Override
    public String toString() {
        return "ID:" + patientId + " | " + name + " | Age:" + age 
                + " | " + contactNumber + " | " + medicalCondition;
    }
}