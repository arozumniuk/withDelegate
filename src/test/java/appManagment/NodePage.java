package appManagment;

import Data.NodeData;
import Data.NodeType;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Data.NodeType.*;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class NodePage extends BasePage {


    public NodePage(ApplicationManager app) {
        super(app);
    }

    public void createQustion(String text){
        type(By.className("note-editor panel panel-default"),text);
    }

    public void createAnswer(NodeData data, int index){
        int index_html = 3;
        for (int i = 0; i<index; i++) {
            click(By.className("add-option"));
            type(By.xpath("//*[@class = 'container-fluid options-list']/div[" + index_html + "]//div[@class='note-editable panel-body']"), data.getAnswer()+ "_"+(i+1));
            index_html++;
        }
    }

    public void createDescription(NodeData data, int index){
        click(By.xpath("//*[@class='row option']["+index+"]//button[@class = 'btn btn-link add-description-btn no-lp']"));
        type(By.xpath("//*[@class='row option']["+index+"]//button[@class = 'note-editable panel-body']"),data.getDescription());
    }

    private void setNodeType(NodeType node){
        String nodeType = node.value();
        select(By.id("question-type"), nodeType);
    }

    public void createNewNode(NodeData node) throws Exception {
        app.go().createNewNodePage();
        setNodeType(node.getNodeType());
        type(By.xpath("//*[@class= 'note-editable panel-body']"), node.getQuestion());
        switch (node.getNodeType()){
            case TEXT_ONLY:
            break;
            case RATING_QUESTION:
               // TODO;
                break;
            case  FREE_FORM_TEXT_ENTRY_FIELD:
                //TODO;
                break;
            case USER_SELECTION:
                break;
            case  QUESTION_WITH_ONE_CORRECT_ANSWER:
                createAnswer(node, 3);
                break;
            case  QUESTION_WITH_MULTIPLE_CORRECT_ANSWERS:
                createAnswer(node, 3);
                break;
            case LIST:
                break;
            case FORCED_RANKED_QUESTION:
                createAnswer(node, 1 );
                break;
        }
        click(By.xpath("//button[@type= 'submit']"));
    }

}

