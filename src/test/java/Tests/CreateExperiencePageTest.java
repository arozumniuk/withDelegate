package Tests;

import Data.ExperienceData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Data.Constants.Urls.ADMIN_PAGE_GROUPS;
import static Data.ExperienceType.EVALUATION;
import static Helpers.stringHelper.generateRandomName;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class CreateExperiencePageTest extends TestBase {


    @Before
    public void createGroupPreconditions(){

        app.go().toStartPage(ADMIN_PAGE_GROUPS);
        app.login().toAdminsModule("barney");

    }

    @Test
    public void createNewExperience_validData() throws Exception {

        app.go().toGroupDetailsPage("AUTO_TEST_DO_NOT_change_PLEASE");
        int before = app.experience().getCount();

        app.go().createNewExperiencePage();
        String name = generateRandomName(25, "Test_exp");
        String code = generateRandomName(5, "_at");
        app.experience().create(new ExperienceData(name, code, EVALUATION )
                .withEvalSummary(true).withPassingGrade("25").withProfileSelection(true).withTimer(true).withTimerDuration("55"));

        app.go().toGroupDetailsPage("AUTO_TEST_DO_NOT_change_PLEASE");
        int after = app.experience().getCount();
        Assert.assertEquals(before+1,after);
    }
}



