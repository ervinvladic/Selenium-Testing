import static org.junit.jupiter.api.Assertions.*;

import java.awt.Desktop.Action;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class telemachba {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/Users/Ervin/eclipse-workspace/.metadata/Selenium-Testing/code/chromedriver/chromedriver.exe");
		webDriver= new ChromeDriver();
		baseUrl="https://telemach.ba/";
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
	/* Testing the EON package ordering option. 
	 * Filling out the order form and testing button functionality   */
	@Test
	void naruciEonPaket() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebElement EONPaketiButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(1) > a"));
		EONPaketiButton.click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor scroll1 = (JavascriptExecutor) webDriver;
		scroll1.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		
		WebElement EONFULL = webDriver.findElement(By.xpath("/html/body/div[3]/section[1]/div/ul/li[2]/div[1]/div[1]/h2"));
		String text2 = EONFULL.getText();
		assertEquals(text2,"EON FULL");
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(300,1400)", "");
		Thread.sleep(2000);
		
		WebElement naruciButton = webDriver.findElement(By.cssSelector(" body > div.page-wrap > section.eon-vertical-packages.js-eon-vertical-packages.js-open-footprint.banner-shadow > div > ul > li.bundle-item.package-wrap.package-class-2 > div.bundle-content.featured > div.buttons-section > a"));
		naruciButton.click();
		Thread.sleep(2000);
		
		WebElement tvojipodaci = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section/div/div[1]/div[3]/h5"));
		String text = tvojipodaci.getText();
		assertEquals(text,"Tvoji podaci");
		
		WebElement ImeiPrezime = webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(1) > input"));
		ImeiPrezime.sendKeys("Test Tester");
		Thread.sleep(2000);
		
		WebElement Telefon = webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(2) > input"));
		Telefon.sendKeys("033 333 333");
		Thread.sleep(2000);
		
		WebElement Email = webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(3) > input"));
		Email.sendKeys("test.tester@gmail.com");
		Thread.sleep(2000);
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		
		String handle1 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(5) > label > a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);

		WebElement saglasnost1=webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(5) > label > span"));
		saglasnost1.click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section/div/div[1]/div[3]/form/div[7]/p/a")).click();
		
		for(String handle3: webDriver.getWindowHandles()) {
			if (!handle3.equals(handle1)) {
				webDriver.switchTo().window(handle3);
				break;
			}
		}
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		WebElement saglasnost2=webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(6) > label > span"));
		saglasnost2.click();
		Thread.sleep(2000);
		
		WebElement naruciOnlineButton=webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section/div/div[1]/div[3]/form/div[4]/input"));
		naruciOnlineButton.click();
		Thread.sleep(2000);
		
	}
	
	/* Testing "Poslovnice". 
	 * Opening the drop-down menu, selecting the city Visoko, options for customer centers, 
	 * the company headquarters, and filling out the form for contacting the company.   
	 * */
	@Test
	void vidiPoslovnice() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement najblizaPoslovnica = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/ul[2]/li[1]/a/span"));
		najblizaPoslovnica.click();
		Thread.sleep(2000);
		
		WebElement poslovnice = webDriver.findElement(By.xpath("/html/body/div[3]/main/section[1]/div/div/div[1]/div[1]/h1"));
		String text = poslovnice.getText();
		assertEquals(text,"Poslovnice");
		
		WebElement izaberiGrad=webDriver.findElement(By.cssSelector("#map-app > div > div.container.top-wrapper > div.dropdown-wrapper > div > button"));
		izaberiGrad.click();
		Thread.sleep(2000);
		
		WebElement VisokoGrad=webDriver.findElement(By.cssSelector("#map-app > div > div.container.top-wrapper > div.dropdown-wrapper > div > ul > li:nth-child(5) > a"));
		VisokoGrad.click();
		Thread.sleep(2000);
		
		WebElement vidiKorisnickeCentre=webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(2) > a > span > span"));
		vidiKorisnickeCentre.click();
		Thread.sleep(2000);
		
		WebElement izaberiGrad1=webDriver.findElement(By.xpath("/html/body/div[3]/main/div/div/div/div/div[1]/div[3]/div/button"));
		izaberiGrad1.click();
		Thread.sleep(2000);
		
		WebElement TravnikGrad=webDriver.findElement(By.xpath("/html/body/div[3]/main/div/div/div/div/div[1]/div[3]/div/ul/li[3]/a"));
		TravnikGrad.click();
		Thread.sleep(2000);
		
		WebElement sjedisteKompanije=webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(4) > a"));
		sjedisteKompanije.click();
		Thread.sleep(2000);
		
		WebElement sjedisteKompanijeText = webDriver.findElement(By.xpath("/html/body/div[3]/main/section[1]/div/div/div[1]/div[1]/h1"));
		String text2 = sjedisteKompanijeText.getText();
		assertEquals(text2,"Sjedište kompanije");
		
		WebElement kontaktirajteNas=webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(3) > a"));
		kontaktirajteNas.click();
		Thread.sleep(2000);
		
		WebElement kontaktirajteNasText = webDriver.findElement(By.xpath("/html/body/div[3]/main/section[1]/div/div/div[1]/div[1]/h1"));
		String text3 = kontaktirajteNasText.getText();
		assertEquals(text3,"Kontaktirajte nas");
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		
		WebElement posaljite=webDriver.findElement(By.cssSelector("#sbbContactFormSendBtn"));
		posaljite.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,-600)", "");
		Thread.sleep(2000);
		
		WebElement ImeiPrezime = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(3) > div > input"));
		ImeiPrezime.sendKeys("Test Tester");
		Thread.sleep(2000);
		
		WebElement Email = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(4) > div:nth-child(1) > input"));
		Email.sendKeys("test.tester@gmail.com");
		Thread.sleep(2000);
		
		WebElement Telefon = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(4) > div:nth-child(2) > input"));
		Telefon.sendKeys("033 333 333");
		Thread.sleep(2000);
		
		WebElement Adresa = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(5) > div:nth-child(1) > input"));
		Adresa.sendKeys("Testna Adresa");
		Thread.sleep(2000);
		
		WebElement Postanskibroj = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(5) > div:nth-child(2) > input"));
		Postanskibroj.sendKeys("Testni Postanski Broj");
		Thread.sleep(2000);
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		
		WebElement Grad = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(6) > div:nth-child(1) > input"));
		Grad.sendKeys("Testni grad");
		Thread.sleep(2000);
		
		WebElement PitanjeSeOdnosiOtvori = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/div/div[1]/div/form/div[4]/div[2]/div/div/input"));
		PitanjeSeOdnosiOtvori.click();
		Thread.sleep(2000);
		
		WebElement PrimjedbeiSugestije = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/div/div[1]/div/form/div[4]/div[2]/div/ul/li[3]"));
		PrimjedbeiSugestije.click();
		Thread.sleep(2000);
		
		WebElement Poruka = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(7) > div > textarea"));
		Poruka.sendKeys("Ovo je testna poruka");
		Thread.sleep(2000);
		
		JavascriptExecutor scroll4 = (JavascriptExecutor) webDriver;
		scroll4.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		
		WebElement posaljite2=webDriver.findElement(By.cssSelector("#sbbContactFormSendBtn"));
		posaljite2.click();
		Thread.sleep(2000);
		
		
}
	/* Putting the "O Nama" option to the test, 
	 * analyzing the options within, and learning more about management personnel
	 * */
	@Test
	void oNamaTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement ONamaButton = webDriver.findElement(By.cssSelector("#siteHeader > div.header-top.hidden-md-down > div > nav > ul.hd-nav-container.top-left-nav > li:nth-child(4) > a"));
		ONamaButton.click();
		Thread.sleep(2000);
		
		WebElement GodinasaVamaButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(1) > a"));
		GodinasaVamaButton.click();
		Thread.sleep(2000);
		
		WebElement ZaposlenjeButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(3) > a:nth-child(2)"));
		ZaposlenjeButton.click();
		Thread.sleep(2000);
		
		WebElement menadzmentButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(3) > a:nth-child(1)"));
		menadzmentButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		
		WebElement procitajteVise = webDriver.findElement(By.cssSelector("#content > section.banner-about-us.about-us-margin-bottom > div > div:nth-child(1) > div.col-md-6.desc > a"));
		procitajteVise.click();
		Thread.sleep(2000);
		
		WebElement menadzmentText = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[1]/div/div[4]/h2"));
		String text2 = menadzmentText.getText();
		assertEquals(text2,"Menadžment");
		
		JavascriptExecutor scroll1 = (JavascriptExecutor) webDriver;
		scroll1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);
		
		WebElement HajdiMostic = webDriver.findElement(By.cssSelector("#content > section.container.story-page-wrapper > div > div.sidebar > ul > li:nth-child(1) > a > label"));
		HajdiMostic.click();
		Thread.sleep(2000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://telemach.ba/menadzment/hajdi-mostic-2/");
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);
		
		WebElement SevalBecirevic = webDriver.findElement(By.cssSelector("#content > section.container.story-page-wrapper > div > div.sidebar > ul > li:nth-child(2) > a > label"));
		SevalBecirevic.click();
		Thread.sleep(2000);
		
		String url2= webDriver.getCurrentUrl();
		assertEquals(url2,"https://telemach.ba/menadzment/seval-becirevic/");
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);
				
}
	
	/* Testing the public directory of telephone numbers. There are two public directories: 
	 * private and business. Initial testing of business directory populating and searching 
	 * was followed by private directory populating and searching.
	 * */
	@Test
	void telefonijaTest() throws InterruptedException {
		
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(2000);
		
		WebElement javniImenik = webDriver.findElement(By.cssSelector("#ft-navigation > li:nth-child(4) > ul > li > a"));
		javniImenik.click();
		Thread.sleep(2000);
		
		WebElement text = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section/div/div/div/div/div/div/div/div/div/h1"));
		String text2 = text.getText();
		assertEquals(text2,"BRZO I LAKO PRONAĐITE TELEFONSKI BROJ TELEMACH KORISNIKA");
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		
		WebElement poslovniButton = webDriver.findElement(By.cssSelector("#myTab > li:nth-child(2) > a"));
		poslovniButton.click();
		Thread.sleep(2000);
		
		WebElement nazivPravnogLica = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(1) > input"));
		nazivPravnogLica.sendKeys("Test Tester");
		Thread.sleep(2000);
		
		WebElement paddingMenuMjesto = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(2) > div > div > input"));
		paddingMenuMjesto.click();
		Thread.sleep(2000);
		
		WebElement kiseljakMjesto = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(2) > div > ul > li:nth-child(15)"));
		kiseljakMjesto.click();
		Thread.sleep(2000);
		
		WebElement ulicaPravnogLica = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(3) > input"));
		ulicaPravnogLica.sendKeys("Testna Ulica");
		Thread.sleep(2000);
		
		WebElement telefonPravnogLica = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(4) > input"));
		telefonPravnogLica.sendKeys("033 333 333");
		Thread.sleep(2000);
		
		WebElement traziteButtonPravni = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div.field-wrapper.col-xs-12.col-sm-6.col-lg-6.clearfix > button"));
		traziteButtonPravni.click();
		Thread.sleep(2000);
		
		WebElement privatniButton = webDriver.findElement(By.cssSelector("#myTab > li:nth-child(1) > a"));
		privatniButton.click();
		Thread.sleep(2000);
		
		WebElement Ime = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(1) > input"));
		Ime.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement Prezime = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(2) > input"));
		Prezime.sendKeys("Tester");
		Thread.sleep(2000);
		
		WebElement paddingMenuzaMjesto = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(3) > div > div > input"));
		paddingMenuzaMjesto.click();
		Thread.sleep(2000);
		
		WebElement capljinaMjesto = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(3) > div > ul > li:nth-child(37)"));
		capljinaMjesto.click();
		Thread.sleep(2000);
		
		WebElement Ulica = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(4) > input"));
		Ulica.sendKeys("Testna Ulica");
		Thread.sleep(2000);
		
		WebElement Telefon = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(5) > input"));
		Telefon.sendKeys("033 333 333");
		Thread.sleep(2000);
		
		WebElement traziteButton = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div.field-wrapper.col-xs-12.col-sm-offset-6.col-sm-6.col-lg-offset-0.col-lg-3.clearfix > button"));
		traziteButton.click();
		Thread.sleep(2000);
		
	}
	
	/* Testing the "Podrska" option and all options within it also testing the search option.
	 * */
	@Test
	void podrskaTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement podrskaButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[5]/a"));
		podrskaButton.click();
		Thread.sleep(2000);
		
		WebElement televizijaButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[1]/div/div/div[2]/div[2]/ul/li[1]/a"));
		televizijaButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		
		WebElement d3digitalnatelevizija = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[2]/div[1]/div/ul/li[2]/a"));
		d3digitalnatelevizija.click();
		Thread.sleep(2000);
		
		String handle1 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[2]/div[3]/div[2]/div/div/div/div/section/div/div[3]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,-1000)", "");
		Thread.sleep(2000);
		
		WebElement internetButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[1]/div/div/div[1]/div[2]/ul/li[2]/a"));
		internetButton.click();
		Thread.sleep(2000);
		
		WebElement text = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[1]/div/div/div[1]/div[1]/h1"));
		String text2 = text.getText();
		assertEquals(text2,"Internet");
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		
		WebElement unifiButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[3]/div[1]/div/ul/li[2]/a"));
		unifiButton.click();
		Thread.sleep(2000);
		
		WebElement emailButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[3]/div[1]/div/ul/li[3]/a"));
		emailButton.click();
		Thread.sleep(2000);
		
		String handle2 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[3]/div[3]/div[3]/div/div/div/div/section/div/div[3]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle2)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle2);
		Thread.sleep(2000);
		
		JavascriptExecutor scroll4 = (JavascriptExecutor) webDriver;
		scroll4.executeScript("window.scrollBy(0,-1000)", "");
		Thread.sleep(2000);
		
		WebElement telefonijaButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[1]/div/div/div[1]/div[2]/ul/li[3]/a"));
		telefonijaButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll5 = (JavascriptExecutor) webDriver;
		scroll5.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		
		WebElement unifon = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[2]/div[1]/div/ul/li[2]/a"));
		unifon.click();
		Thread.sleep(2000);
		
		String handle3 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[2]/div[3]/div[2]/div/div/div/div/section/div/div[2]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle3)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle3);
		Thread.sleep(2000);
		
		JavascriptExecutor scroll6 = (JavascriptExecutor) webDriver;
		scroll6.executeScript("window.scrollBy(0,-1000)", "");
		Thread.sleep(2000);
		
		WebElement prikljucenjeButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[1]/div/div/div[1]/div[2]/ul/li[4]/a"));
		prikljucenjeButton.click();
		Thread.sleep(2000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://telemach.ba/podrska/servisi/prikljucenje/");
		
		WebElement searchPrikljucenje = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > form > input"));
		searchPrikljucenje.sendKeys("Test");
		searchPrikljucenje.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}
	/* Testing the "Aplikacije" and "My Telemach" options within the application, 
	 * there is an option to test the button and switch to "My Telemach." 
	 * After that, test logging in and registering into My Telemach.
	 * */
	@Test
	void aplikacijeImojTelemachTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement aplikacijeButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(4) > a"));
		aplikacijeButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,1200)", "");
		Thread.sleep(2000);
		
		WebElement mojaTelevizijaButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[1]/a/span"));
		mojaTelevizijaButton.click();
		Thread.sleep(2000);
		
		WebElement mojInternetButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[2]/a/span"));
		mojInternetButton.click();
		Thread.sleep(2000);
		
		WebElement mojaTelefonijaButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[3]/a/span"));
		mojaTelefonijaButton.click();
		Thread.sleep(2000);
		
		WebElement mojiUredjajiButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[4]/a/span"));
		mojiUredjajiButton.click();
		Thread.sleep(2000);
		
		WebElement mojiRacuniIuplateButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[1]/a/span"));
		mojiRacuniIuplateButton.click();
		Thread.sleep(2000);
		
		WebElement unifiButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[2]/a/span"));
		unifiButton.click();
		Thread.sleep(2000);
		
		WebElement eonButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[3]/a/span"));
		eonButton.click();
		Thread.sleep(2000);
		
		WebElement unifonButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[4]/a/span/span"));
		unifonButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll1 = (JavascriptExecutor) webDriver;
		scroll1.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		
		WebElement aktivirajMojTelemach = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[4]/div/div/div/div[3]/a"));
		aktivirajMojTelemach.click();
		Thread.sleep(2000);
		
		WebElement text = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/div/h1"));
		String text2 = text.getText();
		assertEquals(text2,"Prijava");
		
		WebElement korisnickoIme = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/mat-form-field[1]/div/div[1]/div/input"));
		korisnickoIme.sendKeys("test.tester@gmail.com");
		Thread.sleep(2000);
		
		WebElement lozinka = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/mat-form-field[2]/div/div[1]/div/input"));
		lozinka.sendKeys("testnalozinka");
		Thread.sleep(2000);
		
		WebElement zapamtiMe = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/mat-checkbox/label/div"));
		zapamtiMe.click();
		Thread.sleep(2000);
		
		WebElement ulogujSe = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/button"));
		ulogujSe.click();
		Thread.sleep(2000);
		
		WebElement registracijaButton = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/div/a"));
		registracijaButton.click();
		Thread.sleep(2000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://mojtelemach.ba/registration");
		
		WebElement IDKorisnika = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[1]/div[1]/mat-form-field[1]/div/div[1]/div/input"));
		IDKorisnika.sendKeys("333333");
		Thread.sleep(2000);
		
		WebElement brojUgovora = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[1]/div[1]/mat-form-field[2]/div/div[1]/div/input"));
		brojUgovora.sendKeys("e2345");
		Thread.sleep(2000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[1]/div[2]/mat-form-field/div/div[1]/div/input"));
		email.sendKeys("test.tester@gmail.com");
		Thread.sleep(2000);
		
		WebElement lozinka1 = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[2]/mat-form-field[1]/div/div[1]/div/input"));
		lozinka1.sendKeys("test123");
		Thread.sleep(2000);
		
		WebElement opetlozinka = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[2]/mat-form-field[2]/div/div[1]/div/input"));
		opetlozinka.sendKeys("test123");
		Thread.sleep(2000);
		
		WebElement checkBox = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[2]/mat-checkbox/label/div"));
		checkBox.click();
		Thread.sleep(2000);
		
		WebElement checkBox1 = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[2]/mat-checkbox/label/div"));
		checkBox1.click();
		Thread.sleep(2000);
		
		WebElement registracijaButton1 = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div/form/div[3]/button"));
		registracijaButton1.click();
		Thread.sleep(2000);
		
		
	}
	/* Testing the program scheme, all drop-down menus, search options, 
	 * and buttons within the scheme
	 * */
	@Test
	void programskaShemaTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement EONTVButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/a"));
		EONTVButton.click();
		Thread.sleep(2000);
		
		WebElement ProgramskaShemaButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[3]/a"));
		ProgramskaShemaButton.click();
		Thread.sleep(2000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://telemach.ba/eon-tv/programska-shema/");
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		
		WebElement PosebnaVrstaKanala = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/div/div/input"));
		PosebnaVrstaKanala.click();
		Thread.sleep(2000);
		
		WebElement dokumentarni = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div/ul/li[2]"));
		dokumentarni.click();
		Thread.sleep(2000);
		
		WebElement search = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[2]/div[1]/div/div/div/div/div[2]/input"));
		search.sendKeys("discovery");
		Thread.sleep(2000);
		
		WebElement ponistiPretragu = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[2]/div[1]/div/div/div/button"));
		ponistiPretragu.click();
		Thread.sleep(2000);
		
		WebElement startPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[2]/a"));
		startPaket.click();
		Thread.sleep(2000);
		
		WebElement osnovniPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[3]/a"));
		osnovniPaket.click();
		Thread.sleep(2000);
		
		WebElement prosireniPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[4]/a"));
		prosireniPaket.click();
		Thread.sleep(2000);
		
		WebElement HBOpaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[5]/a"));
		HBOpaket.click();
		Thread.sleep(2000);
		
		WebElement CinemaxPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[6]/a"));
		CinemaxPaket.click();
		Thread.sleep(2000);
		
		WebElement PinkPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[7]/a"));
		PinkPaket.click();
		Thread.sleep(2000);
		
		WebElement HBOPremium = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[8]/a"));
		HBOPremium.click();
		Thread.sleep(2000);
		
		WebElement ZadrugaPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[9]/a"));
		ZadrugaPaket.click();
		Thread.sleep(2000);
		
		WebElement CinestarPremiere = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[10]/a"));
		CinestarPremiere.click();
		Thread.sleep(2000);
}
	/* Testing the EONTV option, drop-down menu buttons, and all options within EONTV
	 * */
	@Test
	void EONTVTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement EONTVButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/a"));
		EONTVButton.click();
		Thread.sleep(2000);
	
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,1800)", "");
		Thread.sleep(2000);
		
		WebElement EONAplikacija = webDriver.findElement(By.xpath("/html/body/div[3]/section[2]/div[2]/div/ul/li[2]/a"));
		EONAplikacija.click();
		Thread.sleep(2000);
		
		WebElement Dodatniuredjaji = webDriver.findElement(By.xpath("/html/body/div[3]/section[2]/div[2]/div/ul/li[3]/a"));
		Dodatniuredjaji.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll1 = (JavascriptExecutor) webDriver;
		scroll1.executeScript("window.scrollBy(0,-1800)", "");
		Thread.sleep(2000);
		
		WebElement EON = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[2]/a"));
		EON.click();
		Thread.sleep(2000);
		
		WebElement Programskashema = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[3]/a"));
		Programskashema.click();
		Thread.sleep(2000);
		
		WebElement Videoklub = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[4]/a"));
		Videoklub.click();
		Thread.sleep(2000);
		
		WebElement uredjaji = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[5]/a"));
		uredjaji.click();
		Thread.sleep(3000);
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(3000);
		
		WebElement smartTV = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div[1]/div/ul/li[2]/a"));
		smartTV.click();
		Thread.sleep(3000);
		
		WebElement tablet_mobilni = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div[1]/div/ul/li[3]/a"));
		tablet_mobilni.click();
		Thread.sleep(2000);
		
		WebElement pc_mac = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div[1]/div/ul/li[4]/a"));
		pc_mac.click();
		Thread.sleep(2000);
		
		WebElement streaming_uredjaji = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div[1]/div/ul/li[5]/a"));
		streaming_uredjaji.click();
		Thread.sleep(2000);
		
		WebElement personalizacija = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[6]/a"));
		personalizacija.click();
		Thread.sleep(2000);
		
		WebElement EONKids = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[7]/a"));
		EONKids.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,5000)", "");
		Thread.sleep(2000);
		
		WebElement EONKidsPitanje3 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[10]/div/section/div/div[3]/div[1]/h4/a"));
		EONKidsPitanje3.click();
		Thread.sleep(2000); 
		
		WebElement EONKidsPitanje33 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[10]/div/section/div/div[3]/div[1]/h4/a/span"));
		EONKidsPitanje33.click();
		Thread.sleep(2000);
		
		
		JavascriptExecutor scroll4 = (JavascriptExecutor) webDriver;
		scroll4.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		
		WebElement EONKidsPitanje5 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[10]/div/section/div/div[5]/div[1]/h4/a"));
		EONKidsPitanje5.click();
		Thread.sleep(2000);
		
		WebElement EONKidsPitanje55 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[10]/div/section/div/div[5]/div[1]/h4/a/span"));
		EONKidsPitanje55.click();
		Thread.sleep(2000);
}
	/* 
	 * Testing menu options, wifi mesh, and frequently asked questions within wifi mesh */
	@Test
	void menuTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		
		WebElement menuButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/button[2]"));
		menuButton.click();
		Thread.sleep(2000);
		
		WebElement wifiMesh = webDriver.findElement(By.xpath("/html/body/div[3]/header/section/nav/ul/li[1]/ul/li[1]/ul/li[4]/a"));
		wifiMesh.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,3200)", "");
		Thread.sleep(2000);
		
		WebElement pitanja = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div/section/div/h3"));
		String text2 = pitanja.getText();
		assertEquals(text2,"NAJČEŠĆE POSTAVLJENA PITANJA");
		
		WebElement pitanje2 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div/section/div/div[2]/div[1]/h4/a/span"));
		pitanje2.click();
		Thread.sleep(2000);
		
		WebElement pitanje22 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div/section/div/div[2]/div[1]/h4/a/span"));
		pitanje22.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		
		WebElement pitanje3 = webDriver.findElement(By.xpath("//html/body/div[3]/div[2]/main/section[9]/div/section/div/div[3]/div[1]/h4/a/span"));
		pitanje3.click();
		Thread.sleep(2000);
		
		WebElement pitanje33 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div/section/div/div[3]/div[1]/h4/a/span"));
		pitanje33.click();
		Thread.sleep(2000);
		
		WebElement pitanje4 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div/section/div/div[4]/div[1]/h4/a/span"));
		pitanje4.click();
		Thread.sleep(2000);
		
		WebElement pitanje44 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div/section/div/div[4]/div[1]/h4/a/span"));
		pitanje44.click();
		Thread.sleep(2000);
		
	}
	/* 
	 * Visiting other websites (EON, TotalTV, TV Vodic, Facebook page) and testing the search option on the main page*/
	@Test
	void EONTotalTvVodic() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		String handle1 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/ul[1]/li[5]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://bh.eon.tv/");
		
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		
		webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/ul[1]/li[6]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		
		webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/ul[1]/li[7]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		WebElement search = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/aside/div/div/div/form/table/tbody/tr/td[2]/button"));
		search.click();
		Thread.sleep(2000);
		
		WebElement searchTest = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/aside/div/div/div/form/table/tbody/tr/td[1]/div/table/tbody/tr/td[1]/input"));
		searchTest.sendKeys("Test");
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,1800)", "");
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/footer/div/div/div/div[2]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		
		String url2= webDriver.getCurrentUrl();
		assertEquals(url2,"https://united.group/");
		
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		WebElement newsLetter = webDriver.findElement(By.xpath("/html/body/div[3]/footer/nav/div[2]/ul/li[2]/a"));
		newsLetter.click();
		Thread.sleep(2000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/form/input"));
		email.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement close = webDriver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/button"));
		close.click();
		Thread.sleep(2000);
		
		
}
	/* 
	 * Testing of Tidal located within the "Aplikacije."  Buttons and questions within Tidal */
	@Test
	void tidalTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement aplikacijeButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[4]/a"));
		aplikacijeButton.click();
		Thread.sleep(2000);
		
		WebElement tidalButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[4]/ul/li[7]/a"));
		tidalButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(2000);
		
		WebElement button1 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div/div[1]/div/ol/li[2]"));
		button1.click();
		Thread.sleep(2000);
		
		WebElement button2 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div/div[1]/div/ol/li[3]"));
		button2.click();
		Thread.sleep(2000);
		
		WebElement button3 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div/div[1]/div/ol/li[4]"));
		button3.click();
		Thread.sleep(2000);
		
		WebElement button4 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div/div[1]/div/ol/li[5]"));
		button4.click();
		Thread.sleep(2000);
		
		WebElement button5 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div/div[1]/div/ol/li[6]"));
		button5.click();
		Thread.sleep(2000);
		
		WebElement text = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[2]/div/div[2]/div[6]/div/div[2]/h1"));
		String text2 = text.getText();
		assertEquals(text2,"Video & live stream");
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(2000);
		
		WebElement saznajVise = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[5]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/a"));
		saznajVise.click();
		Thread.sleep(2000);
		
		WebElement tidalPitanje = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[5]/div/div/div/div/div/div/div/div[2]/div/section/div/section/div/div[1]/div[1]/h4/a"));
		tidalPitanje.click();
		Thread.sleep(2000);
		
		WebElement tidalPitanje1 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[5]/div/div/div/div/div/div/div/div[2]/div/section/div/section/div/div[1]/div[1]/h4/a/span"));
		tidalPitanje1.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		
		WebElement pitanje2 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[5]/div/div/div/div/div/div/div/div[2]/div/div/div[2]/section/div/section/div/div[6]/div[1]/h4/a"));
		pitanje2.click();
		Thread.sleep(2000);
		
		WebElement pitanje22 = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[5]/div/div/div/div/div/div/div/div[2]/div/div/div[2]/section/div/section/div/div[6]/div[1]/h4/a/span"));
		pitanje22.click();
		Thread.sleep(2000);
		
}
	/* 
	 * Testing functionality of social media buttons at the bottom of home screen (Facebook, Twitter, Youtube, LinkedIn, Instagram) */
	@Test
	void socijalneMreze() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,3000)", "");
		Thread.sleep(2000);
		
		String handle1 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/footer/nav/div[2]/div/ul/li[1]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://www.facebook.com/TelemachBH");
		
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/footer/nav/div[2]/div/ul/li[2]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/footer/nav/div[2]/div/ul/li[3]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/footer/nav/div[2]/div/ul/li[4]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/footer/nav/div[2]/div/ul/li[5]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		String url2= webDriver.getCurrentUrl();
		assertEquals(url2,"https://www.instagram.com/telemachbh/");
		
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);

}
	/* 
	 * Going to other sites: visiting Google Play, Apple Store, Huawei Store, and the sites of Telemach partner companies. */
	@Test
	void externalLinks() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
			
		WebElement aplikacijeButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[4]/a"));
		aplikacijeButton.click();
		Thread.sleep(2000);
			
		WebElement EONConnect = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[4]/ul/li[2]/a"));
		EONConnect.click();
		Thread.sleep(2000);
			
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,3800)", "");
		Thread.sleep(2000);
		
		String handle1 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div[1]/div[1]/div/div/div[2]/div/div[4]/a[1]/img")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://apps.apple.com/hr/app/eon-connect/id1500805349?l=hr");
		
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div[1]/div[1]/div/div/div[2]/div/div[4]/a[2]/img")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[9]/div[1]/div[1]/div/div/div[2]/div/div[4]/a[3]/img")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		
		WebElement menu = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/button[2]"));
		menu.click();
		Thread.sleep(2000);
		
		WebElement udruzeneKompanije = webDriver.findElement(By.xpath("/html/body/div[3]/header/section/nav/ul/li[1]/ul/li[7]/ul/li[6]/a"));
		udruzeneKompanije.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,1300)", "");
		Thread.sleep(2000);
		
		String handle2 = webDriver.getWindowHandle();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div[1]/div/div[2]/div[3]/div/div[2]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		
		String url2= webDriver.getCurrentUrl();
		assertEquals(url2,"http://www.hs-ktv.ba/?page_id=4626");
		
		webDriver.close();
		webDriver.switchTo().window(handle2);
		Thread.sleep(2000);
		
		JavascriptExecutor scroll4 = (JavascriptExecutor) webDriver;
		scroll4.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[4]/div[1]/div/div[2]/div[3]/div/div[2]/a")).click();
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(4000);
		webDriver.close();
		webDriver.switchTo().window(handle2);
		Thread.sleep(2000);
		

}
	/* 
	Testing business solutions site from telemach and ordering of one solution */
	
	@Test
	void poslovniTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		WebElement poslovniButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/ul[1]/li[2]/a"));
		poslovniButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,3000)", "");
		Thread.sleep(2000);
		
		WebElement mailRjesenja = webDriver.findElement(By.xpath("/html/body/div[3]/footer/nav/div/ul/li[6]/ul/li[3]/a"));
		mailRjesenja.click();
		Thread.sleep(2000);
		
		String url= webDriver.getCurrentUrl();
		assertEquals(url,"https://poslovni.telemach.ba/poslovna-rjesenja/mail-rjesenja/");
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(2000);
		
		WebElement naruciteButton= webDriver.findElement(By.xpath("/html/body/div[3]/div/main/section[3]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div[3]/a"));
		naruciteButton.click();
		Thread.sleep(2000);
		
		WebElement Audiostreaming= webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/fieldset[1]/div[2]/div[2]/div/ul/li[7]/div"));
		Audiostreaming.click();
		Thread.sleep(2000);
		
		WebElement imeCloudServera = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/fieldset[2]/div[1]/input"));
		imeCloudServera.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement CPU= webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/fieldset[3]/div[1]/div[2]/div/span"));
		CPU.click();
		Thread.sleep(2000);
		
		WebElement RAM= webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/fieldset[3]/div[2]/div[2]/div"));
		RAM.click();
		Thread.sleep(2000);
		
		WebElement SSD= webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/fieldset[3]/div[4]/div"));
		SSD.click();
		Thread.sleep(2000);
		
		WebElement cijena = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[2]/div/div/div/fieldset/div/div[1]/div[2]/div/span"));
		String text2 = cijena.getText();
		assertEquals(text2,"289.86 KM");
		
		JavascriptExecutor scroll3 = (JavascriptExecutor) webDriver;
		scroll3.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		
		WebElement korisnickoIme = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/fieldset[4]/div[1]/input"));
		korisnickoIme.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement lozinka = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/fieldset[4]/div[2]/input"));
		lozinka.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement checkBox= webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div/div[1]/div/div/div[2]/p/input"));
		checkBox.click();
		Thread.sleep(2000);
			
}
	/* 
	Testing contact us option for businesses */
	
	@Test
	void poslovniTest2() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor) webDriver;
		
		WebElement poslovniButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/nav/ul[1]/li[2]/a"));
		poslovniButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(2000);
		
		WebElement kontaktirajteNas = webDriver.findElement(By.xpath("/html/body/div[3]/div/main/section[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
		kontaktirajteNas.click();
		Thread.sleep(2000);
		
		WebElement adresa = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/h4[1]"));
		String text2 = adresa.getText();
		assertEquals(text2,"Adresa korištenja odabrane usluge");
		
		WebElement nazivKompanije = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[1]/div[1]/input"));
		nazivKompanije.sendKeys("Test Tester");
		Thread.sleep(2000);
		
		WebElement PDV = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[1]/div[2]/input"));
		PDV.sendKeys("3333");
		Thread.sleep(2000);
		
		WebElement ID = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[1]/div[3]/input"));
		ID.sendKeys("3333");
		Thread.sleep(2000);
		
		WebElement opcina = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[1]/div[4]/input"));
		opcina.sendKeys("Testna");
		Thread.sleep(2000);
		
		WebElement naselje = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[1]/div[5]/input"));
		naselje.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement nazivUlice = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[1]/div[6]/input"));
		nazivUlice.sendKeys("Test Tester");
		Thread.sleep(2000);
		
		WebElement kucniBroj = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[1]/div[7]/input"));
		kucniBroj.sendKeys("8");
		Thread.sleep(2000);
		
		WebElement kontaktpodaci = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/h4[2]"));
		String text3 = kontaktpodaci.getText();
		assertEquals(text3,"Kontakt podaci");
		
		
		WebElement Ime = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[2]/div[1]/input"));
		Ime.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement Prezime = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[2]/div[2]/input"));
		Prezime.sendKeys("Tester");
		Thread.sleep(2000);
		
		WebElement kontaktTelefon = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[2]/div[3]/input"));
		kontaktTelefon.sendKeys("033 333 333");
		Thread.sleep(2000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[2]/div[4]/input"));
		email.sendKeys("test.tester@test.com");
		Thread.sleep(2000);
		
		
		WebElement scroll2=webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[3]/div[2]/button"));
		js.executeScript("arguments[0].scrollIntoView(true);",scroll2);
		
		Thread.sleep(2000);
		
		WebElement napomena = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[2]/div[5]/textarea"));
		napomena.sendKeys("Test!");
		Thread.sleep(2000);
		
		WebElement posaljite = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/section/form/div[3]/div[2]/button"));
		posaljite.click();
		Thread.sleep(2000);
		
		WebElement scroll3=webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/button/span"));
		js.executeScript("arguments[0].scrollIntoView(true);",scroll3);
		
		Thread.sleep(2000);
		
		WebElement close = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/button/span"));
		close.click();
		Thread.sleep(2000);
		
	}
	
}



