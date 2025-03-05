package org.example.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Highlighter;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

class highlight {

    public static void highlightE(WebDriver driver, WebElement elemento) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid yellow'", elemento);
    }
}

public class TestG {
    private WebDriver driver;

    @Before
    public void setUp() {

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
        } catch (Exception e) {
            throw new RuntimeException("Hubo un error con el WebDriver", e);
        }

    }
    @Test
    public void test() throws InterruptedException {
        try{
            WebElement searchBox = driver.findElement(By.name("q"));//q es el buscador
            searchBox.clear();
            searchBox.sendKeys("Automatización de pruebas");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            highlight.highlightE(driver, searchBox);//Highlight
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            searchBox.submit();
            //assertEquals("Automatización de pruebas", driver.getTitle());
        } catch (NoSuchElementException e) {
            System.err.println("Elemento no encontrado: " + e.getMessage());
            fail("Elemento no encontrado");

        } catch (Exception e) {
            System.err.println("Hubo un error en el testing: " + e.getMessage());
            fail("Error en la prueba");
        }




    }
    @After
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }
}
