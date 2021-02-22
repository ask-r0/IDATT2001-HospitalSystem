package edu.ntnu.idatt2001.hospital;

public class Patient extends Person implements Diagnosable {
    private String diagnosis = "";

    protected Patient(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    @Override
    public String toString() {
        return "Patient | " + getFullName() + ", SSN: " + getSocialSecurityNumber();
    }
}