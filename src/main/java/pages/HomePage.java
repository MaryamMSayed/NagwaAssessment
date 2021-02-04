package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils_pages.ElementsActions;

public class HomePage {
    //Elements
    private final WebDriver driver;
    private final By clickOnSearchIcon = By.cssSelector("body > header > div.top-header > div > div.search > button >" +
            " i");
    private final By searchTxtField = By.id("txt_search_query");

    // Create Constructor matching super
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    @Step("Click on Search icon")
    public HomePage clickOnSearchIconFromHomePage() {
        ElementsActions.click(driver, clickOnSearchIcon);
        return this;
    }

    @Step("Input search query into search text field")
    public HomePage inputSearchQueryIntoSearchTextField(String searchQuery) {
        ElementsActions.type(driver, searchTxtField, searchQuery, true);
        return this;
    }

    @Step("Click Enter Key to apply search and then navigate to Search Results Page")
    public SearchResultsPage clickEnterToApplySearch() {
        ElementsActions.clickEnterKey(driver, searchTxtField);
        return new SearchResultsPage(driver);
    }
}
