package web.pages;

import org.openqa.selenium.support.ui.WebDriverWait;

public interface Page {
    public void tearDown();
    public void navigateTo(String url);

    public WebDriverWait getWaitDriver();


}
