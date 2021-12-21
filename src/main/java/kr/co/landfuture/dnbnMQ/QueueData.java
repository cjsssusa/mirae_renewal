package kr.co.landfuture.dnbnMQ;

public class QueueData { // Queue로 보내는 자료구조

    private String jobTp;
    private int jobPm;

    // getters and setters

    public void setJobTp(String jobTp) {
        this.jobTp = jobTp;
    }

    public void setJobPm(int jobPm) {
        this.jobPm = jobPm;
    }

    public String getJobTp() {
        return this.jobTp;
    }

    public int getJobPm() {
        return this.jobPm;
    }

    public QueueData() {
        setJobTp("abi");
        setJobPm(35);
    }

}