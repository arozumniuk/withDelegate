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
    protected appNavigation appNavigation;
    protected PA pa;
    protected ReportsPage reportsPage;
    protected CreateLoosingTestData createLoosingTestData;

    WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() {

        if (browser==(BrowserType.FIREFOX)) {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("nativeEvents",false);
            wd = new FirefoxDriver(cap);
        } else if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("nativeEvents",false);
            wd = new InternetExplorerDriver(cap);

        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        experiencePage = new ExperiencePage(this);
        groupPage = new GroupPage(this);
        nodePage = new NodePage(this);
        loginPage = new loginPage(this);
        appNavigation = new appNavigation(this);
        pa = new PA(this);
        reportsPage = new ReportsPage(this);
        createLoosingTestData = new CreateLoosingTestData(this);
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
    public appNavigation go() {
        return appNavigation;
    }
    public PA performAnalizer() {return pa;}
    public ReportsPage ReportsPage() {
        return reportsPage;
    }
    public CreateLoosingTestData getLoosingTestData() {return createLoosingTestData;}

}
