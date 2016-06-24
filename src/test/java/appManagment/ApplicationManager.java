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

    protected ExperienceHelper experienceHelper;
    protected GroupsHelper groupsHelper;
    protected NodesHelper nodesHelper;
    protected PAHelper paHelper;
    protected ReportsHelper reportsHelper;
    protected UserHelper userHelper;
    protected SessionsHelper sessionsHelper;
    protected NavigationHelper navigationHelper;

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

        experienceHelper = new ExperienceHelper(this);
        groupsHelper = new GroupsHelper(this);
        nodesHelper = new NodesHelper(this);
        paHelper = new PAHelper(this);
        reportsHelper = new ReportsHelper(this);
        userHelper = new UserHelper(this);
        sessionsHelper = new SessionsHelper(this);
        navigationHelper = new NavigationHelper(this);
    }



    public void stop() {
        wd.quit();
    }

    public ExperienceHelper getExperienceHelper() {
        return experienceHelper;
    }

    public GroupsHelper getGroupsHelper() {
        return groupsHelper;
    }

    public NodesHelper getNodesHelper() {
        return nodesHelper;
    }

    public PAHelper getPaHelper() {
        return paHelper;
    }

    public ReportsHelper getReportsHelper() {
        return reportsHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
    public SessionsHelper getSessionsHelper() {
        return sessionsHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
