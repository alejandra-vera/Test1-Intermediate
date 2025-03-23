package org.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    public Google(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchBox() {
        return searchBox;
    }
}