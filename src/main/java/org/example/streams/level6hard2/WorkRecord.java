package org.example.streams.level6hard2;

public class WorkRecord {

    private String employeeName;
    private String department;

    public WorkRecord(String employeeName, String department) {
        this.employeeName = employeeName;
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }
}
