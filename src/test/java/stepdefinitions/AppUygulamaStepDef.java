package stepdefinitions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.apkScreens.AnaEkranScreen;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class AppUygulamaStepDef {
    AnaEkranScreen anaEkranScreen = new AnaEkranScreen();


    @And("{string} butonuna tiklar")
    public void butonunaTiklar(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        Driver.elementClickWithText(arg0);
        // Driver.getDriver().findElementByXPath("//android.widget.TextView[@text='Views']").click();
    }

    @And("{string} textine tiklar")
    public void textineTiklar(String arg0) throws InterruptedException {
        Driver.elementClickWithText2(arg0);
    }

    @And("{string} gornunene kadar yatay surukle ve tikla")
    public void gornuneneKadarYataySurukleVeTikla(String arg0) throws InterruptedException {
        Driver.withTextRightScroll(arg0);
    }

    @And("{string} ekraninda")
    public void ekraninda(String arg0) {
        Assert.assertTrue(anaEkranScreen.isTittleView("9. Switch"));
    }

    @And("checkboxPreference kutusuna tiklar")
    public void checkboxpreferenceKutusunaTiklar() {
        anaEkranScreen.setPreferenceScreen().checkbox.click();
    }

    @And("Ekranda switch{int} kapali")
    public void ekrandaSwitchKapali(int arg0) {
        if (anaEkranScreen.setPreferenceScreen().switch1.getAttribute("checked").equals("false")) {
            anaEkranScreen.setPreferenceScreen().switch1.click();

        }
    }

    @And("Ekranda switch{int} acik")
    public void ekrandaSwitchAcik(int arg0) {
        if (anaEkranScreen.setPreferenceScreen().switch1.getAttribute("checked").equals("false")) {
            anaEkranScreen.setPreferenceScreen().switch1.click();
        }
    }


    @And("birinci topa basılı tutar ikinci top gorununce ona surukler")
    public void birinciTopaBasılıTutarIkinciTopGorununceOnaSurukler() throws InterruptedException {
        TouchAction touchAction = new TouchAction(Driver.getDriver());
        touchAction.longPress(ElementOption.element(anaEkranScreen.setDragDropScreen().ball_1))
                .moveTo(ElementOption.element(anaEkranScreen.setDragDropScreen().ball_3))
                .release()
                .perform();
    }

    @And("Play video mesajina tiklar")
    public void playVideoMesajinaTiklar() {
        anaEkranScreen.setMediaScreen().MesajLink.click();
        List<MobileElement> popupsayfa = anaEkranScreen.setMediaScreen().sayfa;
        System.out.println("popupsayfa.size() = " + popupsayfa.size());

        String toast = Driver.getDriver().findElement(By.xpath("//android.widget.Toast[1]")).getText();
        System.out.println("toast = " + toast);
    }


    @And("sayfada webwiev textinin goruldugu dogrulanir")
    public void sayfadaWebwievTextininGorulduguDogrulanir() {
        System.out.println("Driver.getDriver().getContextHandles() = " + Driver.getDriver().getContextHandles());
    }
}
