package edu.ntnu.idatt2001.hospital.personnel.doctor;

import edu.ntnu.idatt2001.hospital.Employee;
import edu.ntnu.idatt2001.hospital.Patient;

public abstract class Doctor extends Employee {
    protected Doctor(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    public abstract void setDiagnosis(Patient patient, String diagnosis);
}
