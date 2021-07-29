import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void positiveTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","07/29/2021","07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }
    @Test
    public void negativeTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","06/26/2021","06/30/2021");

        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isDataInPath());
        Assert.assertTrue(app.search().buttonYallaInactive());
    }

    @Test
    public void selectPeriodCurrentMouth(){
        app.search().fillSearchFormCurrentMonth("Haifa","07/229/2021","07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());


    }

    @Test
    public void selectPeriodInFuture(){
        app.search().fillSearchFormInFuture("Haifa","09/26/2021","10/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }
}
