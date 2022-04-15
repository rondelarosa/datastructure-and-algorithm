package com.test.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExamMsApp {
    /**
     * Given ceo has many employees what's the percentage per each job
     */
    public static void example() {
        ExamMsApp examMsApp = new ExamMsApp();

        Employee ceo = new Employee("Kevin", "CEO");

        Employee man1 = new Employee("Mike", "Manager");
        man1.directReport.add(new Employee("Lori", "Graphics"));

        Employee man2 = new Employee("Jon", "Manager");
        man2.directReport.add(new Employee("Jerry", "SWE"));

        ceo.directReport.add(man1);
        ceo.directReport.add(man2);

        examMsApp.getJobTitlePercentage(ceo)
                .forEach(j -> System.out.println(" job title: " + j.getJobTitle() + ", percentage: " + j.getPercentage() + "%"));

    }

    private int employeeCountByJobTitle(Employee emp, Map<String, Integer> groupJob) {

        int count = 0;

        for (Employee e : emp.directReport) {
            if (groupJob.containsKey(e.getJobTitle())) {
                groupJob.put(e.getJobTitle(), groupJob.get(e.getJobTitle()) + 1);
            } else {
                groupJob.put(e.getJobTitle(), 1);
            }

            count++;

            if (e.directReport.size() > 0)
                count += employeeCountByJobTitle(e, groupJob);
        }

        return count;
    }


    private List<JobTitleInfo> getJobTitlePercentage(Employee ceo) {
        List<JobTitleInfo> results = new ArrayList<>();
        // only good for not recursive
        //  Map<String, Long> employeeCountByJobTitle =
//        ceo.directReport.stream()
//                .collect(Collectors.groupingBy(Employee::getJobTitle, TreeMap::new, Collectors.counting()))
//                .forEach((jobTitle, count) -> results.add(new JobTitleInfo(jobTitle, count)));

        Map<String, Integer> groupJob = new TreeMap<>();
        int employeeSize = employeeCountByJobTitle(ceo, groupJob);

        System.out.println("employees: " + employeeSize);

        for (Map.Entry<String, Integer> set : groupJob.entrySet()) {
            // when used tow integer it will become 0.0 instead of like 0.25 due to rounding to nearest
            double percent = ((double) set.getValue() / employeeSize) * 100;
            results.add(new JobTitleInfo(set.getKey(), percent));
        }

        return results;
    }
}
