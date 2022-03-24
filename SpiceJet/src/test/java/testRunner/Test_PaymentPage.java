package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/SpiceJet_PaymentPage.feature",glue = {"spiceJet_Steps"},
monochrome = true,
plugin = {"pretty","html:target/SpiceJet_PaymentPage/HTMLReports/reprt.html",
 "pretty","json:target/SpiceJet_PaymentPage/JSONReports/reprt.json",
 "pretty","junit:target/SpiceJet_PaymentPage/JUNITReports/reprt.xml"}
)
public class Test_PaymentPage {

}
