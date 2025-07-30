package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CreateUserLoginPage;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;

public class SignupTests {

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
    public void invalidEmail() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("user123.gmail.com");
        createUserLoginPage.insertPassword("123456");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Invalid email.", createUserLoginPage.getErrorMessage2());
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
    }

    @Test
    public void invalidPassword() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("user101@gmail.com");
        createUserLoginPage.insertPassword("1234");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
        assertEquals("Invalid password. Must be at least 6 characters long.", createUserLoginPage.getErrorMessage2());
    }

    @Test
    public void invalidEmailAndPassword() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("user123.gmail.com");
        createUserLoginPage.insertPassword("1234");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
    }


    @Test
    public void emptyEmailField() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.clearEmailField();
        createUserLoginPage.insertPassword("123456");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
    }

    @Test
    public void emptyEmailFieldAndInvalidPassword() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.clearEmailField();
        createUserLoginPage.insertPassword("123");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Invalid email.", createUserLoginPage.getErrorMessage2());
        assertEquals("Invalid password. Must be at least 6 characters long.", createUserLoginPage.getErrorMessage3());
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
    }

    @Test
    public void invalidEmailAndEmptyPasswordField() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("user.gmail.com");
        createUserLoginPage.clearPasswordField();
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Invalid email.", createUserLoginPage.getErrorMessage2());
        assertEquals("Invalid password. Must be at least 6 characters long.", createUserLoginPage.getErrorMessage3());
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
    }

    @Test
    public void correctEmailAndEmptyPasswordField() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("user1310@hotmail.com");
        createUserLoginPage.clearPasswordField();
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Invalid password. Must be at least 6 characters long.", createUserLoginPage.getErrorMessage2());
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
    }

    @Test
    public void userAlreadyExistsAndCorrectPassword() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("angelovska1310@hotmail.com");
        createUserLoginPage.insertPassword("123456");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Email exists already.", createUserLoginPage.getErrorMessage2());
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());

    }

    @Test
    public void userAlreadyExistsAndIncorrectPassword() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("angelovska1310@hotmail.com");
        createUserLoginPage.insertPassword("1234");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Email exists already.", createUserLoginPage.getErrorMessage2());
        assertEquals("Invalid password. Must be at least 6 characters long.", createUserLoginPage.getErrorMessage3());
        assertEquals("User signup failed due to validation errors.", createUserLoginPage.getErrorMessage());
    }

    @Test
    public void userAlreadyExistsAndEmptyPasswordField() throws InterruptedException {
        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("angelovska1310@hotmail.com");
        createUserLoginPage.clearPasswordField();
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Email exists already.", createUserLoginPage.getErrorMessage2());
        assertEquals("Invalid password. Must be at least 6 characters long.", createUserLoginPage.getErrorMessage3());
    }

    @After
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }

}
