  @crear_consultar_orden
  Feature: PetStore

    Scenario Outline: Crear orden
      Given la url es <url>
      When creo el orden del pedido mascota con ID <ID> con PetID <idMascota> y quantity <cantidad>
      Then valido el código de respuesta sea <statusCode>
      Examples:
        | url                              | ID  | idMascota | cantidad | statusCode |
        | "https://petstore.swagger.io/v2" | "1" | "1"       | "1"      | 200        |


    Scenario Outline: Consultar orden
      Given la url es <url>
      When consulto la orden con OrderId <OrderId>
      Then valido el código de respuesta sea <statusCode>
      Examples:
        | url                              | OrderId | statusCode |
        | "https://petstore.swagger.io/v2" | "1"     | 200        |
