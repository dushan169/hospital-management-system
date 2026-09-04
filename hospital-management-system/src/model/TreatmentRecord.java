package model;

public class TreatmentRecord {
	private int recordId;
    private int patientId;
    private String patientName;
    private String treatmentDescription;
    private String completionDate;
    
    public TreatmentRecord(int recordId, int patientId, String patientName,
            String treatmentDescription, String completionDate) {
    	this.recordId = recordId;
    	this.patientId = patientId;
    	this.patientName = patientName;
    	this.treatmentDescription = treatmentDescription;
    	this.completionDate = completionDate;
    }
    
    public int getRecordId() { return recordId; }
    public int getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public String getTreatmentDescription() { return treatmentDescription; }
    public String getCompletionDate() { return completionDate; }
    
    public void setRecordId(int recordId) { this.recordId = recordId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setTreatmentDescription(String treatmentDescription) { this.treatmentDescription = treatmentDescription; }
    public void setCompletionDate(String completionDate) { this.completionDate = completionDate; }

    @Override
    public String toString() {
        return "Record ID:" + recordId + " | Patient:" + patientName 
                + " | Treatment:" + treatmentDescription 
                + " | Date:" + completionDate;
    }
    
}
