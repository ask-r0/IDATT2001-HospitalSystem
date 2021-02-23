package edu.ntnu.idatt2001.hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private final String hospitalName;
    private List<Department> departments;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.departments = new ArrayList<>();
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Hospital - " + hospitalName + "\n\n";
        ret += "All Departments:";
        for (Department d : departments) {
            ret += d.toString();
            ret += '\n';
        }
        return ret;
    }

}
