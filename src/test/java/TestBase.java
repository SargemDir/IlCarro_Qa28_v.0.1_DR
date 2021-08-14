import application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite(alwaysRun = true)
    public void start() {
        app.init();
    }

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("Start method -->" + m.getName());
    }

    @AfterMethod
    public void endofLogger(Method m) {
        logger.info("End of method -->" + m.getName());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
