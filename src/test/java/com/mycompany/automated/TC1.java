
package com.mycompany.automated;

import static com.mycompany.automated.TC2.we_findID;
import static com.mycompany.automated.TC2.we_findXpath;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;

import javax.swing.JOptionPane;

public class TC1 
{
    //<editor-fold defaultstate="collapsed" desc="LabelsDescription">
    public static class LabelDescription
    {
        String lblBooking       = "Booking";
        String lblPlanning      = "Planning";
        String lblFlying        = "Flying";
        String lblTravelGuide   = "Travel guide";
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String[] args) throws InterruptedException 
    {       
        //<editor-fold defaultstate="collapsed" desc="* Chrome Options *"> 
        ChromeOptions ops   = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        ops.addArguments("--start-maximized");
        ops.addArguments("--disable-web-security");
        ops.addArguments("--no-proxy-server");
        
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        ops.setExperimentalOption("prefs", prefs);
        
        System.setProperty("webdriver.chrome.driver", "/Chrome/chromedriver.exe");
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* Driver *">
        WebDriver uDriver  = new ChromeDriver(ops);     
        uDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES); 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="01. Open Site">
        uDriver.get("https://ecom-gmi.worldticket.net/#/?_k=u0c3uk");
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="02. Change site language">
        WebElement e_ddl_language   = we_findID(uDriver, "ddList-js-language__list");        
        e_ddl_language.click();
        Thread.sleep(2000);
        
        WebElement e_ddl_en         = we_findXpath(uDriver, "//*[@id=\"language-sw\"]/ul/li[2]/a");
        e_ddl_en.click();       
        
        Thread.sleep(6000);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="03. Actual Labels">
        LabelDescription tActual    = new LabelDescription();
        tActual.lblBooking          = uDriver.findElement(By.xpath("//*[@id=\"top\"]/div[1]/div/div/div[2]/div/div/div/div[6]/nav/ul/li[1]/a/span")).getText();
        tActual.lblPlanning         = uDriver.findElement(By.xpath("//*[@id=\"top\"]/div[1]/div/div/div[2]/div/div/div/div[6]/nav/ul/li[2]/a/span")).getText();
        tActual.lblFlying           = uDriver.findElement(By.xpath("//*[@id=\"top\"]/div[1]/div/div/div[2]/div/div/div/div[6]/nav/ul/li[3]/a/span")).getText();
        tActual.lblTravelGuide      = uDriver.findElement(By.xpath("//*[@id=\"top\"]/div[1]/div/div/div[2]/div/div/div/div[6]/nav/ul/li[4]/a/span")).getText();       
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="04. Expected Labels (Initialize)">
        LabelDescription tExpected  = new LabelDescription();
        //</editor-fold>
        
        
        //<editor-fold defaultstate="collapsed" desc="* * * Dispaly Result * * *">
        String temp      = "<html><table>";
        temp            += "<table border=1 BORDERCOLORLIGHT=YELLOW BORDERCOLORDARK=BLUE>";
        temp            += "<div width='200px' align='left'>";

        temp            += "<tr>";
        temp            += "<td>Description</td>";
        temp            += "<td>Actual</td>";
        temp            += "<td>Expected</td>";
        temp            += "<td>Result</td>";
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 1. Booking * * *">
        temp            += "<tr>";
        temp            += "<td>1. Display label EN as 'Booking'</td>";
        temp            += "<td>"+tActual.lblBooking+"</td>";
        temp            += "<td>"+tExpected.lblBooking+"</td>";
        
        if (tActual.lblBooking.equals(tExpected.lblBooking))
        {
            temp            += "<td>Passed</td>";
            System.out.println("01 - Booking : Passed");
        }
        
        else
        {
            temp            += "<td>Failed</td>";
            System.out.println("01 - Booking : Failed");
        }
        
        temp            += "</tr>";
        //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc="* * * 2. Planning * * *">
        temp            += "<tr>";
        temp            += "<td>2. Display label EN as 'Planning'</td>";
        temp            += "<td>"+tActual.lblPlanning+"</td>";
        temp            += "<td>"+tExpected.lblPlanning+"</td>";
        
        if (tActual.lblPlanning.equals(tExpected.lblPlanning))
        {
            temp            += "<td>Passed</td>";
            System.out.println("02 - Planning : Passed");
        }
        
        else
        {
            temp            += "<td>Failed</td>";
            System.out.println("02 - Planning : Failed");
        }
        
        temp            += "</tr>";
        //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc="* * * 3. Flying * * *">
        temp            += "<tr>";
        temp            += "<td>3. Display label EN as 'Flying'</td>";
        temp            += "<td>"+tActual.lblFlying+"</td>";
        temp            += "<td>"+tExpected.lblFlying+"</td>";
        
        if (tActual.lblFlying.equals(tExpected.lblFlying))
        {
            temp            += "<td>Passed</td>";
            System.out.println("03 - Flying : Passed");
        }
        
        else
        {
            temp            += "<td>Failed</td>";
            System.out.println("03 - Flying : Failed");
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 4. Travel guide * * *">
        temp            += "<tr>";
        temp            += "<td>4. Display label EN as 'Travel guide'</td>";
        temp            += "<td>"+tActual.lblTravelGuide+"</td>";
        temp            += "<td>"+tExpected.lblTravelGuide+"</td>";
        
        if (tActual.lblTravelGuide.equals(tExpected.lblTravelGuide))
        {
            temp            += "<td>Passed</td>";
            System.out.println("04 - Travel guide : Passed");
        }
        
        else
        {
            temp            += "<td>Failed</td>";
            System.out.println("04 - Travel gude : Failed");
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        Thread.sleep(3000);
        JOptionPane.showMessageDialog(null, temp, "Testing Result", JOptionPane.CLOSED_OPTION);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="* Function: SelectValue *">
    public static void selectValue(WebElement list, final String value) {
        List<WebElement> options = list.findElements(By.tagName("li"));

        for (WebElement option : options) {
            if (option.getText().contains(value)) { //Here you have select contains or some thing 
                option.click();
                break;
            }
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="* Function: Finding Webelement *">
    //<editor-fold defaultstate="collapsed" desc="01. Webelement (Find ID)">
    public static WebElement we_findID(WebDriver wd, String val)
    {
        WebElement we = wd.findElement(By.id(val));
        return we;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="02. Webelement (Find xPath)">
    public static WebElement we_findXpath(WebDriver wd, String val)
    {
        WebElement we = wd.findElement(By.xpath(val));
        return we;
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="03. Webelement (Find CSS)">
    public static WebElement we_findClass(WebDriver wd, String val)
    {
        WebElement we = wd.findElement(By.className(val));
        return we;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="04. Webelement (Find CSSSelector)">
    public static WebElement we_findCSSSelector(WebDriver wd, String val)
    {
        WebElement we = wd.findElement(By.cssSelector(val));
        return we;
    }
    //</editor-fold>
    //</editor-fold>
}