package Tests;

import Data.Constants;
import Data.ExperienceType;
import Data.ExperienceData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Helpers.stringHelper.generateRandomString;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class CreateExperiencePageTest extends TestBase {


    @Before
    public void createGroupPreconditions(){

        app.goTo().page(Constants.ADMIN_PAGE_GROUPS);
        app.login().toAdminsModule("barney");

    }

    @Test
    public void createNewExperience() throws Exception {

        app.groups().openGroup("change_name");
        int before = app.experience().getCount();
        app.goTo().newExperiencePage();

        String name = generateRandomString(25);
        String code = generateRandomString(25);

        app.experience().create(new ExperienceData(name, code, ExperienceType.EVALUATION )
                .withEvalSummary(true).withPassingGrade("25").withProfileSelection(true).withTimer(true).withTimerDuration("55"));

        app.groups().openGroup("change_name");
        int after = app.experience().getCount();

        Assert.assertEquals(before+1,after);
    }
}



