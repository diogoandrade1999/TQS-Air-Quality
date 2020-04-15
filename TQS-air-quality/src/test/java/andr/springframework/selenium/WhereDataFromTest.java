// Generated by Selenium IDE
package andr.springframework.selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WhereDataFromTest {

  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void whereDataFrom() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("search")).sendKeys("lisboa");
    driver.findElement(By.id("btn_search")).click();
    driver.findElement(By.linkText("lisboa, Laranjeiro, Almada, Portugal")).click();
    assertThat(driver.findElement(By.id("data_from")).getText(), is("Data From API! -> This data already in repository!"));
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("search")).sendKeys("lisboa");
    driver.findElement(By.id("btn_search")).click();
    driver.findElement(By.linkText("lisboa, Laranjeiro, Almada, Portugal")).click();
    assertThat(driver.findElement(By.id("data_from")).getText(), is("Data From Repository!"));
    driver.close();
  }
}
