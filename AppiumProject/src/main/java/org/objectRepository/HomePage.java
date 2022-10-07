package org.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.universalUtility.IConstants;
import org.tyss.universalUtility.ListenerImpClass;
import org.tyss.universalUtility.ThreadSafeClass;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	public HomePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Brand Mall']/parent::android.view.ViewGroup/android.view.ViewGroup[@index='2']")
	private WebElement searchBtn1 ;
	
	@FindBy(xpath="//android.widget.ImageView/following-sibling::android.widget.TextView")
	private WebElement product ;
	
	@FindBy(xpath="//android.widget.EditText")
	private WebElement searchTxtBox ;
	

	public void searchProduct() {
		searchBtn1.click();
		String catgory=ThreadSafeClass.getExcelUtility().getDataFromExcelSheet(IConstants.sheetName, 2, 1);
		 searchTxtBox.sendKeys(catgory);
		ThreadSafeClass.getMobileUtility().waittillElement(2000);
		ThreadSafeClass.getMobileUtility().tapAction(1, 500, 300, 500);
	}


	public String getProduct() {
		String product1 = product.getAttribute("text");
		ThreadSafeClass.getExcelUtility().setDataToExcel("FLIPKART", 2, 2, product1);
		ThreadSafeClass.getExcelUtility().saveWrittenDataToExcel(IConstants.EXCELFILEPATH);
		ListenerImpClass.testLog.info("Data is added to excel");
		String expectedProduct=ThreadSafeClass.getExcelUtility().getDataFromExcelSheet(IConstants.sheetName, 2, 2);
		return expectedProduct;
	}
	
	
}





