package appManagment;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void goToPage(String url){
        wd.get(url);
    }

}
