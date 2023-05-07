package stepdefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HesapPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.net.MalformedURLException;

public class TaskStepdef {

    HesapPage hesapPage = new HesapPage();
 static String sumOfResult;
 static String sonucKutum;
 static String karekokSonuc;

    public TaskStepdef() throws MalformedURLException {
    }

    @Given("App yuklensin")
    public void appYuklensin() throws MalformedURLException {
        Driver.getDriver();
    }

    @And("{int} ve {int} sayılari toplanir")
    public void veSayılariToplanir(int arg0, int arg1) throws InterruptedException {
        Thread.sleep(5000);
        hesapPage.getWithText("2").click();
        hesapPage.getWithText("3").click();
        hesapPage.getWithText("plus").click();
        hesapPage.getWithText("9").click();
        hesapPage.getWithText("5").click();
        hesapPage.getWithText("equals").click();
    }

     @And("Cikan sonucun karekoku alinir")
     public void cikanSonucunKarekokuAlinir() throws InterruptedException {
     sumOfResult= hesapPage.sonuc.getText();
     String[] result= sumOfResult.split("");
     hesapPage.getWithText("clear").click();
     hesapPage.getWithText("square root").click();

    // Driver.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(\"switch\")");

         System.out.println("sumOfResult = " + sumOfResult);
         for (int i = 0; i < result.length; i++) {
             Thread.sleep(1000);
           hesapPage.getWithText(result[i]).click();
             System.out.println(result[i]);
         }

       Double assertsayi= Double.valueOf(hesapPage.sonucumuz.getText())*-1;
         String son=assertsayi+"";
         System.out.println(son.substring(0, 6));

     }




}
