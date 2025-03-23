package org.example.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid blue'", element);
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            System.out.println("Intentando tomar captura de pantalla..."); // Imprime un mensaje de inicio
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            System.out.println("Captura de pantalla tomada: " + source.getAbsolutePath()); // Imprime la ruta del archivo temporal
            File destination = new File("./screenshots/" + screenshotName + ".png");
            FileUtils.copyFile(source, destination);
            System.out.println("Captura de pantalla guardada en: " + destination.getAbsolutePath()); // Imprime la ruta del archivo de destino
        } catch (IOException e) {
            System.err.println("Error al tomar la captura de pantalla: " + e.getMessage());
            e.printStackTrace();
        }
    }
}