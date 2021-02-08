package stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import pages.SearchResultPage;

import org.junit.Assert;

public class Search {
//	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
	private MainPage mainPage = new MainPage(DriverFactory.getDriver()); 
	private SearchResultPage searchResultPage = new SearchResultPage(DriverFactory.getDriver());

	

	@Given("Open browser in http:\\/\\/localhost:{int}\\/shows")
	public void open_browser_in_http_localhost_shows(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
//		driver.get("http://localhost:3000/shows");
		DriverFactory.getDriver().get("http://localhost:3000/shows");
	}

	@Given("Enter a text in search box with text {string}")
	public void enter_a_text_in_search_box_with_text_batman(String searchTerm){
		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(5000);
		mainPage.enterSearchTerm(searchTerm);
	}

	@Given("Press button search")
	public void press_button_search() {
		// Write code here that turns the phrase above into concrete actions
		mainPage.pressSearchButton();
	}

	@Given("Navigate to the url that is show in second card of results")
	public void navigate_to_the_url_that_is_show_in_second_card_of_results() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[contains(@class, 'row')][2]/div/div/div[2]/a")).click();
		searchResultPage.pressUrl();
	}

	@Given("Navigate back using browser features")
	public void navigate_back_using_browser_features() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(2000);
//		driver.navigate().back();
		DriverFactory.getDriver().navigate().back();
	}

	@Given("Change css background color to #4a148c to card with title Batman Unlimited")
	public void change_css_background_color_to_4a148c_to_card_with_title_batman_unlimited() {
		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,3000);");
//		Thread.sleep(5000);
		js.executeScript(
				"document.evaluate('/html/body/div/div[8]/div/div/div[1]', document).iterateNext().style.backgroundColor = '#4a148c';");

	}

	@When("Press back button")
	public void press_back_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(5000);
//		WebElement buttonBack = driver.findElement(By.xpath("//body/div/a"));
//		Assert.assertEquals(true, buttonBack.isDisplayed());
//		buttonBack.click();
		searchResultPage.pressBackButton();
//		Thread.sleep(10000);
	}

	@Then("Make sure that input for search is empty")
	public void make_sure_that_input_for_search_is_empty() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(true, mainPage.isSearchBoxEmpty());
		System.out.println("Is search text box empty? " + mainPage.isSearchBoxEmpty());
		
//		throw new io.cucumber.java.PendingException();
	}
}
