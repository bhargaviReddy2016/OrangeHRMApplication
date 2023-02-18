package com.OrangeHRM.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners_Util implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("*********Test started for method"+result.getName()+"**********");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*********Test successful for method"+result.getName()+"**********");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*********Test failed for method"+result.getName()+"**********");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*********Test skipped for method "+result.getName()+"**********");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("*********Test started for class "+context.getName()+"**********");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("*********Test finished for class "+context.getName()+"**********");
		
	}
}
