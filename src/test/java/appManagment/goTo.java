package appManagment;

import org.openqa.selenium.By;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class goTo extends BasePage {

    public goTo(ApplicationManager app) {
        super(app);
    }

    public void page(String url){
        wd.get(url);
    }

    public void newExperiencePage(){
        click(By.className("add-btn"));
    }

}

