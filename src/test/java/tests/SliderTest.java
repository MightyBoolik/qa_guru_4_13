package tests;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class SliderTest {

    public void slider() {
        WebElement slider = $(".Slider__SliderBox-credit-calculator__dxxjdy-2");
        int width = slider.getSize().getWidth();
        actions().dragAndDropBy(slider, ((width * 250) / 15000), 0).build().perform();
        System.out.println("Slider moved");
    }
}
