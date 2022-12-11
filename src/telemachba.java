import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		System.setProperty("webdriver.chrome.driver","C:/Users/Ervin/eclipse-workspace/.metadata/Selenium Testing - telemach.ba/code/chromedriver/chromedriver.exe");
		webDriver= new ChromeDriver();
		baseUrl="https://telemach.ba/";
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	@Test
	void naruciEonPaket() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		Thread.sleep(3000);
		WebElement EONPaketiButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(1) > a"));
		EONPaketiButton.click();
		
		Thread.sleep(3000);
		
		JavascriptExecutor scroll1 = (JavascriptExecutor) webDriver;
		scroll1.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(5000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(300,1400)", "");
		Thread.sleep(2000);
		
		WebElement naruciButton = webDriver.findElement(By.cssSelector(" body > div.page-wrap > section.eon-vertical-packages.js-eon-vertical-packages.js-open-footprint.banner-shadow > div > ul > li.bundle-item.package-wrap.package-class-2 > div.bundle-content.featured > div.buttons-section > a"));
		
		naruciButton.click();
		Thread.sleep(5000);
		
		WebElement ImeiPrezime = webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(1) > input"));
		ImeiPrezime.sendKeys("Test Tester");
		Thread.sleep(3000);
		
		WebElement Telefon = webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(2) > input"));
		Telefon.sendKeys("033 333 333");
		Thread.sleep(3000);
		
		WebElement Email = webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(3) > input"));
		Email.sendKeys("test.tester@gmail.com");
		Thread.sleep(3000);
		
		JavascriptExecutor scroll2 = (JavascriptExecutor) webDriver;
		scroll2.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(5000);
		
		WebElement saglasnost1=webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(5) > label > span"));
		saglasnost1.click();
		Thread.sleep(3000);
		
		
		WebElement saglasnost2=webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(6) > label > span"));
		saglasnost2.click();
		Thread.sleep(3000);
		
		WebElement procitajSaglasnost=webDriver.findElement(By.cssSelector("#content > section > div > div.package-container > div.form-wrapper > form > div:nth-child(5) > label > a"));
		procitajSaglasnost.click();
		Thread.sleep(3000);
		
		
	}
	@Test
	void vidiPoslovnice() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		WebElement EONPaketiButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(1) > a"));
		EONPaketiButton.click();
		
		Thread.sleep(5000);
		
		WebElement poslovnice=webDriver.findElement(By.cssSelector("body > div.page-wrap > section:nth-child(13) > div > div > div:nth-child(2) > div > div.info > p > a"));
		poslovnice.click();
		Thread.sleep(3000);
		
		WebElement izaberiGrad=webDriver.findElement(By.cssSelector("#map-app > div > div.container.top-wrapper > div.dropdown-wrapper > div > button"));
		izaberiGrad.click();
		Thread.sleep(3000);
		
		WebElement VisokoGrad=webDriver.findElement(By.cssSelector("#map-app > div > div.container.top-wrapper > div.dropdown-wrapper > div > ul > li:nth-child(5) > a"));
		VisokoGrad.click();
		Thread.sleep(6000);
		
		
		WebElement vidiKorisnickeCentre=webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(2) > a > span > span"));
		vidiKorisnickeCentre.click();
		Thread.sleep(5000);
		
		WebElement sjedisteKompanije=webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(4) > a"));
		sjedisteKompanije.click();
		Thread.sleep(5000);
		
		WebElement kontaktirajteNas=webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(3) > a"));
		kontaktirajteNas.click();
		Thread.sleep(5000);
		
		WebElement posaljite=webDriver.findElement(By.cssSelector("#sbbContactFormSendBtn"));
		posaljite.click();
		Thread.sleep(5000);
		
		
		
		
		WebElement ImeiPrezime = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(3) > div > input"));
		ImeiPrezime.sendKeys("Test Tester");
		Thread.sleep(3000);
		
		WebElement Email = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(4) > div:nth-child(1) > input"));
		Email.sendKeys("test.tester@gmail.com");
		Thread.sleep(3000);
		
		WebElement Telefon = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(4) > div:nth-child(2) > input"));
		Telefon.sendKeys("033 333 333");
		Thread.sleep(3000);
		
		WebElement Adresa = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(5) > div:nth-child(1) > input"));
		Adresa.sendKeys("Testna Adresa");
		Thread.sleep(3000);
		
		WebElement Postanskibroj = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(5) > div:nth-child(2) > input"));
		Postanskibroj.sendKeys("Testni Postanski Broj");
		Thread.sleep(3000);
		
		WebElement Grad = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(6) > div:nth-child(1) > input"));
		Grad.sendKeys("Testni grad");
		Thread.sleep(3000);
		
		WebElement PitanjeSeOdnosiOtvori = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(6) > div:nth-child(2) > div > div > input"));
		PitanjeSeOdnosiOtvori.click();
		Thread.sleep(5000);
		
		WebElement PrimjedbeiSugestije = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(6) > div:nth-child(2) > div > ul > li:nth-child(3)"));
		PrimjedbeiSugestije.click();
		Thread.sleep(5000);
		
		WebElement Poruka = webDriver.findElement(By.cssSelector("#contact-form-general > div:nth-child(7) > div > textarea"));
		Poruka.sendKeys("Ovo je testna poruka");
		Thread.sleep(3000);
		
		
		
		
		
		

}
	@Test
	void oNamaTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement ONamaButton = webDriver.findElement(By.cssSelector("#siteHeader > div.header-top.hidden-md-down > div > nav > ul.hd-nav-container.top-left-nav > li:nth-child(4) > a"));
		ONamaButton.click();
		Thread.sleep(5000);
		
		WebElement GodinasaVamaButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(1) > a"));
		GodinasaVamaButton.click();
		Thread.sleep(5000);
		
		WebElement ZaposlenjeButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(3) > a:nth-child(2)"));
		ZaposlenjeButton.click();
		Thread.sleep(5000);
		
		WebElement menadzmentButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(3) > a:nth-child(1)"));
		menadzmentButton.click();
		Thread.sleep(5000);
		
		WebElement procitajteVise = webDriver.findElement(By.cssSelector("#content > section.banner-about-us.about-us-margin-bottom > div > div:nth-child(1) > div.col-md-6.desc > a"));
		procitajteVise.click();
		Thread.sleep(5000);
		
		WebElement HajdiMostic = webDriver.findElement(By.cssSelector("#content > section.container.story-page-wrapper > div > div.sidebar > ul > li:nth-child(1) > a > label"));
		HajdiMostic.click();
		Thread.sleep(5000);
		
		WebElement SevalBecirevic = webDriver.findElement(By.cssSelector("#content > section.container.story-page-wrapper > div > div.sidebar > ul > li:nth-child(2) > a > label"));
		SevalBecirevic.click();
		Thread.sleep(5000);
		
		
		
}
	@Test
	void telefonijaTest() throws InterruptedException {
		
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement javniImenik = webDriver.findElement(By.cssSelector("#ft-navigation > li:nth-child(4) > ul > li > a"));
		javniImenik.click();
		Thread.sleep(5000);
		
		WebElement poslovniButton = webDriver.findElement(By.cssSelector("#myTab > li:nth-child(2) > a"));
		poslovniButton.click();
		Thread.sleep(5000);
		
		WebElement nazivPravnogLica = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(1) > input"));
		nazivPravnogLica.sendKeys("Test Tester");
		Thread.sleep(3000);
		
		WebElement paddingMenuMjesto = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(2) > div > div > input"));
		paddingMenuMjesto.click();
		Thread.sleep(5000);
		
		WebElement kiseljakMjesto = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(2) > div > ul > li:nth-child(15)"));
		kiseljakMjesto.click();
		Thread.sleep(5000);
		
		
		WebElement ulicaPravnogLica = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(3) > input"));
		ulicaPravnogLica.sendKeys("Testna Ulica");
		Thread.sleep(3000);
		
		WebElement telefonPravnogLica = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div:nth-child(4) > input"));
		telefonPravnogLica.sendKeys("033 333 333");
		Thread.sleep(3000);
		
		WebElement traziteButtonPravni = webDriver.findElement(By.cssSelector("#phonebook-app > div > form > div > div.field-wrapper.col-xs-12.col-sm-6.col-lg-6.clearfix > button"));
		traziteButtonPravni.click();
		Thread.sleep(5000);
		
		WebElement privatniButton = webDriver.findElement(By.cssSelector("#myTab > li:nth-child(1) > a"));
		privatniButton.click();
		Thread.sleep(5000);
		
		
		WebElement Ime = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(1) > input"));
		Ime.sendKeys("Test");
		Thread.sleep(3000);
		
		WebElement Prezime = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(2) > input"));
		Prezime.sendKeys("Tester");
		Thread.sleep(3000);
		
		WebElement paddingMenuzaMjesto = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(3) > div > div > input"));
		paddingMenuzaMjesto.click();
		Thread.sleep(5000);
		
		WebElement capljinaMjesto = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(3) > div > ul > li:nth-child(37)"));
		capljinaMjesto.click();
		Thread.sleep(5000);
		
		WebElement Ulica = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(4) > input"));
		Ulica.sendKeys("Testna Ulica");
		Thread.sleep(3000);
		
		WebElement Telefon = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div:nth-child(5) > input"));
		Telefon.sendKeys("033 333 333");
		Thread.sleep(3000);
		
		WebElement traziteButton = webDriver.findElement(By.cssSelector("#phonebook-private-app > div > form > div > div.field-wrapper.col-xs-12.col-sm-offset-6.col-sm-6.col-lg-offset-0.col-lg-3.clearfix > button"));
		traziteButton.click();
		Thread.sleep(5000);
		
	}
	
	@Test
	void podrskaTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement podrskaButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(5) > a"));
		podrskaButton.click();
		Thread.sleep(5000);
		
		WebElement glavniSearch = webDriver.findElement(By.cssSelector("#google-search-app > div > div > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > form > input"));
		glavniSearch.sendKeys("Test");
		Thread.sleep(3000);
		
		WebElement glavniSearchButton = webDriver.findElement(By.cssSelector("#google-search-app > div > div > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > span"));
		glavniSearchButton.click();
		Thread.sleep(5000);
		
		
		WebElement televizijaButton = webDriver.findElement(By.cssSelector("#google-search-app > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(1) > a"));
		televizijaButton.click();
		Thread.sleep(5000);
		
		WebElement searchTelevizija = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > form > input"));
		searchTelevizija.sendKeys("Test");
		Thread.sleep(3000);
		
		WebElement searchTelevizijaButton = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > span"));
		searchTelevizijaButton.click();
		Thread.sleep(5000);
		
		
		WebElement internetButton = webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.without-small-title.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(2) > a"));
		internetButton.click();
		Thread.sleep(5000);
		
		WebElement searchInternet = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > form > input"));
		searchInternet.sendKeys("Test");
		Thread.sleep(3000);
		
		WebElement searchInternetButton = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > span"));
		searchInternetButton.click();
		Thread.sleep(5000);
		
		
		WebElement telefonijaButton = webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.without-small-title.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(3) > a"));
		telefonijaButton.click();
		Thread.sleep(5000);
		
		WebElement searchTelefonija = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > form > input"));
		searchTelefonija.sendKeys("Test");
		Thread.sleep(3000);
		
		WebElement searchTelefonijaButton = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > span"));
		searchTelefonijaButton.click();
		Thread.sleep(5000);
		
		WebElement prikljucenjeButton = webDriver.findElement(By.cssSelector("#content > section.c-support-category-submenu.js-support-category-submenu.js-height-support-category-submenu.theme-bg.without-small-title.first-page-element > div > div > div.row.submenu-secondary-wrapper > div.col-md-7.menu-list-wrapper > ul > li:nth-child(4) > a"));
		prikljucenjeButton.click();
		Thread.sleep(5000);
		
		WebElement searchPrikljucenje = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > form > input"));
		searchPrikljucenje.sendKeys("Test");
		Thread.sleep(3000);
		
		WebElement searchPrikljucenjeButton = webDriver.findElement(By.cssSelector("#google-search-app > div.js-google-custom-search-form.p-google-custom-search-form.clearfix > div > span"));
		searchPrikljucenjeButton.click();
		Thread.sleep(5000);
		
		
		
		
	}
	
	@Test
	void mojTelemachTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement aplikacijeButton = webDriver.findElement(By.cssSelector("#siteHeader > div.container > div > div > nav > ul > li:nth-child(4) > a"));
		aplikacijeButton.click();
		Thread.sleep(3000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,1200)", "");
		Thread.sleep(3000);
		
		WebElement mojaTelevizijaButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[1]/a/span"));
		mojaTelevizijaButton.click();
		Thread.sleep(3000);
		
		WebElement mojInternetButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[2]/a/span"));
		mojInternetButton.click();
		Thread.sleep(3000);
		
		WebElement mojaTelefonijaButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[3]/a/span"));
		mojaTelefonijaButton.click();
		Thread.sleep(3000);
		
		WebElement mojiUredjajiButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[1]/li[4]/a/span"));
		mojiUredjajiButton.click();
		Thread.sleep(3000);
		
		WebElement mojiRacuniIuplateButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[1]/a/span"));
		mojiRacuniIuplateButton.click();
		Thread.sleep(3000);
		
		WebElement unifiButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[2]/a/span"));
		unifiButton.click();
		Thread.sleep(3000);
		
		WebElement eonButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[3]/a/span"));
		eonButton.click();
		Thread.sleep(3000);
		
		WebElement unifonButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[3]/div/div[2]/ul[2]/li[4]/a/span/span"));
		unifonButton.click();
		Thread.sleep(3000);
		
		JavascriptExecutor scroll1 = (JavascriptExecutor) webDriver;
		scroll1.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		
		WebElement aktivirajMojTelemach = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/main/section[4]/div/div/div/div[3]/a"));
		aktivirajMojTelemach.click();
		Thread.sleep(3000);
		
		WebElement korisnickoIme = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/mat-form-field[1]/div/div[1]/div/input"));
		korisnickoIme.sendKeys("test.tester@gmail.com");
		Thread.sleep(3000);
		
		WebElement lozinka = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/mat-form-field[2]/div/div[1]/div/input"));
		lozinka.sendKeys("testnalozinka");
		Thread.sleep(3000);
		
		WebElement zapamtiMe = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/mat-checkbox/label/div"));
		zapamtiMe.click();
		Thread.sleep(3000);
		
		WebElement ulogujSe = webDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/form/button"));
		ulogujSe.click();
		Thread.sleep(3000);
		
		
	}
	
	@Test
	void programskaShemaTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement EONTVButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/a"));
		EONTVButton.click();
		Thread.sleep(3000);
		
		WebElement ProgramskaShemaButton = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div/div/nav/ul/li[2]/ul/li[3]/a"));
		ProgramskaShemaButton.click();
		Thread.sleep(3000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
		scroll.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(3000);
		
		WebElement PosebnaVrstaKanala = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/div/div/input"));
		PosebnaVrstaKanala.click();
		Thread.sleep(3000);
		
		WebElement dokumentarni = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div/ul/li[2]"));
		dokumentarni.click();
		Thread.sleep(3000);
		
		WebElement search = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[2]/div[1]/div/div/div/div/div[2]/input"));
		search.sendKeys("discovery");
		Thread.sleep(3000);
		
		
		WebElement startPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[2]/a"));
		startPaket.click();
		Thread.sleep(3000);
		
		WebElement osnovniPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[3]/a"));
		osnovniPaket.click();
		Thread.sleep(3000);
		
		WebElement prosireniPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[4]/a"));
		prosireniPaket.click();
		Thread.sleep(3000);
		
		WebElement HBOpaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[5]/a"));
		HBOpaket.click();
		Thread.sleep(3000);
		
		WebElement CinemaxPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[6]/a"));
		CinemaxPaket.click();
		Thread.sleep(3000);
		
		WebElement PinkPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[7]/a"));
		PinkPaket.click();
		Thread.sleep(3000);
		
		WebElement HBOPremium = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[8]/a"));
		HBOPremium.click();
		Thread.sleep(3000);
		
		WebElement ZadrugaPaket = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[9]/a"));
		ZadrugaPaket.click();
		Thread.sleep(3000);
		
		WebElement CinestarPremiere = webDriver.findElement(By.xpath("/html/body/div[3]/main/div/form/section/div[2]/div[1]/div/ul/li[10]/a"));
		CinestarPremiere.click();
		Thread.sleep(3000);
}
}
