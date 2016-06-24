package appManagment;

import org.openqa.selenium.By;

public class SessionsHelper extends HelperBase{


    public SessionsHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String login, String password){
            type(By.id("input_0"),login);
            type(By.id("input_1"),password);
            click(By.xpath(".//button[@type ='submit']"));
    }

    public void loginToAdminsModule(String password){
            type(By.id("password"),password);
            click(By.name("commit"));
    }
}
