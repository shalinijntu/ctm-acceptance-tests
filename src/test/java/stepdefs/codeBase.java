package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class codeBase {

    @Before
    public static void getDriver() {
        File chromeDriver = new File("/home/shalini/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        driver = new ChromeDriver();

        //driver = new FirefoxDriver();
    }

    @After
    public static void closeDriver() {
        driver.close();
    }
    public static WebDriver driver;

    @Given("^I launch compare the market home page$")
    public void i_launch_compare_the_market_home_page()  {
        driver.get("https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TST");
        driver.manage().window().maximize();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TST"));
    }
    @Then("^I see page title is (.*)$")
    public void i_see_page_title(String pagetitle) {
        Assert.assertTrue(driver.getTitle().contains(pagetitle));
    }
    @When("^I enter valid postcode (.*) and click on Find postcode$")
    public void i_enter_valid_postcode_PE_YS(String postcode) {
        driver.findElement(By.id("your-postcode")).sendKeys(postcode);
        driver.findElement(By.id("find-postcode")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("change-postcode")));
    }

    @When("^I click Yes to (.*)$")
    public void i_click_Yes_to_question(String question){
        switch (question) {
            case "Do you have your bill handy":driver.findElement(By.id("have-bill-label")).click();
                break;
            case "Do you have an Economy 7 meter":driver.findElement(By.xpath(".//*[@id='economy-7-question']/div/div/label[1]/span")).click();
                break;
            case "Is electricity your main source of heating":driver.findElement(By.xpath(".//*[@id='electricity-main-heating-source-question']/div/div/label[1]/span")).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid bill type");
        }
        }

    @When("^I click No to (.*)$")
    public void i_click_No_to_question(String question){
        switch (question) {
            case "Do you have your bill handy":driver.findElement(By.id("no-bill-label")).click();
                break;
            case "Do you have an Economy 7 meter":driver.findElement(By.xpath(".//*[@id='economy-7-question']/div/div/label[2]/span")).click();
                break;
            case "Is electricity your main source of heating":driver.findElement(By.xpath(".//*[@id='electricity-main-heating-source-question']/div/div/label[2]/span")).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid bill type");
        }
    }

    @When("^I click (.*) for What do you want to compare$")
    public void i_click_Electricity_for_What_do_you_want_to_compare(String usageType) {
        switch (usageType) {
            case "Electricity":driver.findElement(By.id("compare-electricity-label")).click();
                break;
            case "Gas":driver.findElement(By.id("compare-gas-label")).click();
                break;
            case "GasAndElectricity":driver.findElement(By.id("compare-both-label")).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid bill type");
        }
    }
    @When("^I select current supplier (.*) for electricity$")
    public void i_select_current_supplier_electricity(String SupName) {
        switch (SupName) {
            case "British Gas":driver.findElement(By.xpath(".//*[@id='elec-energy-suppliers-question']/div/div/div[1]/label[1]")).click();
                break;
            case "EDF Energy" :driver.findElement(By.xpath(".//*[@id='elec-energy-suppliers-question']/div/div/div[1]/label[2]")).click();
                break;
            case "E.ON" :driver.findElement(By.xpath(".//*[@id='elec-energy-suppliers-question']/div/div/div[1]/label[3]")).click();
                break;
            case "npower" :driver.findElement(By.xpath(".//*[@id='elec-energy-suppliers-question']/div/div/div[1]/label[4]")).click();
                break;
            case "Scottish Power" :driver.findElement(By.xpath(".//*[@id='elec-energy-suppliers-question']/div/div/div[1]/label[5]")).click();
                break;
            case "SSE" :driver.findElement(By.xpath(".//*[@id='elec-energy-suppliers-question']/div/div/div[1]/label[6]")).click();
                break;
            default:new Select(driver.findElement(By.xpath(".//*[@id='sel_chosen']/a"))).selectByVisibleText(SupName);
        }
    }
    @When("^I select current supplier (.*) for gas$")
    public void i_select_current_supplier_gas(String SupName) {
        switch (SupName) {
            case "British Gas":driver.findElement(By.xpath(".//*[@id='gas-energy-suppliers-question']/div/div/div[1]/label[1]")).click();
                break;
            case "EDF Energy" :driver.findElement(By.xpath(".//*[@id='gas-energy-suppliers-question']/div/div/div[1]/label[2]")).click();
                break;
            case "E.ON" :driver.findElement(By.xpath(".//*[@id='gas-energy-suppliers-question']/div/div/div[1]/label[3]")).click();
                break;
            case "npower" :driver.findElement(By.xpath(".//*[@id='gas-energy-suppliers-question']/div/div/div[1]/label[4]")).click();
                break;
            case "Scottish Power" :driver.findElement(By.xpath(".//*[@id='gas-energy-suppliers-question']/div/div/div[1]/label[5]")).click();
                break;
            case "SSE" :driver.findElement(By.xpath(".//*[@id='gas-energy-suppliers-question']/div/div/div[1]/label[6]")).click();
                break;
            default:new Select(driver.findElement(By.xpath(".//*[@id='sel_chosen']/a"))).selectByVisibleText(SupName);
        }
    }

    @When("^I select current supplier (.*) for both$")
    public void i_select_current_supplier_both(String SupName) {
        switch (SupName) {
            case "British Gas":driver.findElement(By.xpath(".//*[@id='dual-energy-suppliers-question']/div/div/label[1]")).click();
                break;
            case "EDF Energy" :driver.findElement(By.xpath(".//*[@id='dual-energy-suppliers-question']/div/div/label[2]")).click();
                break;
            case "E.ON" :driver.findElement(By.xpath(".//*[@id='dual-energy-suppliers-question']/div/div/label[3]")).click();
                break;
            case "npower" :driver.findElement(By.xpath(".//*[@id='dual-energy-suppliers-question']/div/div/label[4]")).click();
                break;
            case "Scottish Power" :driver.findElement(By.xpath(".//*[@id='dual-energy-suppliers-question']/div/div/label[5]")).click();
                break;
            case "SSE" :driver.findElement(By.xpath(".//*[@id='dual-energy-suppliers-question']/div/div/label[6]")).click();
                break;
            default:new Select(driver.findElement(By.xpath(".//*[@id='sel_chosen']/a"))).selectByVisibleText(SupName);
        }
    }

    @When("^I select other supplier (.*)$")
    public void i_select_other_supplier(String SupName) {
        driver.findElement(By.xpath(".//*[@id='sel_chosen']/a/div/b")).click();
        driver.findElement(By.xpath(".//*[@data-option-array-index=\""+SupName+"\"]")).click();
    }

    @When("^I click I don’t know for Who supplies your gas$")
    public void i_dont_know_supplier() {
        driver.findElement(By.xpath(".//*[@id='gas-energy-suppliers-question']/div/div/div[2]/label/span")).click();
    }

    @When("^I click next button on (.*)$")
    public void i_click_on_next_button(String page) {
        switch (page) {
            case "supplier details page":driver.findElement(By.id("goto-your-supplier-details")).click();
                break;
            case "energy details page":driver.findElement(By.id("goto-your-energy")).click();
                break;
            case "GasAndElectricity" :driver.findElement(By.id("'compare-both-label")).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid bill type");
        }
    }

    @Then("^I will be presented with the energy details page$")
    public void i_will_be_presented_with_the_energy_details_page() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://energy.comparethemarket.com/energy/v2/yourEnergy?AFFCLIE=TST"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://energy.comparethemarket.com/energy/v2/yourEnergy?AFFCLIE=TST" );
    }

    @When("^I select tariff type (.*)$")
    public void i_select_tariff_type(String tariffindex) {
        driver.findElement(By.xpath(".//*[@id='electricity_tariff_additional_info_chosen']/a/div/b")).click();
        driver.findElement(By.xpath(".//*[@data-option-array-index=\""+tariffindex+"\"]")).click();
    }

    @When("^I select gas tariff type (.*)$")
    public void i_select_gas_tariff_type(String tariffindex) {
        driver.findElement(By.xpath(".//*[@id='gas_tariff_additional_info_chosen']/a/div/b")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@data-option-array-index=\""+tariffindex+"\"]")));
        driver.findElement(By.xpath(".//*[@data-option-array-index=\""+tariffindex+"\"]")).click();
    }

    @When("^I select payment type (.*)$")
    public void i_select_payment_type(String paymentindex) {
        driver.findElement(By.xpath(".//*[@id='electricity_payment_method_dropdown_link_chosen']/a/div/b")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@data-option-array-index=\""+paymentindex+"\"]")));
        driver.findElement(By.xpath(".//*[@data-option-array-index=\""+paymentindex+"\"]")).click();
    }

    @When("^I click (.*) for What is your current electricity usage$")
    public void i_click_kWh_for_What_is_your_current_electricity_usage(String usage) {
        switch (usage) {
            case "kWh":driver.findElement(By.xpath(".//*[@id='electricity-usage-question']/div/div/div[1]/label[1]/span")).click();
                break;
            case "pound":driver.findElement(By.xpath(".//*[@id='electricity-usage-question']/div/div/div[1]/label[2]/span")).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }

    }

    @When("^I enter current (.*) in kWh$")
    public void i_enter_current_usage_in_kWh(String usage) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("electricity-usage")));
        driver.findElement(By.id("electricity-usage")).sendKeys(usage);
    }

    @When("^I enter current gas (.*) in pounds")
    public void i_enter_current_usage_in_pounds(String usage) {
        driver.findElement(By.id("gas-current-spend")).sendKeys(usage);
    }

    @When("^I select payment frequency (.*)$")
    public void i_select_payment(String frequencyindex) {
        driver.findElement(By.xpath(".//*[@id='electricity_usage_dropdown_chosen']/a/div/b")).click();
        driver.findElement(By.xpath(".//*[@data-option-array-index=\""+frequencyindex+"\"]")).click();
    }

    @When("^I select gas payment frequency (.*)$")
    public void i_select_gas_payment(String frequencyindex) {
        driver.findElement(By.xpath(".//*[@id='gas_current_spend_period_chosen']/a/div/b")).click();
        driver.findElement(By.xpath(".//*[@data-option-array-index=\""+frequencyindex+"\"]")).click();
    }

    @When("^I select payment date$")
    public void i_select_payment_date() {
        driver.findElement(By.id("electricity-bill-day")).click();
        driver.findElement(By.xpath(".//*[@id='electricity-bill-day_root']/div/div/div/div/div[2]/button[1]")).click();
    }

    @Then("^I will be presented with the preferences details page$")
    public void i_will_be_presented_with_the_preferences_details_page() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://energy.comparethemarket.com/energy/v2/yourDetails?AFFCLIE=TST"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://energy.comparethemarket.com/energy/v2/yourDetails?AFFCLIE=TST" );
    }

    @Then("^I select (.*) for What tariff are you interested in$")
    public void i_select_Fixed_Tariff_for_What_tariff_are_you_interested_in(String tariff) {
        switch (tariff) {
            case "Fixed tariff":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tariff-selection-question']/div/label[1]/span")));
                driver.findElement(By.xpath(".//*[@id='tariff-selection-question']/div/label[1]/span")).click();
                break;
            case "Variable tariff":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tariff-selection-question']/div/label[2]/span")));
                driver.findElement(By.xpath(".//*[@id='tariff-selection-question']/div/label[2]/span")).click();
                break;
            case "All tariffs":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tariff-selection-question']/div/label[3]/span")));
                driver.findElement(By.xpath(".//*[@id='tariff-selection-question']/div/label[3]/span")).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid tariff type");
        }
    }

    @Then("^I select (.*) for What payment type are you interested in$")
    public void i_select_Monthly_direct_debit_for_What_payment_type_are_you_interested_in(String payment) {
        switch (payment) {
            case "Monthly direct debit":driver.findElement(By.xpath(".//*[@id='payment-selection-question']/div/label[1]/span")).click();
                break;
            case "Quarterly direct debit":driver.findElement(By.xpath(".//*[@id='payment-selection-question']/div/label[2]/span")).click();
                break;
            case "Pay on receipt of bill":driver.findElement(By.xpath(".//*[@id='payment-selection-question']/div/label[3]/span")).click();
                break;
            case "All payment types":driver.findElement(By.xpath(".//*[@id='payment-selection-question']/div/label[4]/span")).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }

    @Then("^I enter my contact details email (.*)$")
    public void i_enter_my_contact_details_email_abc_xyz_com(String email) {
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @Then("^I click yes to keep me up to date via email$")
    public void i_click_yes_to_keep_me_up_to_date_via_email() {
        driver.findElement(By.xpath(".//*[@id='marketingT']/div/div[2]/label/span[2]")).click();
    }

    @Then("^I click yes to accept terms and conditions$")
    public void i_click_yes_to_accept_terms_and_conditions() {
        driver.findElement(By.xpath(".//*[@id='terms-label']/span[2]")).click();
    }

    @Then("^I click on go to prices button$")
    public void i_click_on_go_to_prices_button() {
        driver.findElement(By.id("email-submit")).click();
    }

    @Then("^I will be presented with the energy results page$")
    public void i_will_be_presented_with_the_energy_results_page() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://energy.comparethemarket.com/energy/Results/YourResults"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://energy.comparethemarket.com/energy/Results/YourResults" );
    }

    @Then("^I will be presented with the energy no bill page$")
    public void i_will_be_presented_with_the_energy_no_bill_page() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://energy.comparethemarket.com/energy/v2/yourEnergyNoBill?AFFCLIE=TST"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://energy.comparethemarket.com/energy/v2/yourEnergyNoBill?AFFCLIE=TST" );
    }

    @When("^I click Yes for Is your gas and electricity from the same supplier$")
    public void i_click_Yes_for_Is_your_gas_and_electricity_from_the_same_supplier() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='same-supplier-question']/div/div/label[1]/span")));
        driver.findElement(By.xpath(".//*[@id='same-supplier-question']/div/div/label[1]/span")).click();
    }

    @When("^I click No for Is your gas and electricity from the same supplier$")
    public void i_click_No_for_Is_your_gas_and_electricity_from_the_same_supplier() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='same-supplier-question']/div/div/label[2]/span")));
        driver.findElement(By.xpath(".//*[@id='same-supplier-question']/div/div/label[2]/span")).click();
    }

    @When("^I click Yes for Is gas your main source of heating$")
    public void i_click_Yes_for_Is_gas_your_main_source_of_heating() {
        driver.findElement(By.xpath(".//*[@id='gas-main-heating-source-question']/div/div/label[1]/span")).click();
    }

    @When("^I click kWh for What is your current gas usage$")
    public void i_click_kWh_for_What_is_your_current_gas_usage() {
        driver.findElement(By.xpath(".//*[@id='gas-type-of-bill-question']/div/div/div[1]/label[1]/span")).click();
    }

    @When("^I enter current gas (.*) in kwh$")
    public void i_enter_current_gas_in_kwh(String usage) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("gas-usage")));
        driver.findElement(By.id("gas-usage")).sendKeys(usage);
    }

    @When("^I select gas bill payment date$")
    public void i_select_gas_bill_payment_date() {
        driver.findElement(By.id("gas-bill-day")).click();
        driver.findElement(By.xpath(".//*[@id='gas-bill-day_root']/div/div/div/div/div[2]/button[1]"));
    }

}
