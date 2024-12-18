package com.nttdata.glue;

import com.nttdata.steps.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PetStoreStepDef {

    @Steps

    PetStoreStep tienda;

    @Given("la url es {string}")
    public void laUrlEs(String url) {tienda.definirURL(url);}

    @When("creo el orden del pedido mascota con ID {} con PetID {} y quantity {}")
    public void creoElOrdenDelPedidoMascotaConIDConPetIDYQuantity(String id, String idMascota, String cantidad) {
        tienda.creoOrden(id, idMascota, cantidad);
    }

    @Then("valido el código de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCode) {tienda.validacionRespuesta(statusCode);}


    @When("consulto la orden con OrderId {string}")
    public void consultoLaOrdenConOrderId(String OrderId) {
        tienda.consultoOrden(OrderId);
    }
}
