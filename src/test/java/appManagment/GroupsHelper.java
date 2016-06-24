package appManagment;

import org.openqa.selenium.By;

import static appManagment.Constants.ADMIN_PAGE_GROUPS;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class GroupsHelper extends HelperBase{

    public GroupsHelper(ApplicationManager app) {
        super(app);
    }

    public void createNewGroup(){
        app.navigationHelper.goToPage(ADMIN_PAGE_GROUPS);
        click(By.className("add-group-btn"));
        type(By.id("group_title"),"test_auto_first )");
        click(By.name("button"));
    }
}
