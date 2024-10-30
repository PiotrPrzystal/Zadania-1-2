import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Sweater {
    WebDriver driver;

    @Given("Przegladarka jest otwarta")
    public void przegladarkaJestOtwarta() {
            System.setProperty("webdriver.chrome.driver", "C:\\Windows\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }


    @And("Uzytkownik jest na stronie logowania")
    public void uzytkownikJestNaStronieLogowania() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("Uzytkownik wpisuje mail {string}")
    public void uzytkownikWpisujeMail(String mail) {
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys(mail);
    }


    @And("Uzytkownik wpisuje password {string}")
    public void uzytkownikWpisujePassword(String password) {
        WebElement element = driver.findElement(By.name("password"));
        element.sendKeys(password);
    }

    @And("Uzytkownik naciska przycisk Sign In")
    public void uzytkownikNaciskaPrzyciskSignIn() {
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @And("Uzytkownik wraca na strone glowna")
    public void uzytkownikWracaNaStroneGlowna() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?");

    }

    @And("Uzytkownik wybierze Hummingbird Printed Sweater")
    public void uzytkownikWybierzeHummingbirdPrintedSweater() {
        WebElement PrintedSweater = driver.findElement(By.cssSelector("#content > section > div > div:nth-child(2) > article > div > div.thumbnail-top > a > img"));
        PrintedSweater.click();
    }


    @And("Uzytkownik wybierze rozmiar {string}")
    public void uzytkownikWybierzeRozmiar(String rozmiar) {
        Select uzytkownikWybierzeRozmiarM = new Select(driver.findElement(By.id("group_1")));
        uzytkownikWybierzeRozmiarM.selectByVisibleText(rozmiar);
    }

    @And("Uzytkownik wybierze ilosc {string}")
    public void uzytkownikWybierzeIlosc(String ilosc) throws InterruptedException {
        WebElement quantityInput = driver.findElement(By.cssSelector("#quantity_wanted"));
        quantityInput.click();
        Thread.sleep(2000);
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(ilosc);


    }


    @And("Uzytkownik doda produkt do koszyka")
    public void uzytkownikDodaProduktDoKoszyka() throws InterruptedException {
        driver.findElement(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart.js-product-add-to-cart > div > div.add > button")).click();
        Thread.sleep(2000);
    }

    @And("Uzytkownik nacisnie Proceed to checkout")
    public void uzytkownikNacisnieProceedToCheckout() throws InterruptedException {
        driver.findElement(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")).click();
        Thread.sleep(2000);

    }

    @And("Uzytkownik zrobi to ponownie")
    public void uzytkownikZrobiToPonownie() throws InterruptedException {
        driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.js-cart-detailed-actions.card-block > div > a")).click();
        Thread.sleep(2000);

    }

    @And("Uzytkowink potwierdza adres")
    public void uzytkowinkPotwierdzaAdres() {
        driver.findElement(By.cssSelector("#checkout-addresses-step > div > div > form > div.clearfix > button")).click();
    }

    @And("Uzytkownik wybierze metode odbioru Pick up in store")
    public void uzytkownikWybierzeMetodeOdbioruPickUpInStore() throws InterruptedException {
        driver.findElement(By.cssSelector("#js-delivery > div > div.delivery-options > div:nth-child(1) > div > span > span")).click();
    }

    @And("Uzytkownik nacisnie przycisk continue")
    public void uzytkownikNacisniePrzyciskContinue() {
        driver.findElement(By.cssSelector("#js-delivery > button")).click();

    }

    @And("Uzytkownik wybierze Pay By Check")
    public void uzytkownikWybierzePayByCheck() {
        driver.findElement(By.cssSelector("#payment-option-1")).click();
    }

    @And("Uzytkownik zaakceptuje Terms of service")
    public void uzytkownikZaakceptujeTermsOfService() {
        driver.findElement(By.name("conditions_to_approve[terms-and-conditions]")).click();
    }

    @And("Uzytkownik nacisnie Place Order")
    public void uzytkownikNacisniePlaceOrder() {
        driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button")).click();
    }

    @Then("Widze potwierdzenie zamowienia i kwote")
    public void widzePotwierdzenieZamowieniaIKwote() throws IOException {
        // Tworzenie zrzutu ekranu jako pliku tymczasowego
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Wczytywanie obrazu do BufferedImage
        BufferedImage bufferedImage = ImageIO.read(screenshot);

        // Zapisywanie zrzutu jako plik .jpg
        File destination = new File("C:\\Coders Lab\\potwierdzenie.jpg");
        ImageIO.write(bufferedImage, "jpg", destination);

        driver.quit();
    }
}




