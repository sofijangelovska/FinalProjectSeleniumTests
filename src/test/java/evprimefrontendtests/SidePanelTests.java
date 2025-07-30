package evprimefrontendtests;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;

public class SidePanelTests {

    private WebDriver driver;
    private SidePanel sidePanel;

    @Before

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sidePanel = new SidePanel(driver);
        sidePanel.navigateTo("http://localhost:3000/");
    }

    @Test
    public void sidePanelItemsValidationWithoutLogin() throws InterruptedException {
        sidePanel.clickMenuIcon();

        Thread.sleep(10000);

        assertEquals("Home", sidePanel.getTextFromHomeButton());
        assertEquals("Events", sidePanel.getTextFromEventsButton());
        assertEquals("Contact", sidePanel.getTextFromContactButton());
        assertEquals("Login", sidePanel.getTextFromLoginButton());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
