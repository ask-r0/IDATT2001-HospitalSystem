package edu.ntnu.idatt2001.hospital;

import edu.ntnu.idatt2001.hospital.exception.RemoveException;

import java.util.*;

public class Department {
    private String departmentName;
    private Map<String, Patient> patients;
    private Map<String, Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new HashMap<>();
        this.patients = new HashMap<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Patient> getPatients() {
        ArrayList<Patient> patientList = new ArrayList<>();
        for (String SSN : patients.keySet()) {
            patientList.add(patients.get(SSN));
        }
        return patientList;
    }

    public List<Employee> getEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (String SSN : employees.keySet()) {
            employeeList.add(employees.get(SSN));
        }
        return employeeList;
    }

    public void addPatient(Patient patient) {
        if (!patients.containsKey(patient.getSocialSecurityNumber())) {
            patients.put(patient.getSocialSecurityNumber(), patient);
        }
    }

    public void addEmployee(Employee employee) {
        if (!employees.containsKey(employee.getSocialSecurityNumber())) {
            employees.put(employee.getSocialSecurityNumber(), employee);
        }
    }

    public void remove(Person person) throws RemoveException {
        String personsSSN = person.getSocialSecurityNumber();
        if (person instanceof Employee && employees.containsKey(personsSSN)) {
            employees.remove(person.getSocialSecurityNumber());
        }else if (person instanceof Patient && patients.containsKey(personsSSN)) {
            patients.remove(person.getSocialSecurityNumber());
        } else {
            throw new RemoveException("Object not found in neither employee-register nor patient-register.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(patients, that.patients) &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, patients, employees);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Department | " + departmentName + '\n';

        ret += "List of employees: \n";
        for (String SSN : employees.keySet()) {
            ret += employees.get(SSN).toString() + '\n';
        }

        ret += "List of patients: \n";
        for (String SSN : patients.keySet()) {
            ret += patients.get(SSN).toString() + '\n';
        }
        return ret;

    }
}
