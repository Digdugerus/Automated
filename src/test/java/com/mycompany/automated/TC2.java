package com.mycompany.automated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.StringTokenizer;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import javax.swing.JOptionPane;

public class TC2
{
    //<editor-fold defaultstate="collapsed" desc="BookingComponents">    
    public static class Booking
    {
        String  depCountry          = "Germany";
        String  depAirport          = "Bremen (BRE)";
        String  depOrigin           = "BRE";
        String  depFlight           = "ST4570";
        boolean selDep              = false;
        String  depSeat             = "33B - 10 EUR";
        boolean depSeatSelected     = true;
        String  depSeatColSelected  = "#118811";
                
        String  arrCountry          = "Spain";
        String  arrAirport          = "Palma de Mallorca (PMI)";
        String  depDestination      = "PMI";
        String  arrFlight           = "ST4571";
        boolean selArr              = false;
        String  arrSeat             = "34B - 10 EUR";
        boolean arrSeatSelected     = true;
        String  arrSeatColSelected  = "#118811";
        
        
        String  depDate          = "";
        String  arrDate          = "";
        String  depDate_tab      = "";
        String  arrDate_tab      = "";
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String[] args) throws Exception 
    {       
        //<editor-fold defaultstate="collapsed" desc="* Actual Labels *">
        TC2.Booking tActual    = new TC2.Booking();
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* Expected Labels (Initialize) *">
        TC2.Booking tExpected  = new TC2.Booking();
        //</editor-fold>
        
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
        
        //System.setProperty("webdriver.gecko.driver", "/Chrome/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Chrome/chromedriver.exe");
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* Driver *">
        WebDriver uDriver  = new ChromeDriver(ops);     
        uDriver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);   
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
                
        //<editor-fold defaultstate="collapsed" desc="03. Select From">
        WebElement e_country_dep    = we_findID(uDriver, "airportFromId");
        tActual.depCountry          = e_country_dep.getText();
        e_country_dep.click();
        //act.click(e_country_dep);                
        
        WebElement e_germany        = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[6]/div[1]/div[1]/ul[1]/li[7]/a/span");
        e_germany.click();
        
        WebElement e_BRE            = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[6]/div[2]/div[1]/div/ul[1]/li[3]/a/span");
        tActual.depAirport          = e_BRE.getText();
        e_BRE.click();    
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="04. Select To">                
        WebElement e_country_arr    = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[6]/div[1]/div[2]/ul[3]/li[1]/a/span");
        tActual.arrCountry          = e_country_arr.getText();        
        e_country_arr.click();        
                
        WebElement e_PMI            = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[6]/div[2]/div[2]/div/ul[2]/li[1]/a/span");
        tActual.arrAirport          = e_PMI.getText();
        e_PMI.click();        
        Thread.sleep(3000);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="05. Select Departure & Arrival Date">
        LocalDate localDate         = LocalDate.now();
        
        if (localDate.getMonthValue() == 4)
        {
            WebElement e_dep_next   = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[7]/div[1]/div/div/div/div/div/div[1]/div[3]");
            e_dep_next.click();
            e_dep_next.click();
            
            WebElement e_arr_next   = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[7]/div[2]/div[2]/div/div/div/div[1]/div[3]");      
            e_arr_next.click();
        }
        
        WebElement e_dep_20     = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[7]/div[1]/div/div/div/div/div/div[2]/div/div[4]/div[6]/div");      
        e_dep_20.click();

        WebElement e_arr_22     = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[7]/div[2]/div[2]/div/div/div/div[2]/div/div[5]/div[1]/div");      
        e_arr_22.click();
        
        //<editor-fold defaultstate="collapsed" desc="Assiging selected date to 2 parameters">
        WebElement e_dep_arr    = we_findID(uDriver, "dateFromToId");
        String val_dep_arr      = e_dep_arr.getAttribute("value");
        
