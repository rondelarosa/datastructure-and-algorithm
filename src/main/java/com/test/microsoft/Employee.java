package com.test.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String jobTitle;

    public Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public List<Employee> directReport = new ArrayList<>();
}
