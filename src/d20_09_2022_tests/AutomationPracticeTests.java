package d20_09_2022_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomationPracticeTests extends BasicTest {
	
	@Test(priority = 10)
	public void AutomationPracticeTests () {
		driver.get(baseUrl +  "/index.php?id_product=1&controller=product");
		buyBoxPage.scrollToBuyBox();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");
		buyBoxPage.getSizeInput("L");
		buyBoxPage.getColourButton("Blue");
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForDialogToBeVisible();
		Assert.assertEquals(layerCartPage.getProductQuantity().getText(),
				"3", "Product quantity did not mach");
		Assert.assertEquals(layerCartPage.getProductTotalPrice().getText(),
				"$49.53", "Total price did not mach");
		layerCartPage.getContinueShoppingButton().click();
		layerCartPage.waitForDialogToBeInvisible();
		driver.get(baseUrl +  "/index.php?id_product=2&controller=product");
		buyBoxPage.scrollToBuyBox();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");
		buyBoxPage.getSizeInput("S");
		buyBoxPage.getColourButton("Black");
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForDialogToBeVisible();
		layerCartPage.getProceedToCheckoutButton().click();
		Assert.assertEquals(driver.getTitle(),
				"Order - My Store", "Titles did not mach");
	}
	
	@Test(priority = 20)
	public void topMenuMouseOver() {
		SoftAssert softAssert = new SoftAssert();
		topMenuPage.getMenuForWomenButton();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("(//ul[contains(@class, 'submenu-container')])[1]")));
		topMenuPage.getMenuForDressesButton();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("(//ul[contains(@class, 'submenu-container')])[2]")));
		
        topMenuPage.getTshirtsButton();
        
        softAssert.assertTrue(wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By
						.xpath("(//ul[contains(@class, 'submenu-container')])[1]"))));
        softAssert.assertTrue(wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By
						.xpath("(//ul[contains(@class, 'submenu-container')])[2]"))));
		softAssert.assertAll();
		
	}
}

	
	
	
	
	
	
	
