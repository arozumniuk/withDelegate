package appManagment;


import Data.ExperienceData;
import Data.ExperienceType;
import org.openqa.selenium.By;


/**
 * Created by orozumniuk on 6/24/2016.
 */
public class ExperienceHelper extends HelperBase {

    public ExperienceHelper(ApplicationManager app) {
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


    public void setUpTimer(String duration, boolean count_doun, boolean Loop) {

        click(By.className("fa-toggle-off"));
        type(By.id("time_limit"), duration);
        if (count_doun) {
            click(By.id("countdown"));
        }

        if (Loop) {
            click(By.id("loop"));
        }
    }

    public void setUpProfileSelection(boolean profileSelection) {
        if (profileSelection) {
            click(By.id("profile-selection"));
        }

    }

    public void setUpEvaluationSummary(boolean evaluationSummary) {
        if (evaluationSummary) {
            click(By.id("evaluation-summary"));
        }
    }

    public void setUpPassingGrade(String countGrade) {
        type(By.id("grade"), countGrade);
    }

   public void fillFields(ExperienceData exp){
       type(By.id("experience-title"),exp.getName());
       type(By.id("experience-key"),exp.getCode());
       type(By.id("grade"), exp.getPassingGrade());

       if (exp.getEvalSummary()){
           click(By.id("evaluation-summary"));
       }
       if (exp.getProfileSelection()){
           click(By.id("profile-selection"));
       }


   }


}








