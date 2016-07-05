package Tests;

import appManagment.ApplicationManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by orozumniuk on 6/24/2016.
 */
public class TestBase {


        public final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

        @Before
        public void setUp() throws Exception {
            app.init();
        }

        @After
        public void tearDown() {
            app.stop();
        }

    }

