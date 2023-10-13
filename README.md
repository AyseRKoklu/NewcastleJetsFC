# NewcastleJetsFC

-----Tools being used:
- Java: Java is used as programming language.
- Selenium: Selenium provides support for the automation of web browsers, helps with imitating user interaction with browsers etc.
- WebDriver Manager: This is an automated driver management and it provides helper features for Selenium WebDriver in Java.
- Cucumber: This is used to implement Behaviour Driven Development approach and to utilise Gherkin language.
- JUnit: Junit is used for assertion and verification purposes. 
- Cucumber Reporting: This produces reports that contain information about what scenarios have passed or failed.

-----Approach:
- Behaviour-Driven Development (BDD) is implemented by using Cucumber. Feature files comprises the business layer and is written in Gherkin language. Step definitions is the implementation layer.
- Data-Driven Testing (DDT) is implemented using Scenario Outlines and Examples by the means of passing several data within one Examples table. Therefore, number of steps written is reduced vastly (considering the steps that would be produced for each positive and negative tests). 
- I used Page Object Model (POM) Design Pattern for my framework. By using POM, I located the Web Elements beforehand under "pages" package which helps with the code reusability (each Web Element is located only once - no duplication) and improved the code maintanence. 
- I passed my URL and browser in "configuration.properties" to avoid hard coding.  
- "utilities" package consist of two classes. "ConfigurationReader" is used to read the configuration.properties. "Driver" class is where I created my driver instance as well as getDriver and closeDriver methods. 
- I used Singleton Design Pattern when creating my driver instance. This ensures that the same instance of the driver is called everytime I call it, regardless of where and when I call it. 
- In "runners" package I have two classes, "FailedTestRunner" and "TestRunner". FailedTestRunner is used to run the failed tests. TestRunner is where my tests are runned from. It has "@CucumberOptions" annotation and inside I have plugin (for reports), features (path for feature files), glue (path for step definitions), dryRun (to get the snippets when true), and tags (to maintain the tests when running). 
- In "step_definitions" package I have "Hooks" and "Registration_StepDefinition". In Hooks, I have method to get my URL before scenario (used @Before annotation for that) and tearDownScenario (with @After annotation) to take screenshot of the failed scenarios and to close Driver. "Registration_StepDefinition" is the implementation layer. It is where I wrote my code behind feature files steps. 
