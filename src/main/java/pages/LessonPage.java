package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils_pages.ElementsActions;

public class LessonPage {
    private final WebDriver driver;
    //Elements
    private final By previewWorkSheet = By.xpath("/html/body/div/div[1]/div/div/main/section[3]/div/div[2]/div/a");

    public LessonPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Scroll down to WorkSheet section (Scroll to the bottom of the page)")
    public LessonPage scrollDownToWorkSheet() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("scrollBy(0,2500)");
        return this;
    }

    @Step("Click on worksheet preview ")
    public WorkSheetPage openWorkSheet() {
        ElementsActions.click(driver, previewWorkSheet);
        return new WorkSheetPage(driver);

    }


}
