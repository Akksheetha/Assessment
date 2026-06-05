package com.hooks;

import com.utils.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass {

    @Before
    public void setup() {
        HelperClass.initializeBrowser();
    }

    @After
    public void tearDown() {
        HelperClass.driver.quit();
    }

}