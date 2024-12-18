package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStoreStep {

    Response response;
    private String URL_BASE;


    public void definirURL(String url) {

        URL_BASE = url;
    }

    public void creoOrden(String id, String idMascota, String cantidad) {
        String body ="{\n" +
                "  \"id\":" + id +",\n" +
                "  \"petId\":" + idMascota + ",\n" +
                "  \"quantity\":" + cantidad + ",\n" +
                "  \"shipDate\": \"2024-12-17T23:01:18.702Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";

        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void validacionRespuesta(int statusCode) {
        Assert.assertEquals("validacion de respuesta", 200, response.statusCode());
    }


    public void consultoOrden(String orderId) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .log().all()
                .get("/store/order/"+orderId)
                .then()
                .log().all()
                .extract().response();
        ;
    }


}
