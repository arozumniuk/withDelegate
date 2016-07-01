package Tests;

import Data.ExperienceData;
import Data.ExperienceType;
import Data.NodeData;
import appManagment.ExperiencePage;
import org.junit.Before;
import org.junit.Test;

import static Data.Constants.Urls.ADMIN_PAGE_GROUPS;
import static Data.ExperienceType.EVALUATION;
import static Data.NodeType.*;
import static Helpers.stringHelper.generateRandomName;
import static Helpers.stringHelper.generateRandomString;

/**
 * Created by orozumniuk on 6/30/2016.
 */
public class CreateNodePageTest extends TestBase {

    @Before
    public void createNodePreconditions() throws Exception {

        app.go().toStartPage(ADMIN_PAGE_GROUPS);
        app.login().toAdminsModule("barney");
        app.go().toGroupDetailsPage("change_name");



    }


    @Test
    public void createNodeTest() throws Exception {
        String expName = generateRandomName(15,"_expNAME");
        String expCode = generateRandomName(15,"_exp");
        ExperienceData exp = new ExperienceData(expName, expCode, EVALUATION);
        app.go().createNewExperiencePage();
        app.experience().create(exp);

        app.go().createNewNodePage();
        String textOfQuestion = generateRandomName(25, "_question");
        String textOfAnswer = generateRandomName(25, "_answer");
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(QUESTION_WITH_MULTIPLE_CORRECT_ANSWERS).withAnswer(textOfAnswer));
       /* app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(QUESTION_WITH_ONE_CORRECT_ANSWER).withAnswer(textOfAnswer));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(FORCED_RANKED_QUESTION).withAnswer(textOfAnswer));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(TEXT_ONLY));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(USER_SELECTION));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(FREE_FORM_TEXT_ENTRY_FIELD));
        app.node().createNewNode(new NodeData(textOfQuestion).withNodeType(RATING_QUESTION));*/

    }

}
