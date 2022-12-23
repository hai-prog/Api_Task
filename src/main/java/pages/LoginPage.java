package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {

    SHAFT.GUI.WebDriver driver;

    // Locators //

    private By loginPageTitle = By.xpath("//div[@class=\"login-form\"]/h2");

    private   By emailAddressField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By passwordField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    private By errorMassage = By.xpath("//form[@action=\"/login\"]/p");

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email , String password)
    {
      driver.element().type(emailAddressField,email).
                       type(passwordField,password).
                       click(loginButton);

    }
}
