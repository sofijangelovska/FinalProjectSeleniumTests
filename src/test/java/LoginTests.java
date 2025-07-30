import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CreateUserLoginPage;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;

public class LoginTests {
    private WebDriver driver;
    private ChromeOptions options;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;

    @Before

    public void setUp() {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);


    }

    @Test
    //Authentication failed.
    public void invalidEmail() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail("user123.gmail.com");
        createUserLoginPage.insertPassword("123456");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Authentication failed.", createUserLoginPage.getErrorMessage());
    }

    @Test

    public void invalidPassword() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail("user10@gmail.com");
        createUserLoginPage.insertPassword("1234");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Invalid credentials.", createUserLoginPage.getErrorMessage());
        assertEquals("Invalid email or password entered.", createUserLoginPage.getErrorMessage2());
    }


    @Test

    public void emptyEmailField() throws InterruptedException {

        sidePanel.clickLoginButton();
        createUserLoginPage.clearEmailField();
        createUserLoginPage.insertPassword("123456");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Authentication failed.", createUserLoginPage.getErrorMessage());
    }

    @Test

    public void emptyPasswordField() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail("user1310@hotmail.com");
        createUserLoginPage.clearPasswordField();
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Authentication failed.", createUserLoginPage.getErrorMessage());
    }

    @Test

    public void emptyEmailAndPasswordField() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clearEmailField();
        createUserLoginPage.clearPasswordField();
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Authentication failed.", createUserLoginPage.getErrorMessage());
    }


}
