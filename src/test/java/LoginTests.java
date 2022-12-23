import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTests {

    SHAFT.GUI.WebDriver driver ;
    SHAFT.API api;
    LoginPage loginPage;
    RegisterPage registerPage;
    HomePage homePage;

    @BeforeClass
    public void setUp()
    {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://automationexercise.com/");
        api = new SHAFT.API(" https://automationexercise.com/api/");
        loginPage = new LoginPage(driver);
        homePage =new HomePage(driver);
        registerPage = new RegisterPage(api);
        registerPage.createAccount("src/test/resources/testDataFiles/CreateAccountBody.json");
    }

    @Test
    public void testLoginSuccessfully()
    {
        homePage.clickOnSingUpAndLogin();
        loginPage.login(registerPage.getEmail(),registerPage.getPassword());
    }
}
