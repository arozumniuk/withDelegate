package Tests;

import Data.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Helpers.stringHelper.generateRandomName;


/**
 * Created by orozumniuk on 6/29/2016.
 */
public class CreateGroupPageTest extends TestBase {


    @Before
    public void createGroupPreconditions(){

        app.go().toStartPage(Constants.Urls.ADMIN_PAGE_GROUPS);
        app.login().toAdminsModule("barney");

    }
    @Test
    public void createGroupTest_ValidData(){
        String groupName = generateRandomName(25, "Test_Group");
        int beforeCount = app.groups().getCount();
        app.groups().create(groupName);
        int afterCount = app.groups().getCount();
        Assert.assertEquals(beforeCount, afterCount -1);
    }




}
