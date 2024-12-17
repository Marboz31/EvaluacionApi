package com.nttdata.glue;

import com.nttdata.steps.TestStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class TestStepDef {
    @Steps
    TestStep obj;

    @Given("prueba de assertions")
    public void pruebaDeAssertions() {
        obj.metodoPrueba();

    }

    @When("pruebo un servicio url {string}")
    public void prueboUnServicioUrl(String url) {
        obj.abrirPagina(url);

    }
}
