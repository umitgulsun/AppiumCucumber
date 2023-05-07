package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.time.Duration;


public class HesapPage {

    public HesapPage()  {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(15)), this);
    }

   @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"No formula\"]")
   public MobileElement son;

   @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
   public MobileElement sonuc;
   @AndroidFindBy(id = "com.google.android.calculator:id/formula")
   public MobileElement sonucKutusu;

   @AndroidFindBy(id = "com.google.android.calculator:id/result_preview")
   public MobileElement sonucumuz;


  public MobileElement getWithText(String text) throws InterruptedException {

          return Driver.getDriver().findElementByXPath("//android.widget.ImageButton[@content-desc='"+text+"']");
  }



}
