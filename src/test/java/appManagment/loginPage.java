package appManagment;

import org.openqa.selenium.By;

public class loginPage extends BasePage {


    public loginPage(ApplicationManager app) {
        super(app);
    }

    public void login(String login, String password){
            type(By.id("input_0"),login);
            type(By.id("input_1"),password);
            click(By.xpath(".//button[@type ='submit']"));
    }

    public void toAdminsModule(String password){
            type(By.id("password"),password);
            click(By.name("commit"));
    }
}
