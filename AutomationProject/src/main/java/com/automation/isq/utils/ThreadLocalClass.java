package com.automation.isq.utils;

public final class ThreadLocalClass {
	/** ThreadLocal variable */
	public static ThreadLocal<TestCaseUnit> threadLocal = new ThreadLocal<TestCaseUnit>();

	/** Sets the TestCaseUnit class object */
	public static void setTestCaseUnit(final TestCaseUnit mTestCaseUnit) {
		threadLocal.set(mTestCaseUnit);
	}

	/** used to remove TestCaseUnit object */
	public static void unsetTestCaseUnit() {
		threadLocal.remove();
	}

	/** Returns the TestCaseUnit object */
	public static TestCaseUnit getTestCaseUnit() {
		return threadLocal.get();
	}
}
