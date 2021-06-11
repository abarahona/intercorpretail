project: microservice intercorpretail 

pasos para ejecutar la aplicacion:

	1) se debe crear la base de datos "db_intercorpretail" con la tabla "cliente" (a continuación el script). He usado mysql como motor de base de datos.
	
		CREATE TABLE `db_intercorpretail`.`cliente` (
		`id` INT NOT NULL AUTO_INCREMENT,
		`nombre` VARCHAR(60) NOT NULL,
		`apellido` VARCHAR(60) NOT NULL,  				
		`edad` INTEGER NOT NULL,
		`fecha_nacimiento` DATETIME NOT NULL,
		PRIMARY KEY (`id`));
		insert into db_intercorpretail.cliente values(null, 'Abel','Barahona',39,'1981-05-01');
	
	2) Usaré docker para levantar la base de datos, para ello corrí las siguientes lineas de comando en docker. 
		para bajarme mysql: 
			docker pull mysql:latest
		ahora descargamos el contenedor de mysql con el siguiente comando: 
		docker run -d -p 33060:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=admin mysql
		
		-d: Deatached Mode es la forma en que indicamos que corra en background.
		-p : puerto, el contenedor corre en el puerto 3306 pero hacemos un bind para que lo escuchemos en host el puerto 33060.
		–name : para no tener que hacer referencia al hash le asignamos un nombre.
		-e : environment le asignamos la contraseña.
	3) ya tenemos el contenedor escuchando. 
	4) podemos entrar al contenedor con el siguiente comando: 
		docker exec -it mysql-db mysql -p
		
		- exec: indicamos que vamos a pasar un comando.
		- it Modo interactivo.
		- mysql -p: es el comando para entrar a la consola de mysql con el usuario root. 
	5)  Una vez que se ejecuta la línea nos pedirá la contraseña que definimos en MYSQL_ROOT_PASSWORD y estamos dentro del contenedor y podemos lanzar comandos a MYSQl.
		Aquí podremos crear la base de datos y la tabla definida en el paso 1. 
	
	6) una vez compilado el proyecto y generado el jar del mismo mediante el comando : mvn install 
	   podremos correr el siguiente comando : java -jar target/cliente-service-intercorpretail-0.0.1-SNAPSHOT.jar
	   y tendremos nuestro servicio funcionando. Visitar el siguiente link: http://localhost:8081/swagger-ui.html
	
API Rest documentada en Swagger
Link to Swagger-ui : http://localhost:8081/swagger-ui.html
Link to Api-docs: http://localhost:8081/v2/api-docs

Endpoint de Entrada POST / creacliente:
http://localhost:8081/swagger-ui.html#/cliente-controller/crearClienteUsingPOST
{
  "apellido": "Gonzalez",
  "edad": 27,
  "fechaNacimiento": "1993-01-02",
  "nombre": "Pamela"
}
Endpoint de Salida GET / obtenerKpiClientes: 
http://localhost:8081/swagger-ui.html#/cliente-controller/obtenerKpiClientesUsingGET

Endpoint de Salida GET / obtenerListaClientesCalc
http://localhost:8081/swagger-ui.html#/cliente-controller/obtenerListaClientesCalcUsingGET


