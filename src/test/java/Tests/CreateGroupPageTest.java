package Tests;

import Data.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by orozumniuk on 6/29/2016.
 */
public class CreateGroupPageTest extends TestBase {


    @Before
    public void createGroupPreconditions(){

        app.goTo().page(Constants.ADMIN_PAGE_GROUPS);
        app.login().toAdminsModule("barney");

    }
    @Test
    public void createGroupTest(){
        int beforeCount = app.groups().getCount();
        app.groups().create();
        int afterCount = app.groups().getCount();
        Assert.assertEquals(beforeCount, afterCount -1);
    }




}
