package pages; //kaj nego CreationOfEvent

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreateEditAnEventForm extends BasePage {


    private By eventTitle = By.name("title");
    private By eventImage = By.name("image");
    private By eventDate = By.name("date");
    private By eventLocation = By.name("location");
    private By eventDescription = By.cssSelector("textarea[name='description']");
    private By createEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");

    public CreateEditAnEventForm(WebDriver driver) {
        super(driver);
    }

    public void insertEventTitle(String value) {
        insertText(eventTitle, value);
    }

    public void insertEventImage(String value) {
        insertText(eventImage, value);
    }

    public void insertEventDate(String value) {
        insertText(eventDate, value);
    }

    public void insertEventLocation(String value) {
        insertText(eventLocation, value);
    }

    public void insertEventDescription(String value) {
        insertText(eventDescription, value);
    }

    public void clickCreateEventButton() {
        clickElement(createEventButton);
    }

    public void updateTitle(String title) {
        WebElement insertTitle = driver.findElement(eventTitle);
        insertTitle.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        insertTitle.sendKeys(title);
    }


}
