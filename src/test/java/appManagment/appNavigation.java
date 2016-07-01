package appManagment;

import Data.Constants.Urls.*;
import org.openqa.selenium.By;

import static Data.Constants.Urls.PERFORMANCE_ANALIZER;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class appNavigation extends BasePage {

    public appNavigation(ApplicationManager app) {
        super(app);
    }

    public void toStartPage(String url){
        wd.get(url);
    }

    public void createNewExperiencePage() throws Exception {
        click(By.className("add-btn"));
        checkPageTitle("Create new experience | Admin console");
    }

    public void toGroupDetailsPage(String groupName) throws Exception {
        click(By.linkText(groupName));
        checkPageTitle("Group details | Admin console");
    }

    public void toExperienceDetailsPage(String expName) throws Exception {
        click(By.linkText(expName));
        checkPageTitle("Experience details | Admin console");
    }

    public void createNewNodePage() throws Exception {
        click(By.className("add-btn"));
        checkPageTitle("Add new question | Admin console");
    }

    public void toPerformanceAnalizer() throws Exception {
        toStartPage(PERFORMANCE_ANALIZER);
    }




}

