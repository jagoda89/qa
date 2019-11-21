package com.jsystems.qa.qagui.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;

@Tag("FrontTest")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",  //scenariusze testowe
        glue = "classpath:com.jsystems.qa.qagui.cucumber", //miejsce przechowywania stepsów, ktore beda wywolywane poprzez scenariusze
        plugin = {"html:target/cucumber-html-report", "rerun:target/target.txt"},
        tags = {//ktore scenariusze ma odpalać
                "@wordpress"
//                "@login",
//                "@userprofile"

        }
)
public class RunTest {


}
