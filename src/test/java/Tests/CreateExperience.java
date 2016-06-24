package Tests;

import org.junit.Test;

import static appManagment.Constants.*;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class CreateExperience extends TestBase {
@Test
    public void createQuestionExperience(){
        app.getNavigationHelper().openPage(ADMIN_PAGE_GROUPS);
        app.getSessionsHelper().loginToAdminsModule("barney");

    }

}
