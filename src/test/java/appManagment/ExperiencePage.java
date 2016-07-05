package appManagment;


import Data.ExperienceData;
import Data.ExperienceType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Data.ExperienceType.EVALUATION;
import static Helpers.stringHelper.generateRandomName;


/**
 * Created by orozumniuk on 6/24/2016.
 */
public class ExperiencePage extends BasePage {

    public ExperiencePage(ApplicationManager app) {
        super(app);
    }

    private void selectEvalType(String evType){
        click(By.xpath("//input[@value = '"+evType+"']"));
    }

    private void setExpType(ExperienceType experienceType) throws Exception {
        String evType;
        switch (experienceType) {
            case EVALUATION:
                evType = "Evaluation";
                selectEvalType(evType);
                break;
            case STANDART:
                evType = "Standard";
                selectEvalType(evType);
                break;
            case QUESTIONPORTAL:
                evType = "Question portal";
                selectEvalType(evType);
            default:
                throw new Exception("i don't know this");
        }
    }

    /**
     * Create Experience
     * @param exp = new ExperienceData
     * @throws Exception
     */
   public void create(ExperienceData exp) throws Exception {

       setExpType(exp.getExperienceType());

       type(By.id("experience-title"),exp.getName());
       type(By.id("experience-key"),exp.getCode());
       type(By.id("grade"), exp.getPassingGrade());

       if (exp.getEvalSummary()){
           click(By.id("evaluation-summary"));
       }
       if (exp.getProfileSelection()){
           click(By.id("profile-selection"));
       }

       if (exp.getTimer()){
           click(By.className("fa-toggle-off"));
           type(By.id("time_limit"), exp.getDuration());
       }

       if (exp.getCount_down()){
           click(By.id("countdown"));
       }

       if (exp.getLoop()){
           click(By.id("loop"));
       }
        click(By.className("btn-success"));

   }


    public int getCount() {
        return wd.findElements(By.tagName("tr")).size();
    }

    public void selectNodes(String nodeName){
        select(By.id("question-type"), nodeName);
}


    /**
     * Delete ALL exp wich finished with expName
     * @param expName
     */
    public void deleteAllExperiencesWichFinishedWith(String expName){
        List <WebElement> exp = wd.findElements(By.xpath(String.format("//tr/td/a[contains(text(), '%s')]/../../td[6]/a[@title= 'Delete experience']", expName)));
        int size = exp.size();
        for (int i= 0; i<size; i++) {
            click(By.xpath(String.format("//tr/td/a[contains(text(), '%s')]/../../td[6]/a[@title= 'Delete experience']", expName)));
            try {
                confirmAction();
            }catch (Exception NoAlertPresentException){

            }
        }
    }

    public void deleteExperience(String text){
        click(By.xpath("//td[contains(text(), 'auto_passinggrades_forallnodes')]/following-sibling::td/a[@title = 'Delete experience']"));
        confirmAction();
    }
    public void edit(){
        click(By.className("fa-pencil"));
    }

    public void checkPassingGradeForAllOptionce(){
        WebElement checkBox = wd.findElement(By.id("grade_min_for_all_options"));
        if (! checkBox .isSelected()){
            checkBox.click();
        }
    }
}








