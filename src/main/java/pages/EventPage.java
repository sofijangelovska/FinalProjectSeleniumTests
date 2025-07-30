package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EventPage extends BasePage {

    private By eventPhoto = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[2]/div/img");
    private By backToEventsButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[2]/button");
    private By deleteEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/button");
    private By deleteButton = By.xpath("/html/body/div[2]/div[3]/div/div/button[1]");
    private By noButton = By.xpath("/html/body/div[2]/div[3]/div/div/button[2]");
    private By editEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");
    private By updateEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");
    private By title = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/h2");
    private By eventDate = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[2]/h6");
    private By eventLocation = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[3]");
    private By eventDescription = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[2]/span");

    public EventPage(WebDriver driver) {
        super(driver);
    }

    public void clickBackToEventsButton() {
        clickElement(backToEventsButton);
    }

    public void clickDeleteEventButton() {
        clickElement(deleteEventButton);
    }

    public void clickDeleteButton() {
        clickElement(deleteButton);
    }

    public void clickNoButton() {
        clickElement(noButton);

    }

    public void clickEditEventButton() {
        clickElement(editEventButton);
    }

    public String getTitle() {
        return getTextFromElement(title);
    }

    public String getSrcFromImage() {
        return driver.findElement(eventPhoto).getDomAttribute("src");
    }

    public String getEventDateEventPage() {
        return driver.findElement(eventDate).getText();
    }

    public String getTextFromEventLocation() {
        return getTextFromElement(eventLocation);
    }

    public String getTextFromEventDescription() {
        return getTextFromElement(eventDescription);
    }
}
