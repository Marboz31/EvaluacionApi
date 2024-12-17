
  Feature: PetStore API

    @consulta
    Scenario: Consulta mascota

      Given la url es "https://petstore.swagger.io/v2"
      When consulto la mascota con ID "1"
      Then valido el código de respuesta sea 200
      And valido el nombre de la mascota sea "555"

      @crear_mascota
      Scenario: Crear mascota

        Given la url es "https://petstore.swagger.io/v2"
        When creo la mascota "Rocky" con ID "10"
        Then valido el código de respuesta sea 200