package RunnerClasses;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/featureFiles",
	    glue = "stepDefinations", 
	    monochrome = true,
	    plugin = {"html:test-output/HtmlReport/CucumberReport.html",
	    			"rerun:target/FailedTestcases.txt"},
	    tags="@Regressiontest"
	)
public class TestRunner extends AbstractTestNGCucumberTests {

	  	@Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	
}

