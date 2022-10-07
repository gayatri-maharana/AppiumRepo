package org.tyss.universalUtility;

import io.appium.java_client.android.AndroidDriver;

public class ThreadSafeClass {
	
	private static ThreadLocal<AndroidDriver> driver=new ThreadLocal<AndroidDriver>();
	private static ThreadLocal<JavaUtility> javaUtility=new ThreadLocal<JavaUtility>();
	private static ThreadLocal<MobileUtility>mobileUtility=new ThreadLocal<MobileUtility>();
	private static ThreadLocal<ExcelUtility>excelUtility=new ThreadLocal<ExcelUtility>();
	
	public static AndroidDriver getDriver() {
		return driver.get();
	}
	public static  void setDriver(AndroidDriver anddriver) {
		driver.set(anddriver);
	}
	
	public static JavaUtility getJavaUtility() {
		return javaUtility.get();
	}
	public static void setJavaUtility( JavaUtility actjavaUtility) {
		javaUtility.set(actjavaUtility);
	}
	public static MobileUtility getMobileUtility() {
		return mobileUtility.get();
	}
	public static void setMobileUtility(MobileUtility actmobileUtiltiUtility) {
		mobileUtility.set(actmobileUtiltiUtility);
	}
	public static ExcelUtility getExcelUtility() {
		return excelUtility.get();
	}
	public static void setExcelUtility(ExcelUtility excelUtility1) {
		excelUtility.set(excelUtility1);
	}
	

}
