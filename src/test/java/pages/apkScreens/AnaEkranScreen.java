package pages.apkScreens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class AnaEkranScreen {
    private PreferenceScreen preferenceScreen;
    private DragDropScreen dragDropScreen;
    private MediaScreen mediaScreen;
    public AnaEkranScreen()  {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(15)), this);
    }
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    public MobileElement continueButton;

    public MediaScreen setMediaScreen(){
        if (mediaScreen == null) {
            mediaScreen=new MediaScreen();
        }
        return mediaScreen;
    }
    public PreferenceScreen setPreferenceScreen(){
        if (preferenceScreen == null) {
            preferenceScreen=new PreferenceScreen();
        }
        return preferenceScreen;
    }

    public DragDropScreen setDragDropScreen(){
        if (dragDropScreen == null) {
            dragDropScreen=new DragDropScreen();
        }
        return dragDropScreen;
    }

    public boolean isTittleView(String text){
        return Driver.getDriver().findElementByXPath("//android.widget.Button[@text='"+text+"']").isDisplayed();
    }

    public static void elementClickWithText(String text) throws InterruptedException {

        try {
            Driver.getDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
        } catch (Exception e) {
            Driver.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
            Driver.getDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
        }
    }

    public static void elementClickWithButton(String text) throws InterruptedException {
        // Thread.sleep(3000);
        Driver.getDriver().findElementByXPath("//android.widget.Button[@text='" + text + "']").click();
    }


}
