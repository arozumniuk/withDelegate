package Tests;

import appManagment.BasePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by orozumniuk on 7/1/2016.
 */
public class PAPageTest extends TestBase {
    @Before
    public void PAPageTestPrecondition() throws Exception {
        app.go().toPerformanceAnalizer();
        app.login().login("bivko@dio-soft.com", "clickit2015");
    }

    @Test
    public void checkTheViewOfPage(){
        app.performAnalizer().selectExperience("al4dtzi_exp");

        String currentExpName = app.performAnalizer().getExperienceName();
        String expectedExpName = "at2ppbh_expNAME";
        Assert.assertEquals(currentExpName,expectedExpName);

        int currentCountOfQuestions = app.performAnalizer().getQuestionsGount();
        int expectedCountOfQuestions = 7;
        Assert.assertEquals(currentCountOfQuestions, expectedCountOfQuestions);
    }
}
