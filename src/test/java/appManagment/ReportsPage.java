package appManagment;

import Data.ExperienceType;
import org.openqa.selenium.By;

/**
 * Created by orozumniuk on 7/1/2016.
 */
public class ReportsPage extends BasePage {

    public ReportsPage(ApplicationManager app) {
        super(app);
    }

    public void selectExperienceGroup(ExperienceType experienceType){
           click(By.xpath("//span[.= '"+experienceType.value()+"']"));

    }


}
