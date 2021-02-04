package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils_pages.ElementsActions;


public class SearchResultsPage {

    private final WebDriver driver;
    //Elements
    private final By secondSearchResult = By.xpath("/html/body/div/div[1]/div/div/main/div[3]/ul/li[2]/div/a");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    @Step("Get Second displayed lesson from listed lessons out of search results page and navigate to the selected " +
            "lesson page")
    public LessonPage clickOnSecondSearchResult() {
        ElementsActions.click(driver, secondSearchResult);
        return new LessonPage(driver);
    }


}
