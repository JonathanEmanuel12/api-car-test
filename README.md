# api-car-test
#### Api que possibilita cadastro e listagem de carros de uma api externa e guarda um log dos carros criados

#### Stack
- Java
- Spring boot
- MongoDb

#### Instruções para rodar o projeto

1. Baixar o projeto com git clone.
2. Preencher o arquivo src/main/resources/application.properties com as credenciais de um servidor MongoDb 
3. Fazer build e rodar o projeto

#### Rotas: 
- GET localhost:8080/api/listCars
- POST localhost:8080/api/createCar 
Exemplo de body: {
	"title": "Onix",
	"brand": "Chevrolet",
	"price": "30000",
	"age": 2016	
}
- GET localhost:8080/api/logs

[Link para descrição do projeto](https://drive.google.com/file/d/1ELwsX-DEsE4sGxLqsDgFezogFh4iFTxM/view?usp=sharing)

Obs: O sistema de filas não foi implementado. Nunca utilizei, mas imagino que com um pouco mais de tempo conseguiria implementar.
