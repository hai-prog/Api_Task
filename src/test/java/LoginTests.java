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
        // open the website
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://automationexercise.com/");

        // create account
        api = new SHAFT.API(" https://automationexercise.com/api/");
        registerPage = new RegisterPage(api);
        registerPage.createAccount();

        loginPage = new LoginPage(driver);
        homePage =new HomePage(driver);
    }

    @Test
    public void testLoginSuccessfully()
    {
        homePage.clickOnSingUpAndLogin();
        loginPage.login(registerPage.getEmail(),registerPage.getPassword());
        SHAFT.Validations.assertThat().object(homePage.getLoginASName()).isEqualTo(registerPage.getName()).perform();
    }
}
