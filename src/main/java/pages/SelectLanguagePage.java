package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils_pages.ElementsActions;

public class SelectLanguagePage {
    //Elements
    private final WebDriver driver;
    private final By selectEnglishLanguageOption = By.linkText("ENGLISH");

    // Create Constructor matching super
    public SelectLanguagePage(WebDriver driver) {

        this.driver = driver;
    }

    //Methods
    @Step("Select English Language and navigate to home page")
    public HomePage selectEnglishAsWebsiteLanguage() {
        ElementsActions.click(driver, selectEnglishLanguageOption);
        return new HomePage(driver);
    }


}
