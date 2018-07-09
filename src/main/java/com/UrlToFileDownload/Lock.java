package com.UrlToFileDownload;

public class Lock {
    private int runningThreadNumber;

    public Lock() {
        this.runningThreadNumber = 0;
    }

    public int getRunningThreadNumber() {
        return runningThreadNumber;
    }

    public void removeRunningThread() {
        this.runningThreadNumber = runningThreadNumber--;
    }

    public void addRunningThread() {
        this.runningThreadNumber++;
    }
}