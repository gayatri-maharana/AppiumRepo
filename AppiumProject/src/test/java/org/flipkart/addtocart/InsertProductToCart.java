package org.flipkart.addtocart;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.universalUtility.BaseClass;
import org.tyss.universalUtility.IConstants;
import org.tyss.universalUtility.ListenerImpClass;
import org.tyss.universalUtility.ThreadSafeClass;
@Listeners(org.tyss.universalUtility.ListenerImpClass.class)
public class InsertProductToCart extends BaseClass {

	@Test(retryAnalyzer = org.tyss.universalUtility.RetryImpClass.class)
	public void insertProductToCart() {
		
		homePage.searchProduct();
		String expectedProduct = homePage.getProduct();
		productPage.clickOnProduct(expectedProduct).clickAddToCart(expectedProduct).clickOnMiniCart();
		String actualProduct =addToCartPage.getProductName(expectedProduct);
		Assert.assertTrue(actualProduct.contains(expectedProduct));
		ThreadSafeClass.getJavaUtility().printStatement("Test Case Passed");
		ListenerImpClass.testLog.info("Test Case Passed");
	
	}
	
}
