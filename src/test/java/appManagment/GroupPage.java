package appManagment;

import org.openqa.selenium.By;

import static Helpers.stringHelper.generateRandomName;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class GroupPage extends BasePage {

    public GroupPage(ApplicationManager app) {
        super(app);
    }

    public String create(){
        //app.goTo.page(ADMIN_PAGE_GROUPS);
        click(By.className("add-btn"));
        String groupName = generateGroupName(15);
        type(By.id("group_title"), groupName);
        click(By.name("button"));
        return groupName;
    }

    /**
     *
     * @param lengthOfName - should be more, then 11
     * @return
     */
    public String generateGroupName(int lengthOfName){
       return generateRandomName(lengthOfName,"_TEST_Group");
    }
    public void openGroup(String groupName){
        click(By.linkText(groupName));
    }
    public int getCount() {
        return wd.findElements(By.xpath("//tr[@data-id]")).size();
    }
}
