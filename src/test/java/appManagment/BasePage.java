package appManagment;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
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

    public void type (By locator, String text) {
        click(locator);
       // wd.findElement(locator).clear();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.findElement(locator).sendKeys(text);
    }

    public void select(By locator, String text){
        Select select = new Select(wd.findElement(locator));
        select.selectByVisibleText(text);
    }

    public boolean isTextPresentOnPage(String text) {
        return wd.getPageSource().contains(text);
    }

    public String getPageTitle(){
        return wd.getTitle();
    }

    public String getCurrentUrl() {
        return wd.getCurrentUrl();
    }


    public void checkPageTitle(String expectedPageTitle) throws Exception {
        String currentPageTitle = getPageTitle();
        if (! currentPageTitle.equals(expectedPageTitle)){
            throw new Exception("Actual page: " + currentPageTitle + "\nExpectedPage"+ expectedPageTitle+ "\n URL: " +  getCurrentUrl() );
        }
    }

    public void confirmAction() {
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

    public void dismissAction() {
        Alert alert = wd.switchTo().alert();
        alert.dismiss();
    }

}
