# NagwaAssessment
As a part of hiring process an automation assessment using Selenium , Maven, Java and Testng 

# Test Scenario 

- Search for a lesson subject , 

- select the second search result from suggested lessons ,

- open the lesson worksheet and then count the number of listed questions 

# Technology Stack

* Selenium as automation Framework 

* Testng as a unit testing FrameWork

* Java as a programming languge 

* Maven building depencies 

* Allure For creating Test results Reports 
* Page Object Model as a design pattern

# You can create test results report after Clone the repo and run the project successfully using following:
  1.  Direct to the project path into your local machine using terminal or using IDE of your prefrence 
  
  2.  run command allure serve 
  
  **make sure that allure report pinary path is added to your system variable path**
  
 
# Code WorkFlow 

   **Pages**
  
  1. Under src/main/java/pages : i have created a seprate .java class for every page involved in our test following page object model conncept 
     
     1. SelectLanguagePage.java ( To select website language before navigatin to home page)
     
     2. HomePage.java  (To open search option, send search query and then apply search)
     
     3. SearchResultsPage.java ( get the search results,  select the second lesson from the list)
     
     4. LessonPage.java  (Scroll down to the worksheet section , open worksheet page)
     
     5. WorkSheetPage.java  (Count the listed questions and return the number )
     
   **utils_Pages**
   
      1. ElementsActions.java  (Holds all actions that could be preformed on the elements we are using ex. .click (), .type() ...etc)
      
      2. HelperPages.java     (Perform wait , hover over element , mouse double click )
      
      3. Logger.java   (Log messages and display over terminal )
      
     
  **Tests**
  
 1. Under src/test/java/data/ExcelDataReadeer.java   (This class used to manage importing src/test/java/dat/Search_query_sheet.xlsx file and geting its data to be used later as a data provider to out test method 
  It uses poi Lib to manage .xlsx  files as mentioned ).
  
  2. Under src/test/java/dat/Search_query_sheet.xlsx  the excel file holds our search queries 
  3. Under  src/test/java/tests/CountWorkSheetQuestionTest.java ( Holds our @Test method  that contains implemention of all mentioned steps above under *Pages* section )
  4. Using @DataProvider overriden method to hold the retuned data from the excel sheet in 2 dimensions array [][] and send it to our @Test method as a string value pramter  and our final test will be like that :
  
  
  
  
  <    
  
  public void testUserCanCountWorkSheetQuestion(String searchQuery) {
      
      
        int totalNumberOfQuestionInWorkSheet = new SelectLanguagePage(driver)
        
                .selectEnglishAsWebsiteLanguage()
                
                .clickOnSearchIconFromHomePage()
                
                
                .inputSearchQueryIntoSearchTextField(searchQuery)
                
                .clickEnterToApplySearch()
                
                .clickOnSecondSearchResult()
                
                .scrollDownToWorkSheet()
                
                .openWorkSheet().countNumberOfQuestions();
                

        System.out.println("Total number of Question Displayed from @Test Method: " + totalNumberOfQuestionInWorkSheet);
        
    }
    
    >
    
  
  
  
  
  
  

