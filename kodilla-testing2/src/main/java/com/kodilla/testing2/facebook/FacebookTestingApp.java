package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_COOKIES_CONSENT = "//div[contains(@data-testid, \"cookie-policy-dialog\")]//div[3]/button[2]";
    public static final String XPATH_CREATE_USER = "//form/div[5]/a";
    public static final String XPATH_GENDER = "//span[contains(@data-name, \"gender_wrapper\")]/span[2]/input";


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIES_CONSENT)).click();

        WebElement createUser = driver.findElement(By.xpath(XPATH_CREATE_USER));
        createUser.click();

        Thread.sleep(2000);
//        while (!driver.findElement(By.xpath(XPATH_FIRSTNAME)).isDisplayed());

        WebElement name = driver.findElement(By.name("firstname"));
        name.sendKeys("Jan");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Kowalski");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("jan@kowalski.com");
        Thread.sleep(500);
        WebElement emailConfirmation = driver.findElement(By.name("reg_email_confirmation__"));
        emailConfirmation.sendKeys("jan@kowalski.com");
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("qwerty123456");

        WebElement selectBirthDay = driver.findElement(By.name("birthday_day"));
        Select selectDay = new Select(selectBirthDay);
        selectDay.selectByIndex(20);

        WebElement selectBirthMonth = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(selectBirthMonth);
        selectMonth.selectByIndex(1);

        WebElement selectBirthYear = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(selectBirthYear);
        selectYear.selectByValue("1985");

        WebElement gender = driver.findElement(By.xpath(XPATH_GENDER));
        gender.click();

        WebElement submit = driver.findElement(By.name("websubmit"));
        submit.click();








    }
}
