package tests;


import data.ExcelDataReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.SelectLanguagePage;
import utils_tests.Helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CountWorkSheetQuestionsTest {
    public static WebDriver driver;
    ExcelDataReader excelDataReader;

    @Parameters("browser")
    @BeforeClass
    public void startDriver(@Optional("firefox") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://www.nagwa.com/");
    }

    @DataProvider(name = "Search_Query_sheet")
    public Object[][] searchQueryData() throws IOException {
        //For Getting Data From Excel Sheet
        excelDataReader = new ExcelDataReader();
        return excelDataReader.getExcelFileTestData();
    }


    @Test(description = "Count Questions in a work sheet", dataProvider = "Search_Query_sheet")
    @Description("Worksheet for a selected lesson page will open then we will count number of questions displayed on " +
            "it and print the " +
            "count")
    @Severity(SeverityLevel.NORMAL)
    public void testUserCanCountWorkSheetQuestion(String searchQuery) {
        int totalNumberOfQuestionInWorkSheet = new SelectLanguagePage(driver)
                .selectEnglishAsWebsiteLanguage()
                .clickOnSearchIconFromHomePage()
                .clickOnSearchIconFromHomePage()
                .inputSearchQueryIntoSearchTextField(searchQuery)
                .clickEnterToApplySearch()
                .clickOnSecondSearchResult()
                .scrollDownToWorkSheet()
                .openWorkSheet().countNumberOfQuestions();

        System.out.println("Total number of Question Displayed from @Test Method: " + totalNumberOfQuestionInWorkSheet);
    }

    // take screenshot when test case fail and add it in the Screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());

        }
    }

    @AfterClass
    public void stopDriver() {

        driver.quit();
    }
}
