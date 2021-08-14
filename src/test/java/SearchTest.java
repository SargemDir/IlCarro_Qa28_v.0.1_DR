import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preconditions(){
        if (app.userHelper().isLogged()) {
            app.carHelper().login();
        }
    }
    @AfterMethod(alwaysRun = true)
    public void postConditions() {
        app.search().backToHome();
    }

    @Test(groups = {"web"})
    public void positiveTestSendKey() {
        logger.info("Haifa, 08/29/2021, 08/30/2021");
        app.search().typeSearchCurrentMonth("Haifa", "08/29/2021", "08/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }

    @Test(groups = {"a","web"})
    public void negativeTestSendKey() {
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa", "06/26/2021", "06/30/2021");

        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isDataInPath());
        Assert.assertTrue(app.search().buttonYallaInactive());
    }

    @Test
    public void selectPeriodCurrentMouth() {
        app.search().fillSearchFormCurrentMonth("Haifa", "07/29/2021", "07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }

    @Test
    public void selectPeriodInFuture() {
        app.search().fillSearchFormInFuture("Haifa", "07/29/2021", "07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(3000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }

}