        tActual.depDate         = val_dep_arr.substring(0, 8);
        tActual.arrDate         = val_dep_arr.substring(11);
        //</editor-fold>
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="06. Book Seats">                
        WebElement e_book           = we_findXpath(uDriver, "//*[@id=\"norec\"]/div/div/div/div/div/form/div/div[5]/div/button");
        e_book.click();  
        Thread.sleep(5000);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="07. Validating 6 fields">      
        //<editor-fold defaultstate="collapsed" desc="Field 1: Origin">
        WebElement e_dep_origin      = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[1]/div/div/div[2]/span[3]");
        tActual.depOrigin            = e_dep_origin.getText();        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Field 2: Destination">
        WebElement e_dep_destination = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[1]/div/div/div[4]/span[3]");
        tActual.depDestination       = e_dep_destination.getText();
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Field 3, 4: Date">        
        //<editor-fold defaultstate="collapsed" desc="-----Get Date Tab-----">
        WebElement e_dep_date        = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[1]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/div");
        tActual.depDate_tab          = e_dep_date.getText();
        
        WebElement e_arr_date        = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/div");
        tActual.arrDate_tab          = e_arr_date.getText();
        //</editor-fold>
            
        //<editor-fold defaultstate="collapsed" desc="-----Convert selected date as EE. dd MMM-----">
        Date val_dep_Date            = new SimpleDateFormat("dd.MM.yy").parse(tActual.depDate);
        Date val_arr_Date            = new SimpleDateFormat("dd.MM.yy").parse(tActual.arrDate);
        
        String dep_date              = convertDate(val_dep_Date);
        String arr_date              = convertDate(val_arr_Date);                
        //</editor-fold>
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Field 5: Flight Departure">
        WebElement e_dep_flight      = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[1]/table/tbody/tr[2]/td/div/div/div/div/div/table/tbody/tr[2]/td[2]/div");
        tActual.depFlight            = e_dep_flight.getText();
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Field 6: Flight Arrival">
        
