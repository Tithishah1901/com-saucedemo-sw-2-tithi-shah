package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test in the ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify the text “Products”
 * 2. verifyThatSixProductsAreDisplayedOnPage()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify that six products are displayed
 * on page
 */

public class LoginTest extends BaseTest {
    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // Enter the required details
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // click on Login button
        driver.findElement(By.id("login-button")).click();

        //verify the Products Area text
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class = 'title']")).getText();
        //String actualText = driver.findElement(By.xpath("//div[@id= 'flash'][@class = 'flash success']")).getText();

        // Verify with Assert Junit test
        Assert.assertEquals("Products text not displayed", expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        // Enter the required details
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // click on Login button
        driver.findElement(By.id("login-button")).click();

        //get total product of the list
        int totalProduct = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']")).size();

        // Verify with Assert Junit test
        Assert.assertEquals("Total product is not match", 6, totalProduct);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
