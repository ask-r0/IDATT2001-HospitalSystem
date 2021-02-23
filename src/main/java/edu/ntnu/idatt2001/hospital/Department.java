package edu.ntnu.idatt2001.hospital;

import edu.ntnu.idatt2001.hospital.exception.RemoveException;

import java.util.*;

public class Department {
    private String departmentName;
    private List<Patient> patients;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public void remove(Person person) throws RemoveException {
        if (person instanceof Employee && employees.contains(person)) {
            employees.remove(person.getSocialSecurityNumber());
        }else if (person instanceof Patient && patients.contains(person)) {
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
        for (Employee e : employees) {
            ret += e.toString() + '\n';
        }

        ret += "List of patients: \n";
        for (Patient p : patients) {
            ret += p.toString() + '\n';
        }
        return ret;

    }
}
