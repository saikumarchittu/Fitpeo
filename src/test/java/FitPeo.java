

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FitPeo {

	@Test
    public void task_Test() throws Exception
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://fitpeo.com/home");
        driver.findElement(By.xpath("//a[@href='/revenue-calculator']")).click();
        
        WebElement Ele = driver.findElement(By.xpath("//span[.='Patients should be between 0 to 2000']"));
        
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,200);");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(Ele));
        
        WebElement Slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']"));
        
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.dragAndDropBy(Slider, 94,0).perform();
        
        for(int i=1;i<=3;i++)
        {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_LEFT);
            r.keyRelease(KeyEvent.VK_LEFT);
        }
        
        Thread.sleep(2000);
        WebElement ValueFeild = driver.findElement(By.xpath("//input[contains(@class,'MuiInp')]"));
        
        ValueFeild.click();
        
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_A);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_A);
        ValueFeild.sendKeys("560");
        
        String Value = ValueFeild.getText();
        
        if(Value.contains("560"))
        {
            System.out.println(Value);
        }
        
        ValueFeild.click();
        
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_A);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_A);
        ValueFeild.sendKeys("820");
        
        driver.findElement(By.xpath("//p[.='CPT-99091']/..//input[@type='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[.='CPT-99453']/..//input[@type='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[.='CPT-99454']/..//input[@type='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[.='CPT-99474']/..//input[@type='checkbox']")).click();
        Thread.sleep(2000);
        
        String Total = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:']/p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c']")).getText();
        
        System.out.println("Total Recurring Reimbursement for all Patients Per Month: "+Total);
        
                
        Thread.sleep(3000);
        driver.close();
        
        
    }
}
