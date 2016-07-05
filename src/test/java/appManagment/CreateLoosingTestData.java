package appManagment;

import Data.ExperienceData;
import Data.NodeData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Data.ExperienceType.EVALUATION;
import static Data.NodeType.*;

/**
 * Created by orozumniuk on 7/4/2016.
 */
public class CreateLoosingTestData extends BasePage {

    public CreateLoosingTestData(ApplicationManager app) {
        super(app);
    }

    public void createTestData_checkThePassingGradeCounting_forAllNodes() throws Exception {
        List<WebElement> experiences = wd.findElements(By.xpath("//td[contains(text(), 'auto_passinggrades_forallnodes')]"));
        if (experiences.size() != 0) {
            app.experience().deleteExperience("auto_passinggrades_forallnodes");
        }
        ExperienceData experienceForTest = new ExperienceData("checkThePassingGradeCounting_forAllNodes", "auto_passinggrades_forallnodes", EVALUATION).withEvalSummary(true).withPassingGrade("9");
        app.go().createNewExperiencePage();
        app.experience().create(experienceForTest);
        app.experience().edit();
        app.experience().checkPassingGradeForAllOptionce();

        app.go().createNewNodePage();

        NodeData ratingQuestion_1 = new NodeData("RatingQuestion_1").withNodeType(RATING_QUESTION);
        app.node().createNewNode(ratingQuestion_1);

        NodeData ratingQuestion_2 = new NodeData("RatingQuestion_2").withNodeType(RATING_QUESTION);
        app.node().createNewNode(ratingQuestion_2);

        NodeData ratingQuestion_3 = new NodeData("RatingQuestion_3").withNodeType(RATING_QUESTION);
        app.node().createNewNode(ratingQuestion_3);
    }

    public void createTestData_checkThePassingGradeCounting_for_EACH_Nodes() throws Exception {

        app.go().toAdminModule_ManageContentPage();
        app.login().toAdminsModule("barney");
        app.go().toGroupDetailsPage("AUTO_TEST_DO_NOT_change_PLEASE");


        List<WebElement> experiences = wd.findElements(By.xpath("//td[contains(text(), 'auto_passinggrades_foreachnodes')]"));
        if (experiences.size() != 0) {
            app.experience().deleteExperience("auto_passinggrades_foreachnodes");
        }

        ExperienceData experienceForTest = new ExperienceData("checkThePassingGradeCounting_for_EACH_Nodes", "auto_passinggrades_foreachnodes", EVALUATION).withEvalSummary(true).withPassingGrade("9");
        app.go().createNewExperiencePage();
        app.experience().create(experienceForTest);
        app.experience().edit();
        app.experience().checkPassingGradeForAllOptionce();

        app.go().createNewNodePage();

        NodeData ratingQuestion_1 = new NodeData("RatingQuestion_1").withNodeType(RATING_QUESTION);
        app.node().createNewNode(ratingQuestion_1);

        NodeData ratingQuestion_2 = new NodeData("RatingQuestion_2").withNodeType(RATING_QUESTION);
        app.node().createNewNode(ratingQuestion_2);

        NodeData ratingQuestion_3 = new NodeData("RatingQuestion_3").withNodeType(RATING_QUESTION);
        app.node().createNewNode(ratingQuestion_3);
    }


    public void createTestData_checkTheViewOfPage_withAllNodes() throws Exception {

        List<WebElement> experiences = wd.findElements(By.xpath("//td[contains(text(), 'check_the_view_ofpage_withallnodes')]"));
        if (experiences.size() != 0) {
            app.experience().deleteExperience("check_the_view_ofpage_withallnodes");
        }
        ExperienceData experienceForTest = new ExperienceData("checkTheViewOfPage_withAllNodes", "check_the_view_ofpage_withallnodes", EVALUATION).withEvalSummary(true);

        app.go().createNewExperiencePage();
        app.experience().create(experienceForTest);

        app.go().createNewNodePage();
        String textOfQuestion = "just_question";
        String textOfAnswer = "just_answer";
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(QUESTION_WITH_MULTIPLE_CORRECT_ANSWERS).withAnswer(textOfAnswer));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(QUESTION_WITH_ONE_CORRECT_ANSWER).withAnswer(textOfAnswer));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(FORCED_RANKED_QUESTION).withAnswer(textOfAnswer));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(TEXT_ONLY));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(USER_SELECTION));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(FREE_FORM_TEXT_ENTRY_FIELD));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(RATING_QUESTION));
    }

    public void createTestData_checkWorkWithFORCED_RANKED_QUESTION() throws Exception {

        app.go().toAdminModule_ManageContentPage();
        app.login().toAdminsModule("barney");
        app.go().toGroupDetailsPage("AUTO_TEST_DO_NOT_change_PLEASE");


        List<WebElement> experiences = wd.findElements(By.xpath("//td[contains(text(), 'check_work_with_forced_ranked_questions')]"));
        if (experiences.size() != 0) {
            app.experience().deleteExperience("check_work_with_forced_ranked_questions");
        }
        ExperienceData experienceForTest = new ExperienceData("checkWorkWithFORCED_RANKED_QUESTION", "check_work_with_forced_ranked_questions", EVALUATION).withEvalSummary(true);

        app.go().createNewExperiencePage();
        app.experience().create(experienceForTest);

        app.go().createNewNodePage();
        String textOfQuestion = "FORCED_RANKED_QUESTION_test";

        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(FORCED_RANKED_QUESTION).withAnswer("FORCED_RANKED_QUESTION__answer"));
    }

    public void createTestData_checkTheConfirmationSummury() throws Exception {

        app.go().toAdminModule_ManageContentPage();
        app.login().toAdminsModule("barney");
        app.go().toGroupDetailsPage("AUTO_TEST_DO_NOT_change_PLEASE");


        List<WebElement> experiences = wd.findElements(By.xpath("//td[contains(text(), 'check_the_confirmation_summary')]"));
        if (experiences.size() != 0) {
            app.experience().deleteExperience("check_the_confirmation_summary");
        }
        ExperienceData experienceForTest = new ExperienceData("checkTheConfirmationSummury", "check_the_confirmation_summary", EVALUATION).withEvalSummary(true);

        app.go().createNewExperiencePage();
        app.experience().create(experienceForTest);

        app.go().createNewNodePage();

        app.node().createNewNode(new NodeData("CONFIRMATION_SUMMARY_test").withNodeType(TEXT_ONLY).withShowConfirmation(true));
        app.node().createNewNode(new NodeData("CONFIRMATION_SUMMARY_test_USER").withNodeType(USER_SELECTION));
        app.node().createNewNode(new NodeData("CONFIRMATION_SUMMARY_test_PROFILE").withNodeType(LIST).withAnswer("Customer_profile"));



    }



}
