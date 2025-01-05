package stepDefinitions;

import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
