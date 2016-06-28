package Tests;

import Data.ExperienceType;
import Data.ExperienceData;
import org.junit.Test;

import static Data.Constants.ADMIN_PAGE_GROUPS;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class CreateExperienceTest extends TestBase {
    @Test
   /* public void createQuestionExperience() throws Exception {

        *//*app.getNavigationHelper().goToPage(ADMIN_PAGE_GROUPS);
        app.getSessionsHelper().loginToAdminsModule("barney");
       // String groupName = app.getGroupsHelper().createNewGroup();
        //app.getNavigationHelper().goToGroup("test_with_name_2");
        app.getExperienceHelper().createNewExperience("test_auto_first ) ", EVALUATION);

    }*//*
    }*/

    public void createNewExperience() throws Exception {
        app.getNavigationHelper().goToPage(ADMIN_PAGE_GROUPS);
        app.getSessionsHelper().loginToAdminsModule("barney");
        app.getNavigationHelper().goToGroup("change_name");
        app.getNavigationHelper().goToNewExpPage();
        app.getExperienceHelper().setExpType(ExperienceType.EVALUATION);

        String name = app.getNavigationHelper().generateRandomString(25);
        String code = app.getNavigationHelper().generateRandomString(25);

        app.getExperienceHelper().fillFields(new ExperienceData(name, code, "15", true,true));

    }
}



