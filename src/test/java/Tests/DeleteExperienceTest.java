package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Data.Constants.Urls.ADMIN_PAGE_GROUPS;

/**
 * Created by orozumniuk on 7/1/2016.
 */
public class DeleteExperienceTest extends TestBase {

    @Before
    public void deleteGroupPreconditions(){

        app.go().toStartPage(ADMIN_PAGE_GROUPS);
        app.login().toAdminsModule("barney");
        // TODO: 7/1/2016 сделать проверку на наличие группы с названием, которое содержит expNAME

    }

    @Test
    public void deleteExperience() throws Exception {
        app.go().toGroupDetailsPage("AUTO_TEST_DO_NOT_change_PLEASE");
        int countGroupBeforeDelete = app.groups().getCount();
        app.experience().deleteAllExperiencesWichFinishedWith("expNAME");
        int countGroupAfterDelete = app.groups().getCount();
        Assert.assertEquals(countGroupBeforeDelete,countGroupAfterDelete);
    }
}
