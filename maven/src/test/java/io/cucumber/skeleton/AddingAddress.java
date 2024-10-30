package io.cucumber.skeleton;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;



public class AddingAddress {
    WebDriver driver;


    @Given("The browser is open")
    public void theBrowserIsOpen() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("User is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        {

        }

    }

    @When("User inputs mail {string}")
    public void userInputsMail(String mail) {
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys(mail);
    }

    @And("User inputs password {string}")
    public void userInputsPassword(String password) throws InterruptedException {
        WebElement element = driver.findElement(By.name("password"));
        element.sendKeys(password);
    }

    @And("User presses Sign In button")
    public void userPressesSignInButton() {
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
        //       driver.findElement(By.name("submit")).click();

    }

    @And("User presses the addresses Tab")
    public void userPressesTheAddressesTab() {
        WebElement addressesLink = driver.findElement(By.cssSelector("a[title='Addresses']"));
        addressesLink.click();

    }

    @And("user presses create new address")
    public void userPressesCreateNewAddress() {
        WebElement newAddress = driver.findElement(By.cssSelector("#content > div.addresses-footer > a > span"));
        newAddress.click();
    }

    @And("User inserts {string} as alias")
    public void userInsertsAsAlias(String alias) {
        WebElement element = driver.findElement(By.cssSelector("#field-alias"));
        element.sendKeys(alias);


    }

    @And("User inserts {string} as address")
    public void userInsertsAsAddress(String address) {
        WebElement element = driver.findElement(By.cssSelector("#field-address1"));
        element.sendKeys(address);
    }

    @And("User inserts {string} as city")
    public void userInsertsAsCity(String city) {
        WebElement element = driver.findElement(By.cssSelector("#field-city"));
        element.sendKeys(city);
    }

    @And("User inserts {string} as zip")
    public void userInsertsAsZip(String zip) {
        WebElement element = driver.findElement(By.name("postcode"));
        element.sendKeys(zip);
    }

    @And("User inserts {string} as country")
    public void userInsertsAsCountry(String country) {
        WebElement dropdown = driver.findElement(By.cssSelector("#field-id_country"));
        dropdown.click();
        WebElement countryOption = driver.findElement(By.xpath("//select[@id='field-id_country']/option[text()='" + country + "']"));
        countryOption.click();
    }

    @And("User inserts {string} as phone")
    public void userInsertsAsPhone(String phone) {
        WebElement element = driver.findElement(By.cssSelector("#field-phone"));
        element.sendKeys(phone);
    }



    @And("User presses button Save")
    public void userPressesButtonSave() {
        WebElement SaveButton = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        SaveButton.click();

    }

    @Then("Address data is correctly displayed")
    public void theAddressDataIsCorrectlyDisplayed(DataTable dataTable) {
        // Konwersja danych z tabeli Gherkin do mapy
        List<Map<String, String>> addressData = dataTable.asMaps(String.class, String.class);
        String expectedAlias = addressData.get(0).get("alias");
        String expectedAddress = addressData.get(0).get("address");
        String expectedCity = addressData.get(0).get("city");
        String expectedZip = addressData.get(0).get("zip");
        String expectedCountry = addressData.get(0).get("country");
        String expectedPhone = addressData.get(0).get("phone");

        // Pobranie aliasu z ekranu i jego porównanie
        WebElement aliasElement = driver.findElement(By.cssSelector(".address-body h4"));
        String actualAlias = aliasElement.getText();
        if (expectedAlias.equals(actualAlias)) {
            System.out.println("Alias jest zgodny: " + actualAlias);
        } else {
            System.out.println("Alias jest niezgodny! Oczekiwano: " + expectedAlias + ", otrzymano: " + actualAlias);
        }

        // Pobranie tekstu adresu i jego porównanie
        WebElement addressElement = driver.findElement(By.cssSelector(".address-body"));
        String addressText = addressElement.getText();

        if (addressText.contains(expectedAddress)) {
            System.out.println("Adres jest zgodny: " + expectedAddress);
        } else {
            System.out.println("Adres jest niezgodny! Oczekiwano: " + expectedAddress);
        }

        if (addressText.contains(expectedCity)) {
            System.out.println("Miasto jest zgodne: " + expectedCity);
        } else {
            System.out.println("Miasto jest niezgodne! Oczekiwano: " + expectedCity);
        }

        if (addressText.contains(expectedZip)) {
            System.out.println("Kod pocztowy jest zgodny: " + expectedZip);
        } else {
            System.out.println("Kod pocztowy jest niezgodny! Oczekiwano: " + expectedZip);
        }

        if (addressText.contains(expectedCountry)) {
            System.out.println("Kraj jest zgodny: " + expectedCountry);
        } else {
            System.out.println("Kraj jest niezgodny! Oczekiwano: " + expectedCountry);
        }

        if (addressText.contains(expectedPhone)) {
            System.out.println("Telefon jest zgodny: " + expectedPhone);
        } else {
            System.out.println("Telefon jest niezgodny! Oczekiwano: " + expectedPhone);

            driver.quit();
        }
    }
}





















