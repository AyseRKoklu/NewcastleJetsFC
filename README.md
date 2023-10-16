# NewcastleJetsFC - Web Automation Framework

### Introduction
This is a BDD test automation framework written in Selenium - Java. This automation contains Test Scenarios for Login functionality for [Newcastle Jets FC project](https://www.hudl.com/en_gb/) and validates the UI components for the related ticket. 

In this document, you will find an overview of the repo, tools being used, and how to run the tests.

### Framework Structure
I have five layers in the code, and they are:
1. First layer = **features** directory
2. Second layer = **pages** package
3. Third layer = **runners** package
4. Fourth layer = **stepDefinitions** package
5. Fifth layer = **utilities** package

#### File Organisation
All the codes are stored in the **src** directory. Under src > test, I have **java** and **resources**.

**resources** includes (i) **features** directory where the Cucumber-BDD tests are stored in **.feature** files and (ii) **configuration.properties** that contains **browser** and **url**.

**java** > **com** > **hudl** includes four packages. 

**pages** package contains (i) **CommonPageElements** for setting up and initialising page elements, (ii) **LoginPage** for the implementation of POM, and (iii) **PageInitializer** for centralising the initialisation of the specified page objects.

**runners** package contains two classes that run tests using tags (i.e., **TestRunner**) and failed tests (i.e., **FailedTestRunner**).

**stepDefinitions** package contains (i) **Hooks** for setting up the test environment and tearing down the WebDriver instance, and (ii) **LoginStepDefinition** to implement the steps written in **.feature** file.

**utilities** package contains (i) **CommonSteps** that includes the reusable methods, (ii) **ConfigurationReader** to read the **configuration.properties**, (iii) **Driver** to implement Singleton Design Pattern.

![](../Screenshot 2023-10-16 at 1.50.37 am.png)

#### Naming Conventions
I use **CamelCase** notation which is a naming convention in which a name is formed of multiple words that are joined together as a single word with the first letter of each of the multiple words capitalised so that each word that makes up the name can be easily read.

### Tools and Framework Installation
- Download and install [IntelliJ IDEA Community version](https://www.jetbrains.com/idea/download/?section=mac).
- Download and install [Google Chrome](https://www.google.com/intl/en_uk/chrome/).
- Additional Plugins & Extensions for IntelliJ:
  - Cucumber +
  - Cucumber for Java
  - Gherkin
  - Maven
  - JUnit

PS: Once the project is pulled from GitHub, the additional tools should come with the project through **pom.xml**, in the case of not proper installation of any plugins, these can also be found through IntelliJ IDEA (tab on the left top corner when IntelliJ is open) > Settings > Plugins > _Type in the search bar_

### Steps for Executing the Existing Code
1. Clone GitHub Repository: https://github.com/AyseRKoklu/NewcastleJetsFC
2. Open the project in IntelliJ IDEA.
3. Navigate to **login.feature** and type a tag (e.g., @LocalRun) on the first line.
4. Navigate to **TestRunner** and type the same tag after **tags =** within the quotation marks (i.e., if the tag **@LocalRun** is used in the **login.feature**, type **tags = "@LocalRun"** in **TestRunner**)

### Tools being used:
- Java: Java is used as the programming language.
- Selenium: Selenium is used to automate the web browser, helps with imitating user interaction with browsers etc.
- Cucumber: This is used to implement Behaviour Driven Development approach and to utilise Gherkin language.
- JUnit: Junit is used for assertion and verification purposes. 
