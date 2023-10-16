package com.hudl.stepDefinitions;

import com.hudl.pages.PageInitializer;
import com.hudl.utilities.ConfigurationReader;
import com.hudl.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends PageInitializer {

    @Before
    public void setUp() {
        Driver.getDriver();
        driver.get(ConfigurationReader.get("url"));
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}