package appManagment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class HelperBase {
    protected WebDriver wd;
    protected ApplicationManager app;

    public HelperBase (ApplicationManager app){
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

    public void openPage(String url){
        wd.get(url);
    }



}
