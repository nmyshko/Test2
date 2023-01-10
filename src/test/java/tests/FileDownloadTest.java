package tests;
import baseEntities.BaseTest;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownload() throws Exception {
        String fileDownloadPath = System.getProperty("user.dir");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", fileDownloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);


        driver.get("https://thelib.ru/books/mitchell_margaret/unesennye_vetrom.html");

        driver.findElement(By.xpath("//*/a[text()=\"Скачать в формате FB2\"]")).click();

        Thread.sleep(5000);

        File downloadedFile = new File(fileDownloadPath + File.separator + "Митчелл Маргарет. Унесенные ветром - TheLib.Ru.fb2.zip");
        Assert.assertTrue(downloadedFile.exists());

        driver.quit();
    }
}