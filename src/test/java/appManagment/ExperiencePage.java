package appManagment;


import Data.ExperienceData;
import Data.ExperienceType;
import org.openqa.selenium.By;


/**
 * Created by orozumniuk on 6/24/2016.
 */
public class ExperiencePage extends BasePage {

    public ExperiencePage(ApplicationManager app) {
        super(app);
    }

    public void setExpType(ExperienceType experienceType) throws Exception {

        switch (experienceType) {
            case EVALUATION:
                click(By.xpath("//input[@value = 'Evaluation']"));
                break;
            case STANDART:
                click(By.xpath("//input[@value = 'Standard']"));
            case QUESTION_PORTAL:
                click(By.xpath("//input[@value = 'Question portal']"));
            default:
                throw new Exception("i don't know this");
        }
    }


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

      //  click(By.className("btn-success"));
   }

    public int getCount() {
        return wd.findElements(By.tagName("tr")).size();
    }

    public void selectNodes(String nodeName){
        select(By.id("question-type"), nodeName);
}

}








