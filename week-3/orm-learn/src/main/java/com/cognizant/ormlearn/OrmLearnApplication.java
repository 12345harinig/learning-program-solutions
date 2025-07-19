package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockRepository stockRepository;

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);

        // 👉 Hands-on 1: Country Queries
        testGetAllCountries();
        testGetCountry();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testFindCountriesContaining();
        testFindCountriesStartingWith();
        testFindCountryByName();

        // 👉 Hands-on 2: Stock Queries
        testFacebookStocksInSep2019();
        testGoogleStocksClosePriceGT1250();
        testTop3Volume();
        testLowest3Netflix();
    }

    // 🔵 Hands-on 1: Country Queries

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Countries: {}", countries);
        LOGGER.info("End");
    }

    private static void testGetCountry() {
        LOGGER.info("Start");
        Country country = countryService.getCountry("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("JP");
        country.setName("Japan");
        countryService.addCountry(country);
        Country addedCountry = countryService.getCountry("JP");
        LOGGER.debug("Added Country: {}", addedCountry);
        LOGGER.info("End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");
        countryService.updateCountryName("JP", "Japan - Updated");
        Country updatedCountry = countryService.getCountry("JP");
        LOGGER.debug("Updated Country: {}", updatedCountry);
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("JP");
        Country deletedCountry = countryService.getCountry("JP");
        LOGGER.debug("Deleted Country: {}", deletedCountry);
        LOGGER.info("End");
    }

    private static void testFindCountriesContaining() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findCountriesContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End");
    }

    private static void testFindCountriesStartingWith() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findCountriesStartingWith("A");
        LOGGER.debug("Countries starting with 'A': {}", countries);
        LOGGER.info("End");
    }

    private static void testFindCountryByName() {
        LOGGER.info("Start");
        Country country = countryService.findCountryByName("India");
        LOGGER.debug("Country by name: {}", country);
        LOGGER.info("End");
    }

    // 🔵 Hands-on 2: Stock Queries

    private static void testFacebookStocksInSep2019() throws ParseException {
        LOGGER.info("Start");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween(
                "FB", sdf.parse("2019-09-01"), sdf.parse("2019-09-30"));
        LOGGER.debug("FB Sep 2019: {}", stocks);
        LOGGER.info("End");
    }

    private static void testGoogleStocksClosePriceGT1250() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        LOGGER.debug("GOOGL > 1250: {}", stocks);
        LOGGER.info("End");
    }

    private static void testTop3Volume() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 by volume: {}", stocks);
        LOGGER.info("End");
    }

    private static void testLowest3Netflix() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Lowest 3 NFLX: {}", stocks);
        LOGGER.info("End");
    }
}
