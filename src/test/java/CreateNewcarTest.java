import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewcarTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.userHelper().isLogged()) {
            app.carHelper().login();
        }
    }

    @Test
    public void createNewCar() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println(i);
        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.0")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("12-" + i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("very good car")
                .build();
        System.out.println("Car Num --->" + car.getCarRegNumber());
        app.carHelper().openCarForm();
        app.carHelper().fillCarForm(car);
        app.carHelper().attachPhoto();
        app.carHelper().waitUntilClickable(By.xpath("//button[.='Submit']"));
        app.carHelper().click(By.xpath("//button[.='Submit']"));
        app.carHelper().waitUntilClickable(By.xpath("//*[.='Car added']"));

        Assert.assertEquals(app.carHelper().getText(By.xpath("//*[.='Car added']")),"Car added");
    }
    @AfterMethod(alwaysRun = true)
    public void postconditions(){
        app.carHelper().click(By.xpath("//*[.='Search cars']"));
    }
}