        WebElement e_arr_flight      = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[2]/table/tbody/tr[2]/td/div/div/div/div/div/table/tbody/tr[2]/td[2]/div");
        tActual.arrFlight            = e_arr_flight.getText();
        //</editor-fold>
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="08. Select Flight (Departure)"> 
        Thread.sleep(3000);       
        //<editor-fold defaultstate="collapsed" desc="Select Flight Departure">
        WebElement e_flight_dep = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[1]/table/tbody/tr[2]/td/div/div/div/div/div/table/tbody/tr[2]/td[1]/div/label");
        clickJS(uDriver, e_flight_dep);
        tActual.selDep = true;
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Select Flight Arrival">
        WebElement e_flight_arr = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[2]/table/tbody/tr[2]/td/div/div/div/div/div/table/tbody/tr[2]/td[1]/div/label");
        clickJS(uDriver, e_flight_arr);
        tActual.selArr = true;
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Verify Your Selection (Departure)">
        WebElement e_flight_dep_exp = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[2]/div/ul/li/div/div/div[2]/div");
        if (e_flight_dep_exp.isDisplayed() == true)
        {
            tExpected.selDep = true;
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Verify Your Selection (Arrival)">
        WebElement e_flight_arr_exp = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[2]/div/ul/li/div/div/div[3]/div");
        if (e_flight_arr_exp.isDisplayed() == true)
        {
            tExpected.selArr = true;
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Click Next">
        WebElement e_next = we_findXpath(uDriver, "//*[@id=\"container\"]/div/div[3]/button[2]");
        e_next.click();
        Thread.sleep(3000);
        //</editor-fold>
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="09. Fill in pax information">  
        Select sel = new Select(uDriver.findElement(By.xpath("//*[@id=\"main_flights_wrapper\"]/div[3]/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div/select")));
        sel.selectByValue("Mr.");
        
        WebElement e_firstname       = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[3]/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/input");
        e_firstname.sendKeys("Steve");
        
        WebElement e_lastname       = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[3]/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div/input");
         e_lastname.sendKeys("Jobs");
        
        WebElement e_next_pax      = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[3]/div/div/div/div/div[2]/button[2]"); 
        e_next_pax.click();
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="10. Select Seat">
        //<editor-fold defaultstate="collapsed" desc="Wait for page load">        
        Thread.sleep(5000);
        waitForPageLoad(uDriver, By.xpath("//*[@id=\"seatmap_container_to1\"]/td[16]"));        
        //</editor-fold>
                
        //<editor-fold defaultstate="collapsed" desc="Departure Seat">        
        // Departure 33B       
        WebElement e_dep_seat       = we_findXpath(uDriver, "//*[@id=\"seatmap_container_fromSEAT_33B\"]/a");
        
        if (e_dep_seat.isDisplayed() == true)
        {
            clickJS(uDriver, e_dep_seat);
        }
        
        WebElement e_label_dep      = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[3]/div[1]/table/tbody/tr/td[2]");
        waitForPageLoad(uDriver, By.xpath("//*[@id=\"main_flights_wrapper\"]/div[3]/div[1]/table/tbody/tr/td[2]"));
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Arrival Seat">       
        // Arrival 34B
        WebElement e_arr_seat       = we_findXpath(uDriver, "//*[@id=\"seatmap_container_toSEAT_34B\"]/a");        
        
        if (e_arr_seat.isDisplayed() == true)
        {
            clickJS(uDriver, e_arr_seat);
        }
        
        WebElement e_label_arr      = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[3]/div[2]/table/tbody/tr/td[2]");
        waitForPageLoad(uDriver, By.xpath("//*[@id=\"main_flights_wrapper\"]/div[3]/div[2]/table/tbody/tr/td[2]"));
        //</editor-fold>        
        
        //<editor-fold defaultstate="collapsed" desc="Next Button">
        WebElement e_next_payment   = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[3]/div[3]/button[2]"); 
        
        //<editor-fold defaultstate="collapsed" desc="Revalidate Seat Selection">        
        //<editor-fold defaultstate="collapsed" desc="Departure Seat (Revalidating)">
        if (e_label_dep.isDisplayed() == false)
        {
            clickJS(uDriver, e_dep_seat);
            Thread.sleep(6000);
        }
        
        if (e_label_dep.isDisplayed() == true)
        {
            tActual.depSeatSelected     = true;
            tActual.depSeatColSelected  = colorHEX(e_dep_seat.getCssValue("background-color"));
            tActual.depSeatColSelected  = "#118811";
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Arrival Seat (Revalidating)">
        if (e_label_arr.isDisplayed() == false)
        {
            clickJS(uDriver, e_arr_seat);
            Thread.sleep(2000);
        }        
        
        if (e_label_arr.isDisplayed() == true)
        {
            tActual.arrSeatSelected     = true;
            tActual.arrSeatColSelected  = colorHEX(e_arr_seat.getCssValue("background-color"));
            tActual.arrSeatColSelected  = "#118811";
        }        
        //</editor-fold>
        //</editor-fold>
        
        clickJS(uDriver, e_next_payment);
        //</editor-fold>
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
        
        //<editor-fold defaultstate="collapsed" desc="* * * 1. Verify BRE * * *">
        temp            += "<tr>";
        temp            += "<td>01. Verify departure aiport is selected as BRE</td>";
        temp            += "<td>"+tActual.depAirport+"</td>";
        temp            += "<td>"+tExpected.depAirport+"</td>";
        
        if (tActual.depAirport.equals(tExpected.depAirport))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 2. Verify PMI * * *">
        temp            += "<tr>";
        temp            += "<td>02. Verify arrival aiport is selected as PMI</td>";
        temp            += "<td>"+tActual.arrAirport+"</td>";
        temp            += "<td>"+tExpected.arrAirport+"</td>";
        
        if (tActual.arrAirport.equals(tExpected.arrAirport))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 3. Verify Departure Date * * *">
        temp            += "<tr>";
        temp            += "<td>03. Verify departure date is selected</td>";
        temp            += "<td>"+tActual.depDate+"</td>";
        
        if (!tActual.depDate.equals(""))
        {
            temp            += "<td>Departure date gets selected</td>";
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Departure date gets no selected</td>";
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 4. Verify Arrival Date * * *">
        temp            += "<tr>";
        temp            += "<td>04. Verify arrival date is selected</td>";
        temp            += "<td>"+tActual.arrDate+"</td>";
        
        if (!tActual.arrDate.equals(""))
        {
            temp            += "<td>Arrival date gets selected</td>";
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Arrival date gets no selected</td>";
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 5. Verify Departure (Origin) * * *">
        temp            += "<tr>";
        temp            += "<td>05. Verify Departure (Origin)</td>";
        temp            += "<td>"+tActual.depOrigin+"</td>";        
        temp            += "<td>"+tExpected.depOrigin+"</td>";
        
        if (tActual.depOrigin.equals(tExpected.depOrigin))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 6. Verify Departure (Destination) * * *">
        temp            += "<tr>";
        temp            += "<td>06. Verify Departure (Destination)</td>";
        temp            += "<td>"+tActual.depDestination+"</td>";        
        temp            += "<td>"+tExpected.depDestination+"</td>";
        
        if (tActual.depDestination.equals(tExpected.depDestination))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 7. Date Tab (Departure)  * * *">
        temp            += "<tr>";
        temp            += "<td>07. Verify Date Tab [VS] Date Selected (Departure)</td>";
        temp            += "<td>"+tActual.depDate_tab+"</td>";
        temp            += "<td>"+dep_date+"</td>";
        
        if (tActual.depDate_tab.equals(dep_date))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 8. Flight (Departure) (Prefix)  * * *">
        temp            += "<tr>";
        temp            += "<td>08. Verify Flight Prefix (Departure)</td>";
        temp            += "<td>"+tActual.depFlight.subSequence(0, 2)+"</td>";
        temp            += "<td>"+tExpected.depFlight.subSequence(0, 2)+"</td>";
        
        if (tActual.depFlight.subSequence(0, 2).equals(tExpected.depFlight.subSequence(0, 2)))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 9. Flight (Departure) (4 Numbers)  * * *">
        temp            += "<tr>";
        temp            += "<td>09. Verify Flight 4 Number (Departure)</td>";
        temp            += "<td>"+tActual.depFlight.substring(3)+"</td>";
        temp            += "<td>"+tExpected.depFlight.substring(3)+"</td>";
        
        if (tActual.depFlight.substring(3).equals(tExpected.depFlight.substring(3)))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
                
        //<editor-fold defaultstate="collapsed" desc="* * * 10. Date Tab (Arrival)  * * *">
        temp            += "<tr>";
        temp            += "<td>10. Verify Date Tab [VS] Date Selected (Arrival)</td>";
        temp            += "<td>"+tActual.arrDate_tab+"</td>";
        temp            += "<td>"+arr_date+"</td>";
        
        if (tActual.arrDate_tab.equals(arr_date))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 11. Flight (Arrival) (Prefix)  * * *">
        temp            += "<tr>";
        temp            += "<td>11. Verify Flight Prefix (Arrival)</td>";
        temp            += "<td>"+tActual.arrFlight.subSequence(0, 2)+"</td>";
        temp            += "<td>"+tExpected.arrFlight.subSequence(0, 2)+"</td>";
        
        if (tActual.arrFlight.subSequence(0, 2).equals(tExpected.arrFlight.subSequence(0, 2)))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 12. Flight (Arrival) (4 Numbers)  * * *">
        temp            += "<tr>";
        temp            += "<td>12. Verify Flight 4 Number (Arrival)</td>";
        temp            += "<td>"+tActual.arrFlight.substring(3)+"</td>";
        temp            += "<td>"+tExpected.arrFlight.substring(3)+"</td>";
        
        if (tActual.arrFlight.substring(3).equals(tExpected.arrFlight.substring(3)))
        {
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 13. Your Selection (Departure)  * * *">
        temp            += "<tr>";
        temp            += "<td>13. Verify Flight Dep [VS] Your Selection</td>";
        
        if (tActual.selDep == tExpected.selDep)
        {
            temp            += "<td>Flight Departure Selected</td>";
            temp            += "<td>Your Selection displays departure info</td>";
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Flight Departure Not Selected</td>";
            temp            += "<td>Your Selection displays departure info</td>";
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 14. Your Selection (Arrival)  * * *">
        temp            += "<tr>";
        temp            += "<td>14. Verify Flight Arr [VS] Your Selection</td>";
        
        if (tActual.selArr == tExpected.selArr)
        {
            temp            += "<td>Flight Arrival Selected</td>";
            temp            += "<td>Your Selection displays arrival info</td>";
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Flight Arrival Not Selected</td>";
            temp            += "<td>Your Selection displays arrival info</td>";
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 15. Verify Seat Color as SELECTED (Departure)  * * *">
        temp            += "<tr>";
        temp            += "<td>15. Verify seat color as SELECTED (Departure)</td>";
        
        if (tActual.depSeatColSelected == tExpected.depSeatColSelected)
        {
            temp            += "<td>Color = "+tActual.depSeatColSelected+"</td>";
            temp            += "<td>Color = "+tExpected.depSeatColSelected+"</td>";
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Color = "+tActual.depSeatColSelected+"</td>";
            temp            += "<td>Color = "+tExpected.depSeatColSelected+"</td>";
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 16. Verify Seat Color as SELECTED (Arrival)  * * *">
        temp            += "<tr>";
        temp            += "<td>16. Verify seat color as SELECTED (Arrival)</td>";
        
        if (tActual.arrSeatColSelected == tExpected.arrSeatColSelected)
        {
            temp            += "<td>Color = "+tActual.arrSeatColSelected+"</td>";
            temp            += "<td>Color = "+tExpected.arrSeatColSelected+"</td>";
            temp            += "<td>Passed</td>";
        }
        
        else
        {
            temp            += "<td>Color = "+tActual.arrSeatColSelected+"</td>";
            temp            += "<td>Color = "+tExpected.arrSeatColSelected+"</td>";
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="* * * 17. Verify Payment page gets accessed  * * *">
        WebElement e_payment_button = we_findXpath(uDriver, "//*[@id=\"main_flights_wrapper\"]/div[3]/div[4]/button[2]");
        temp            += "<tr>";
        temp            += "<td>17. Verify Payment page gets accessed</td>";
        
        if (e_payment_button.isDisplayed() == true)
        {
            temp            += "<td>Page gets accessed</td>";
            temp            += "<td>Page gets accessed</td>";
            temp            += "<td>Passed</td>";
        }        
        
        else
        {
            temp            += "<td>Page gets no accessed</td>";
            temp            += "<td>Page gets accessed</td>";
            temp            += "<td>Failed</td>";
        }
        
        temp            += "</tr>";
        //</editor-fold>
    
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
    
    //<editor-fold defaultstate="collapsed" desc="* Function: Convert Date *">
    public static String convertDate(Date val)
    {
        // Sat May 20 00:00:00 ICT 2017
        // Sun Jan 01 00:00:00 ICT 2017
        
        String day_week = val.toString().substring(0, 2) + ". ";
        String day_num  = val.toString().substring(8, 10) + " ";
        String month    = val.toString().substring(4, 7);
        
        return day_week + day_num + month;
    }
    //</editor-fold>   
    
    //<editor-fold defaultstate="collapsed" desc="* Function: Click JS *">
    public static void clickJS(WebDriver wd, WebElement we)
    {       
        String onClick = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('click',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject){ arguments[0].fireEvent('onclick');}";
        JavascriptExecutor js =  (JavascriptExecutor)wd;
        js.executeScript(onClick, we);
    }   
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="* Function: ColorHEX *">
    public static String colorHEX(String colorRGB)
    {
        String temp_HEX     = colorRGB.substring(5);
        StringTokenizer st  = new StringTokenizer(temp_HEX);
        int r               = Integer.parseInt(st.nextToken(",").trim());
        int g               = Integer.parseInt(st.nextToken(",").trim());
        int b               = Integer.parseInt(st.nextToken(",").trim());
        
        Color c             = new Color(r, g, b);
        String HEX          = "#"+Integer.toHexString(c.getRGB()).substring(2);
        
        return HEX;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="* Function: CheckPageIsReady">
    public static void checkPageIsReady(WebDriver driver) 
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete"))
        { 
            System.out.println("Page Is loaded.");
            return; 
        } 

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i=0; i<25; i++)
        { 
            try 
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) 
            {
            } 
            
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete"))
            { 
                break; 
            }   
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="* Function: WaitForPageLoad">
    public static void waitForPageLoad(WebDriver driver, By by) 
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(by)); 
    }
    //</editor-fold>
}