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

    /**
     * create new group
     * @param groupName - to be assigned for the new group
     */
    public void create(String groupName){
        click(By.className("add-btn"));
        type(By.id("group_title"), groupName);
        click(By.name("button"));

    }

    /**
     * generate randon name with
     * @param lengthOfName - should be more, then 11
     * @return
     */
    public String generateGroupName(int lengthOfName, String finish){
       return generateRandomName(lengthOfName,"_TEST_Group");
    }

    public int getCount() {
        return wd.findElements(By.xpath("//tr[@data-id]")).size();
    }
}
