package com.test.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamMsApp {

    private Employee getEmployee() {
        Employee ceo = new Employee("Kevin", "CEO");

        Employee man1 = new Employee("Mike", "Manager");
        man1.setDirectReport(new Employee("Lori", "Graphics"));

        Employee man2 = new Employee("Jon", "Manager");
        man2.setDirectReport(new Employee("Jerry", "SWE"));

        ceo.setDirectReport(man1);
        ceo.setDirectReport(man2);

        return ceo;
    }

    /**
     * Given ceo has many employees what's the percentage per each job
     */
    public static void example() {
        ExamMsApp examMsApp = new ExamMsApp();

        Employee ceo = examMsApp.getEmployee();

        // number of ways to solve employee percentage
//        List<JobTitleInfo> results = examMsApp.bruteForce(ceo);
//
//        List<JobTitleInfo> results = examMsApp.stream1(ceo);
//
//        List<JobTitleInfo> results = examMsApp.stream2(ceo);
//
        List<JobTitleInfo> results = examMsApp.embeddedInModel(ceo);

        for (JobTitleInfo j : results) {
            System.out.println("Job " + j.getJobTitle() + ", counts: " + j.getPercentage() + "%");
        }
    }

    private double calcPercentage(Long titleCounts, Long employeeSize) {
        double result = ((double)titleCounts) / employeeSize;
        return (int) (result * 100);
    }

    private List<JobTitleInfo> stream2(Employee ceo) {
        System.out.println("attached flattened, size: " + ceo.size());

        // only reporting to CEO
        return ceo.flattened()
                .filter(f -> !f.getJobTitle()
                        .equalsIgnoreCase("ceo"))
                .collect(Collectors.groupingBy(Employee::getJobTitle, TreeMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .map(f -> new JobTitleInfo(f.getKey(),calcPercentage(f.getValue(),(ceo.size() - 1))))
                .collect(Collectors.toList());
    }

    /**
     * Good start for using the stream
     */
    private List<JobTitleInfo> embeddedInModel(Employee emp) {
        TreeMap<String, Long> grouping = emp.flattened()
                .filter(f -> !f.getJobTitle().equalsIgnoreCase("ceo"))
                .collect(Collectors.groupingBy(Employee::getJobTitle, TreeMap::new, Collectors.counting()));

        return grouping.entrySet()
                .stream()
                .map(f -> new JobTitleInfo(f.getKey(),calcPercentage(f.getValue(),(emp.size() - 1))))
                .collect(Collectors.toList());
    }

    /**
     * Option 1: Brute force
     */
    private int employeeCountByJobTitle(Employee emp, Map<String, Integer> groupJob) {
        int count = 0;

        for (Employee e : emp.getDirectReport()) {
            if (groupJob.containsKey(e.getJobTitle())) {
                groupJob.put(e.getJobTitle(), groupJob.get(e.getJobTitle()) + 1);
            } else {
                groupJob.put(e.getJobTitle(), 1);
            }

            count++;

            if (e.getDirectReport().size() > 0)
                count += employeeCountByJobTitle(e, groupJob);
        }

        return count;
    }

    private List<JobTitleInfo> bruteForce(Employee emp) {
        List<JobTitleInfo> results = new ArrayList<>();

        Map<String, Integer> groupJob = new TreeMap<>();
        int employeeSize = employeeCountByJobTitle(emp, groupJob);

        System.out.println("employees: " + employeeSize);

        for (Map.Entry<String, Integer> set : groupJob.entrySet()) {
            // when used tow integer it will become 0.0 instead of like 0.25 due to rounding to nearest
            double percent = ((double) set.getValue() / employeeSize) * 100;
            results.add(new JobTitleInfo(set.getKey(), (int)percent));
        }

        return results;
    }

    public static Stream<Employee> flatten(Employee emp) {
        return Stream.concat(
                Stream.of(emp),
                emp.getDirectReport().stream().flatMap(ExamMsApp::flatten));
//                .peek(System.out::println);
    }

    /**
     * Simple method of using stream
     */
    private List<JobTitleInfo> stream1(Employee emp) {
        List<Employee> flattened = emp.getDirectReport().stream()
                .flatMap(ExamMsApp::flatten)
                .collect(Collectors.toList());

        System.out.println("flattened helper, size: " + emp.size());
        return flattened
                .stream()
                .collect(Collectors.groupingBy(Employee::getJobTitle, TreeMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .map(f -> new JobTitleInfo(f.getKey(),calcPercentage(f.getValue(),(emp.size() - 1))))
                .collect(Collectors.toList());
    }

    private List<JobTitleInfo> getJobTitlePercentage(Employee ceo) {
        List<JobTitleInfo> results = new ArrayList<>();

        Map<String, Integer> groupJob = new TreeMap<>();
        int employeeSize = employeeCountByJobTitle(ceo, groupJob);

        System.out.println("employees: " + employeeSize);

        for (Map.Entry<String, Integer> set : groupJob.entrySet()) {
            // when used tow integer it will become 0.0 instead of like 0.25 due to rounding to nearest
            double percent = ((double) set.getValue() / employeeSize) * 100;
            results.add(new JobTitleInfo(set.getKey(), (int)percent));
        }

        return results;
    }
}
