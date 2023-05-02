package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Hepsiburada;
import utilities.DriverManager;

public class HepsiburadaStepdefs {

    Hepsiburada hepsiburada = new Hepsiburada(DriverManager.getDriver());
    @Given("Hepsiburadaya girer searche tiklar")
    public void hepsiburadayaGirerSearcheTiklar() {
        hepsiburada.searchInputClick();
    }

    @And("searche {string} yazar ve arama yapar")
    public void searcheYazarVeAramaYapar(String arg0) {
    }

    @Then("gelen ilk urunun {string} oldugunu dogrular")
    public void gelenIlkUrununOldugunuDogrular(String arg0) {
    }
}