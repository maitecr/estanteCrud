package br.com.estante.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nome usu�rio mysql
	private static final String USERNAME = "root";
	
	//Senha
	private static final String PASSWORD = "";
	
	//Path 
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/estante";
	
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz com que a classe seja carregada pela jvm
		Class.forName("com.mysql.jdbc.Driver");
		
		//Cria��o da conex�o com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception  {
		//Recuperar uma conex�o com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se conex�o � nula
		if(con != null) {
			System.out.println("Conex�o obtida");
			con.close();
		}
	}
}
