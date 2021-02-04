package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils_pages.Logger;

import java.util.List;

public class WorkSheetPage {
    private final WebDriver driver;
    private final By allListedQuestions = By.className("question-number");

    public WorkSheetPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Count Number of all listed questions")
    public int countNumberOfQuestions() {
        List<WebElement> numOfQuestions = driver.findElements(allListedQuestions);
        Logger.logMessage("Number of listed questions:  " + numOfQuestions.size());
        return numOfQuestions.size();
    }
}
