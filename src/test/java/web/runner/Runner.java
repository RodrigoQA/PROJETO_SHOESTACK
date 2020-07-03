package web.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
         strict = true
        ,features = {"./src/test/resources/features"}
        ,snippets = SnippetType.CAMELCASE
        ,glue = {"web/steps/"}
        ,monochrome = true
        ,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
        ,tags = {"@realizarBusca, @AddCarrinho"}


        )

public class Runner{


    }