package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersCode implements ITestListener{
	
	private static final Logger logger = LogManager.getLogger(ListenersCode.class);
	public void onTestSuccess(ITestResult result) {
        System.out.println("Passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failed: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped: " + result.getName());
    }

}