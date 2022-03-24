package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/SpiceJet_PassengersDetail.feature",glue = {"spiceJet_Steps"},
monochrome = true,
plugin = {"pretty","html:target/SpiceJet_PassengersDetails/HTMLReports/reprt.html",
 "pretty","json:target/SpiceJet_PassengersDetails/JSONReports/reprt.json",
 "pretty","junit:target/JUNITReports/reprt.xml"}
)

public class Test_PassengersDetails {

}
