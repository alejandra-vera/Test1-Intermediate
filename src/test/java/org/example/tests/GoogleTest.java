package org.example.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    @Test
    public void testGetSearchBox() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Google googlePage = new Google(driver);
        WebElement searchBox = googlePage.getSearchBox();
        assertNotNull(searchBox);
        assertEquals("q", searchBox.getAttribute("name"));
        driver.quit();
    }

    @Test
    public void testGoogleInitialization() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Google googlePage = new Google(driver);
        assertNotNull(googlePage.searchBox);
                driver.quit();
            }
        
            private static class Google {
        
                public static final Object searchBox = null;
        
                public Google(WebDriver driver) {
        }

        private WebElement getSearchBox() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}