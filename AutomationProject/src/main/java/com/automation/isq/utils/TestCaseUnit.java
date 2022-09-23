package com.automation.isq.utils;

import java.sql.Connection;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.automation.isq.report.model.TestCase;
import com.automation.isq.report.model.TestSuite;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

public class TestCaseUnit {

	private WebDriver driver = null;
	private long totalExecutionTimeTaken;
	private Date testcaseStartTime;
	private String errorMessages = "Verification failures : \n";
	private String browserString;
	private String testPackageName = "";
	private boolean testCaseFailStatus = false;
	private Connection connection;
	private ODatabaseDocumentTx oDBDoctx;
	private TestCase currentTestCase;
	private TestSuite currentTestSuit;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public long getTotalExecutionTimeTaken() {
		return totalExecutionTimeTaken;
	}

	public void setTotalExecutionTimeTaken(long totalExecutionTimeTaken) {
		this.totalExecutionTimeTaken = totalExecutionTimeTaken;
	}

	public Date getTestcaseStartTime() {
		return testcaseStartTime;
	}

	public void setTestcaseStartTime(Date testcaseStartTime) {
		this.testcaseStartTime = testcaseStartTime;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public String getBrowserString() {
		return browserString;
	}

	public void setBrowserString(String browserString) {
		this.browserString = browserString;
	}

	public String getTestPackageName() {
		return testPackageName;
	}

	public void setTestPackageName(String testPackageName) {
		this.testPackageName = testPackageName;
	}

	public boolean isTestCaseFailStatus() {
		return testCaseFailStatus;
	}

	public void setTestCaseFailStatus(boolean testCaseFailStatus) {
		this.testCaseFailStatus = testCaseFailStatus;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ODatabaseDocumentTx getoDBDoctx() {
		return oDBDoctx;
	}

	public void setoDBDoctx(ODatabaseDocumentTx oDBDoctx) {
		this.oDBDoctx = oDBDoctx;
	}

	public TestCase getCurrentTestCase() {
		return currentTestCase;
	}

	public void setCurrentTestCase(TestCase currentTestCase) {
		this.currentTestCase = currentTestCase;
	}

	public TestSuite getCurrentTestSuit() {
		return currentTestSuit;
	}

	public void setCurrentTestSuit(TestSuite currentTestSuit) {
		this.currentTestSuit = currentTestSuit;
	}
}
