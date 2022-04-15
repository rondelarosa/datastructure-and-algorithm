package com.test.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Employee implements Comparable<Employee> {
    private String name;
    private String jobTitle;

    private List<Employee> directReport = new ArrayList<>();

    public Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Employee> getDirectReport() {
        return directReport;
    }

    public void setDirectReport(Employee emp) {
        this.directReport.add(emp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Stream<Employee> flattened() {
        return Stream.concat(
                Stream.of(this),
                directReport.stream().flatMap(Employee::flattened));
    }

    public Long size() {
        return flattened().count();
    }

    @Override
    public int compareTo(Employee o) {
        return this.jobTitle.compareTo(o.jobTitle);
    }
}
