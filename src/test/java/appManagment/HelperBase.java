package appManagment;

import org.apache.commons.lang3.RandomStringUtils;
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

    public String generateRandomString(int stringLength){
        return  RandomStringUtils.randomAlphabetic(stringLength);
    }

    public static String generateGroupName(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +   //alphabets
                "1234567890" +   //numbers
                "";   //special characters

        String temp = RandomStringUtils.random(length, allowedChars);
        return   temp.substring(0, temp.length() - 5) + "-test";
          }





}
