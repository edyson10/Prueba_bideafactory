# Prueba_bideafactory

Prueba Bideafactory realizada en Spring Boot.

Para probar solo clone el repositorio luego en su Gestor de Base de Datos crea una base de datos llamada reserva e importa la base de datos reserva.sql.

Luego mediante postman o alguna herramienta para probar los servicios rest escriba la siguiente URL localhost:8080/reserva/book con la petición http POST y en el cuerpo pone esto:

{
    "id":"14564089",
    "name":"Gonzalo",
    "lastname":"Perez",
    "age": 33,
    "phoneNumber":"56988123222",
    "startDate":"2022-03-04",
    "endDate":"2022-03-04",
    "houseId":"213132",
    "discountCode":"D0542A23"
}

Y si quiere probar todas las excepciones, puedes quitar el "houseId" o el "discountCode" para que le arroje algunas excepciones de que no puede guardar. 


