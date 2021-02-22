package edu.ntnu.idatt2001.hospital.personnel;

import edu.ntnu.idatt2001.hospital.Employee;

public class Nurse extends Employee {
    public Nurse(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public String toString() {
        return "Nurse | " + getFullName();

    }
}
