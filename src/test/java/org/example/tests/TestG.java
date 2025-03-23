package org.example.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static junit.framework.TestCase.fail;


public class TestG {
    private WebDriver driver;

    @Before
    public void setUp() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
        } catch (Exception e) {
            throw new RuntimeException("Hubo un error con el WebDriver. ", e);
        }
    }

    @Test
    public void test() throws InterruptedException, IOException {
        try {
            Google googlePage = new Google(driver);
            WebElement searchBox = googlePage.getSearchBox();
            searchBox.clear();
            searchBox.sendKeys("Automatización de pruebas");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            CommonMethods.highlight(driver, searchBox);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            CommonMethods.takeScreenshot(driver, "googleSearch");
            System.out.println("La prueba se ejecutó correctamente.");
        } catch (NoSuchElementException e) {
            System.err.println("Elemento no encontrado: " + e.getMessage());
            fail("Elemento no encontrado");
        } catch (Exception e) {
            System.err.println("Hubo un error en el testing: " + e.getMessage());
            fail("Error en la prueba");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

