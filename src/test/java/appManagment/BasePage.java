package appManagment;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class BasePage {

    protected WebDriver wd;
    protected ApplicationManager app;

    public BasePage(ApplicationManager app){
        this.app = app;
        this.wd = app.wd;
    }

    public void click (By locator){
        wd.findElement(locator).click();
    }

    public void type (By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void select(By locator, String text){
        Select select = new Select(wd.findElement(locator));
        select.selectByVisibleText(text);
    }






}
