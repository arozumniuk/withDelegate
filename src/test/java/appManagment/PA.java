package appManagment;

import Data.NodeData;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by orozumniuk on 7/1/2016.
 */
public class PA extends BasePage {

    public PA(ApplicationManager app) {
        super(app);
    }

    public void selectExperience(String text) {
        type(By.id("input_2"), text);
        click(By.xpath("//button[@type = 'button']"));
    }

    public int getQuestionsGount() {
        List<WebElement> questions = wd.findElements(By.xpath("//div/*[@question = 'node']"));
        return questions.size();
    }

    public String getExperienceName() {
        return wd.findElement(By.xpath("//h2[@class = 'ng-binding']")).getText();
    }

    public void answerOnRatingQuestion(String question, int answer) {
        wd.findElement(By.xpath("//*[.='" + question + "']/../div/md-card[" + answer + "]")).click();
    }

    public void continueExperience() {
        click(By.xpath("//button[@aria-label= 'Continue']"));
    }

    public String getSummaryText() {
        return wd.findElement(By.xpath("//div[@class= 'evaluation-results']/p")).getText();
    }

    /**
     * drag and drop element with the text = answer to position = targetElement
     * @param targetElement
     * @param answer
     */
    public void putItemOnPosition(int targetElement, String answer) {
        int i = getCurrentAllocation(answer);

        WebElement element = wd.findElement(By.xpath("//div[@class = 'ranked-question']/div[2]/div[" + i + "]"));

        WebElement target = wd.findElement(By.xpath("//div[@class = 'ranked-question']/div[2]/div[" + targetElement + "]"));

        (new Actions(wd)).dragAndDrop(element, target).perform();
    }

    /**
     * find the index number of the answer with  text = answersText for node with type = ranked_question
     * @param answersText
     * @return index of position of elements with the
     */
    private int getCurrentAllocation(String answersText) {
        List<WebElement> answers = wd.findElements(By.xpath("//div[@class = 'ranked-question']/div[2]/div"));
        int index =0;
        for (int i=1; i <= answers.size(); i++) {

            String textOfAnswer = wd.findElement(By.xpath("//div[@class = 'ranked-question']/div[2]/div[" + i + "]")).getText();
            if (textOfAnswer.equals(answersText)) {
                index =  i;
                break;
            }
        }
        return index;
    }

    public String getTextOfAnswerOnPosition(int index){
        String text = "";
        try {
            text = wd.findElement(By.xpath("//div[@class = 'ranked-question']/div[2]/div[" + index + "]")).getText();

        } catch (StaleElementReferenceException ex) {
            System.out.println("hello");
            text = wd.findElement(By.xpath("//div[@class = 'ranked-question']/div[2]/div[" + index + "]")).getText();
        }
        return text;

    }

    public void select(String nodeName, String Name) {
        click(By.xpath("//*[@class= 'list-select-question']/*[ .= '"+nodeName+"']/following-sibling::div//div[.='"+Name+"']"));
    }
}
