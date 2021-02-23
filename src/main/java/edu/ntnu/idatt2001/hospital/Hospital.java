package edu.ntnu.idatt2001.hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private final String hospitalName;
    private Map<Integer, Department> departments;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.departments = new HashMap<>();
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public List<Department> getDepartments() {
        ArrayList<Department> departmentList = new ArrayList<>();
        for (Integer i : departments.keySet()) {
            departmentList.add(departments.get(i));
        }
        return departmentList;
    }

    public void addDepartment(Department department) {
        if (!departments.containsKey(department.hashCode())) {
            departments.put(getDepartments().hashCode(), department);
        }
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Hospital - " + hospitalName + "\n\n";
        ret += "All Departments:";
        for (Integer i : departments.keySet()) {
            ret += departments.get(i).toString();
            ret += '\n';
        }
        return ret;
    }

}
