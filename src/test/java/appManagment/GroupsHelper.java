package appManagment;

import org.openqa.selenium.By;

import static Data.Constants.ADMIN_PAGE_GROUPS;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class GroupsHelper extends HelperBase{

    public GroupsHelper(ApplicationManager app) {
        super(app);
    }

    public String createNewGroup(){
        app.navigationHelper.goToPage(ADMIN_PAGE_GROUPS);
        click(By.className("add-group-btn"));
        String groupName = generateGroupName(15);
        type(By.id("group_title"), groupName);
        click(By.name("button"));
        return groupName;
    }
}
