package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;



public class HomePage {
    SHAFT.GUI.WebDriver driver;

            //** Locators **//

    By singUpAndLoginLink = By.xpath("(//ul[@class=\"nav navbar-nav\"]/li/a)[4]");

    By loggedInAS = By.xpath("(//ul[@class=\"nav navbar-nav\"]/li/a)[10]/b");


    public HomePage( SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


           //** Actions **//


    // navigate to singup/login page

    public void clickOnSingUpAndLogin()
    {
       driver.element().click(singUpAndLoginLink);

    }

    public String getLoginASName()
    {
        return driver.element().getText(loggedInAS);
    }






}
