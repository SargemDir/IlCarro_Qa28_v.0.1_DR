package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class SearchHelper extends HelperBase {
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void typeSearchCurrentMonth(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        typeInputPeriod(dataFrom, dataTo);
    }

    private void typeInputPeriod(String dataFrom, String dataTo) {
        type(By.id("dates"), dataFrom + " - " + dataTo);
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String screenshot = "src/test/screenshots/scren-" + i + ".png";
        takeScreenshot(screenshot);
        click(By.cssSelector("div.cdk-overlay-container"));

    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        pause(500);
        click(By.xpath("//div[@class='pac-item']"));

    }

    public boolean isListOfCarAppeared() {
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public boolean isDataInPath() {
        WebElement warning = wd.findElement(By.xpath("//div[@class='ng-star-inserted']"));
        String warningTxt = warning.getText();

        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(warning, warningTxt));
        return warningTxt.contains("before today");
    }

    public boolean buttonYallaInactive() {
        WebElement yallaBtn = wd.findElement(By.xpath("//button[@type='submit']"));
        return !yallaBtn.isEnabled();
    }

    public void fillSearchFormCurrentMonth(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dataFrom, dataTo);
    }

    private void selectPeriodCurrentMonth(String dataFrom, String dataTo) {
        //07/26/2021      07/30/2021
        click(By.id("dates"));

        String[] dataF = dataFrom.split("/");
        String[] dataT = dataTo.split("/");

        //dataF[1]====26   //div[text()=' 26 ']
        // dataT[1] ====30   //div[text()=' 30 ']

        String dataLocatorFrom = String.format("//div[text()=' %s ']", dataF[1]);
        String dataLacotorTo = String.format("//div[text()=' %s ']", dataT[1]);

        click(By.xpath(dataLocatorFrom));
        click(By.xpath(dataLacotorTo));
    }

    public void fillSearchFormInFuture(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        //   09/26/2021      10/30/2021
        click(By.id("dates"));

        String[] dataF = dataFrom.split("/");
        String[] dataT = dataTo.split("/");

        int diffStart = 0;
        diffStart = Integer.parseInt(dataF[0]) - LocalDate.now().getMonthValue();

        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String dataLocatorFrom = String.format("//div[text()=' %s ']", dataF[1]);
        click(By.xpath(dataLocatorFrom));

        diffStart = Integer.parseInt(dataT[0]) - diffStart;
        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String dataLocatorTo = String.format("//div[text()=' %s ']", dataT[1]);
        click(By.xpath(dataLocatorFrom));

    }
}
