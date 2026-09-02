package model;

public class Visit {
    private int visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    // Constructor
    public Visit(int visitId, String visitDate, String doctorName, 
                 String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    // Getters
    public int getVisitId() { return visitId; }
    public String getVisitDate() { return visitDate; }
    public String getDoctorName() { return doctorName; }
    public String getDiagnosis() { return diagnosis; }
    public String getTreatment() { return treatment; }

    // Setters
    public void setVisitId(int visitId) { this.visitId = visitId; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    @Override
    public String toString() {
        return "Visit ID:" + visitId + " | Date:" + visitDate 
                + " | Doctor:" + doctorName + " | Diagnosis:" + diagnosis 
                + " | Treatment:" + treatment;
    }
}