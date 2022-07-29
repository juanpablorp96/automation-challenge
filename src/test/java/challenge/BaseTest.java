package challenge;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class BaseTest {

    private static Driver driver;

    @Before
    public void beforeSuite(){
        driver = new Driver("chrome");
    }

    @After
    public void afterSuite(){
        if(driver != null){
            driver.getWebDriver().quit();
        }
    }

    public static Driver getDriver() {
        return driver;
    }

}
