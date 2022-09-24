package pe.isil.ep1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Ep1Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Ep1Application.class, args);

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantes",
				"root",
				"");



		// 1. Listando registros con CallableStatement

			//Listando por ID

		CallableStatement callID = conexion.prepareCall("{ call LlamarPorId(?)}");
		callID.setInt(1,1);

		ResultSet resultado = callID.executeQuery();

		System.out.println("------------ Listando por ID --------------" + "\n");
		while(resultado.next())
		{
			System.out.println(resultado.getString("idRestaurante"));
			System.out.println(resultado.getString("nombre"));
			System.out.println(resultado.getString("tipo"));
			System.out.println(resultado.getString("distrito") + "\n");
		}
		System.out.println("------- Listando a todas las tablas -------" + "\n");


			//Listando a todas las tablas

		CallableStatement callTodos = conexion.prepareCall("{ call LlamarTodos()}");
		ResultSet resultado2 = callTodos.executeQuery();

		while(resultado2.next())
		{
			System.out.println(resultado2.getString("idRestaurante"));
			System.out.println(resultado2.getString("nombre"));
			System.out.println(resultado2.getString("tipo"));
			System.out.println(resultado2.getString("distrito"));
		}
		System.out.println("------------- Filas Afectadas -------------" + "\n");




		// 2. Actualizando registros con PreparedStatement

		PreparedStatement pt =
				conexion.prepareStatement("update Restaurante set nombre='Marttini', tipo='Pizzeria', distrito='Surco' where idRestaurante = ?");

		pt.setInt(1,4);

		int resultadoUdp = pt.executeUpdate();

		System.out.println("Filas Afectadas en la actualización: " + resultadoUdp + "\n");




		// 3. Eliminando registros con Statement

		Statement delete = conexion.createStatement();

		int resultDelete = delete.executeUpdate("delete from Restaurante where distrito = 'Ate'");

		System.out.println("Filas afectadas en la eliminación: " + resultDelete);

	}
}