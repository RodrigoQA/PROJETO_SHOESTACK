package runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
         strict = true
        , features = {"src/main/resources/features/"}
        , snippets = CucumberOptions.SnippetType.CAMELCASE
        , glue = "steps"
        , monochrome = true
        , tags = ("@AddCarrinho")
       // ,plugin ="pretty"
        )

public class Runner{
    }