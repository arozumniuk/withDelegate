package appManagment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by orozumniuk on 7/1/2016.
 */
public class PA extends BasePage {

    public PA(ApplicationManager app) {
        super(app);
    }

    public void selectExperience(String text){
        type(By.id("input_2"), text);
        click(By.xpath("//button[@type = 'button']"));
    }

    public int getQuestionsGount(){
        List<WebElement> questions = wd.findElements(By.xpath("//div/*[@question = 'node']"));
        return questions.size();
    }

    public String getExperienceName(){
        return wd.findElement(By.xpath("//h2[@class = 'ng-binding']")).getText();
    }
}
