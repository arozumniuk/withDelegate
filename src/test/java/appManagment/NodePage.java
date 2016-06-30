package appManagment;

import org.openqa.selenium.By;

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

    public void createAnswer(String text, int index){
        click(By.className("add-option"));
        type(By.xpath("//*[@class='row option']["+index+"]"),text);
    }

    public void createDescription(String text, int index){
        click(By.xpath("btn btn-link add-description-btn no-lp"));
    }


}
