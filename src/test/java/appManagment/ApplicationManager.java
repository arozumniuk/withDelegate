package appManagment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class ApplicationManager {

    protected ExperiencePage experiencePage;
    protected GroupPage groupPage;
    protected NodePage nodePage;
    protected loginPage loginPage;
    protected goTo goTo;

    WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() {

        if (browser==(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("nativeEvents",false);
            wd = new InternetExplorerDriver(cap);

        }
        wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        experiencePage = new ExperiencePage(this);
        groupPage = new GroupPage(this);
        nodePage = new NodePage(this);
        loginPage = new loginPage(this);
        goTo = new goTo(this);
    }

    public void stop() {
        wd.quit();
    }

    public ExperiencePage experience() {
        return experiencePage;
    }

    public GroupPage groups() {
        return groupPage;
    }

    public NodePage node() {
        return nodePage;
    }

    public loginPage login() {
        return loginPage;
    }

    public goTo goTo() {
        return goTo;
    }
}
