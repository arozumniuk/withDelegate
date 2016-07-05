package Tests;

import Data.ExperienceData;
import Data.NodeData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Data.ExperienceType.EVALUATION;
import static Data.NodeType.LIST;
import static Data.NodeType.TEXT_ONLY;
import static Data.NodeType.USER_SELECTION;

/**
 * Created by orozumniuk on 7/1/2016.
 */
public class PAPageTest extends TestBase {
    @Before
    public void PAPageTestPrecondition() throws Exception {

        /*app.go().toAdminModule_ManageContentPage();
        app.login().toAdminsModule("barney");

        app.go().toGroupDetailsPage("change_name");
        // TODO: 7/4/2016  add verification, that group, exp and nodes are exist
        if (!app.experience().isTextPresentOnPage("checkThePassingGradeCounting_forAllNodes")) {

            app.getLoosingTestData().createTestData_checkThePassingGradeCounting_forAllNodes();
        }
        if (!app.experience().isTextPresentOnPage("checkTheViewOfPage_withAllNodes")) {
            app.getLoosingTestData().createTestData_checkTheViewOfPage_withAllNodes();
        }*/

        app.go().toPerformanceAnalizer();
        app.login().login("bivko@dio-soft.com", "clickit2015");
    }

//==================Проверим, что название Excperience соответствует заданному и выведены все созданные ноды
    @Test
    public void checkTheViewOfPage_withAllNodes() throws Exception {
        app.performAnalizer().selectExperience("check_the_view_ofpage_withallnodes");

        String currentExpName = app.performAnalizer().getExperienceName();
        String expectedExpName = "checkTheViewOfPage_withAllNodes";
        Assert.assertEquals(currentExpName, expectedExpName);

        int currentCountOfQuestions = app.performAnalizer().getQuestionsGount();
        int expectedCountOfQuestions = 7;
        Assert.assertEquals(currentCountOfQuestions, expectedCountOfQuestions);
    }

//==================Проверим, что summary result считается правильно для случая, когда учитывается средний балл у всех ответов на вопрос типа "RatingQuestion"
    @Test
    public void checkThePassingGradeCounting_forAllNodes() throws Exception {
        app.performAnalizer().selectExperience("auto_passinggrades_forallnodes");

        app.performAnalizer().answerOnRatingQuestion("RatingQuestion_1", 8);
        app.performAnalizer().answerOnRatingQuestion("RatingQuestion_2", 10);
        app.performAnalizer().answerOnRatingQuestion("RatingQuestion_3", 9);
        app.performAnalizer().continueExperience();
        String actualResult = app.performAnalizer().getSummaryText();
        Assert.assertEquals(actualResult, "This participant has passed.");

    }
//==================Проверим, что summary result считается правильно для случая, когда учитывается  балл для каждого ответа на вопрос типа "RatingQuestion"
    @Test
    public void checkThePassingGradeCounting_forEACH_Node() throws Exception {
        app.performAnalizer().selectExperience("auto_passinggrades_foreachnodes");

        app.performAnalizer().answerOnRatingQuestion("RatingQuestion_1", 8);
        app.performAnalizer().answerOnRatingQuestion("RatingQuestion_2", 10);
        app.performAnalizer().answerOnRatingQuestion("RatingQuestion_3", 9);
        app.performAnalizer().continueExperience();
        String actualResult = app.performAnalizer().getSummaryText();

        Assert.assertEquals(actualResult, "This participant has failed.");
    }

//===================Проверим, что ответы для forced_ranked_questions могут быть установлены в требуемом порядке.
    @Test
    public void checkWorkWithFORCED_RANKED_QUESTION() {
        app.performAnalizer().selectExperience("check_work_with_forced_ranked_questions");
        app.performAnalizer().putItemOnPosition(1, "FORCED_RANKED_QUESTION__answer_7");
        String actualText = app.performAnalizer().getTextOfAnswerOnPosition(1);
        Assert.assertEquals("FORCED_RANKED_QUESTION__answer_7", actualText);
    }

// ====================Проверим, что информация про выбранные: customer profile и user выводится в summury
    @Test
    public void checkTheConfirmationSummury() throws InterruptedException {
        app.performAnalizer().selectExperience("check_the_confirmation_summary");
        app.performAnalizer().select("CONFIRMATION_SUMMARY_test_USER", "Bogdan Ivko" );
        app.performAnalizer().select("CONFIRMATION_SUMMARY_test_PROFILE", "Customer_profile_1" );
        app.performAnalizer().isTextPresentInWindow("jhfhjh");
        Assert.assertTrue("summary doesn't contain Bogdan Ivko", app.performAnalizer().isTextPresentInWindow("Bogdan Ivko"));
        Assert.assertTrue("summary doesn't contain customer_profile_1",app.performAnalizer().isTextPresentInWindow("Customer_profile_1"));




    }
}
