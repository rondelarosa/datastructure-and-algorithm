package com.test.microsoft;

public class JobTitleInfo {
    private String jobTitle;
    private double percentage;

    public String getJobTitle() {
        return jobTitle;
    }

    public double getPercentage() {
        return percentage;
    }

    public JobTitleInfo(String jobTitle, double percentage) {
        this.jobTitle = jobTitle;
        this.percentage = percentage;
    }

}
