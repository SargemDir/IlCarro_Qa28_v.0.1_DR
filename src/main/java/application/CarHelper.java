package application;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CarHelper extends HelperBase {
    public CarHelper(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        if (isCarFormPresent()) {
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());

            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());

            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());

            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber());
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceIncluded());
            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"), car.getAbout());

            pause(7000);

        }

    }

    private void typeLocation(String address) {
        WebElement el = wd.findElement(By.id("pickUpPlace"));
        el.click();
        el.clear();
        el.sendKeys(address);
        pause(2000);
        wd.findElement(By.xpath("//div[@class='pac-item']")).click();
        pause(2000);
    }

    private boolean isCarFormPresent() {
        return wd.findElements(By.xpath("//h1[contains(.,'Let the car work')]")).size() > 0;
    }

    public void attachPhoto() {
        wd.findElement(By.id("photos"))
                .sendKeys("C:/Users/User/Downloads/IT/QA_manual/projects/IlCarro_Qa28_v.0.1_DR/src/bmw.jpeg");
    }

    public void login() {
        click(By.xpath("//a[.=' Log in ']"));
        type(By.id("email"), "krolya@gmail.com");
        type(By.id("password"), "Qq12345$");
        click(By.xpath("//*[@type='submit']"));
        pause(3000);
        click(By.xpath("//button[.='Ok']"));
    }
}
