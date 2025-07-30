package evprimefrontendtests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;
import static util.DateBuilder.currentTime;
import static util.DateBuilder.customDate;

public class EventsTests {

    private WebDriver driver;
    private ChromeOptions options;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    private CreateEditAnEventForm createEditAnEventForm;
    private EventsPage eventsPage;
    private EventPage eventPage;

    @Before

    public void setUp() {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        createEditAnEventForm = new CreateEditAnEventForm(driver);
        eventsPage = new EventsPage(driver);
        eventPage = new EventPage(driver);

    }

    @Test

    public void createAnEventTest() throws InterruptedException {

        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStateButton();
        assertEquals("Create new user", createUserLoginPage.getTextFromTitle());

        String mail = "mail" + currentTime() + "@mail.com";
        String password = "userpass1";

        //create user
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        //login with user
        Thread.sleep(3000);
        sidePanel.clickLoginButton();

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        Thread.sleep(3000);
        //go to Event creation
        sidePanel.hoverPlusButton();
        Thread.sleep(3000);
        sidePanel.clickAddEventButton();

        //input value in form
        Thread.sleep(3000);
        createEditAnEventForm.insertEventTitle("Wizz Air Marathon");
        createEditAnEventForm.insertEventImage("https://trki.mk/storage/01JFV2VBJKEXT7FYQ9CB7JX0SK.jpg");
        createEditAnEventForm.insertEventDate(customDate(05, 10, 2025));
        createEditAnEventForm.insertEventLocation("Skopje");
        createEditAnEventForm.insertEventDescription("Register now for 21 edition of Wizz Air Skopje Marathon, 5 October");
        createEditAnEventForm.clickCreateEventButton();

        Thread.sleep(5000);
        //validate that the event is created
        assertEquals("Wizz Air Marathon", eventsPage.getTextFromTitle());
        assertEquals("https://trki.mk/storage/01JFV2VBJKEXT7FYQ9CB7JX0SK.jpg?w=248&fit=crop&auto=format", eventsPage.getSrcFromImage());
        assertEquals("05.10.2025", eventsPage.getEventDate());


        //update an event
        eventsPage.clickEvent();
        eventPage.clickEditEventButton();
        createEditAnEventForm.updateTitle("Wizz Air Marathon 2025");
        createEditAnEventForm.clickCreateEventButton();
        Thread.sleep(3000);
        assertEquals("Wizz Air Marathon 2025",eventPage.getTitle());

        //no button
        Thread.sleep(3000);
        eventPage.clickDeleteEventButton();
        Thread.sleep(3000);
        eventPage.clickNoButton();
        assertEquals(1, driver.findElements(By.xpath("//*[text()='Wizz Air Marathon 2025']")).size());
        Thread.sleep(3000);

        //logout
        sidePanel.clickLogoutButton();

        Thread.sleep(3000);

        //check events when user is logged out
        sidePanel.clickEventsButton();
        eventsPage.clickEvent();
        eventPage.getTitle();
        assertEquals("Wizz Air Marathon 2025",eventPage.getTitle());
        assertEquals("https://trki.mk/storage/01JFV2VBJKEXT7FYQ9CB7JX0SK.jpg", eventPage.getSrcFromImage());
        assertEquals("05.10.2025", eventPage.getEventDateEventPage());
        assertEquals("Skopje",eventPage.getTextFromEventLocation());
        assertEquals("Register now for 21 edition of Wizz Air Skopje Marathon, 5 October",eventPage.getTextFromEventDescription());

        eventPage.clickBackToEventsButton();

        Thread.sleep(5000);

        //login
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        Thread.sleep(5000);
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        sidePanel.clickEventsButton();
        Thread.sleep(5000);
        eventsPage.clickEvent();
        Thread.sleep(5000);
    }

   @After

    public void deleteEvent() throws InterruptedException {
        Thread.sleep(5000);
        eventPage.clickDeleteEventButton();
        Thread.sleep(5000);
        eventPage.clickDeleteButton();
        Thread.sleep(5000);
        assertEquals(0, driver.findElements(By.xpath("//*[text()='Wizz Air Marathon']")).size());


    }


}

