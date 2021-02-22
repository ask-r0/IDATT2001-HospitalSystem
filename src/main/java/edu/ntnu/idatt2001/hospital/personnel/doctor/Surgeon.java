package edu.ntnu.idatt2001.hospital.personnel.doctor;

import edu.ntnu.idatt2001.hospital.Patient;

public class Surgeon extends Doctor {
    public Surgeon(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
