package org.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.universalUtility.ListenerImpClass;
import org.tyss.universalUtility.ThreadSafeClass;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	public ProductPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath="//android.widget.TextView[@text='Add to cart']")
	private WebElement addToCart ;


	@FindBy(id="com.flipkart.android:id/cart_count")
	private WebElement addToCartbtn ;


	private String clickOnProduct="//android.widget.TextView[@text='%s']";

	private WebElement convertDynamicXathToElement(String partialXpath, String replaceData ) {
		String xpath = String.format(partialXpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}

	public ProductPage clickOnProduct(String replaceData) {
		convertDynamicXathToElement(clickOnProduct,replaceData).click();
		return this;
	}



	public ProductPage clickAddToCart(String expectedProduct) {
		addToCart.click();
		ListenerImpClass.testLog.info(expectedProduct+" is added to cart");
		ThreadSafeClass.getMobileUtility().waittillElement(2000);
		ThreadSafeClass.getMobileUtility().swipeAction(500, 550, 500, 1000, 500);
		ThreadSafeClass.getMobileUtility().swipeAction(500, 550, 500, 1000, 500);
		return this;
	}
	public void clickOnMiniCart() {
		addToCartbtn.click();
		ListenerImpClass.testLog.info("clicked on add to cart");
	}





}
