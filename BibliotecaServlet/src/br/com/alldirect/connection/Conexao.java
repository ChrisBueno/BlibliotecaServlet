package br.com.alldirect.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConnection() {

		Connection conexao = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String banco = "biblioteca";
			String url = "jdbc:mysql://192.68.0.200:3306/"+banco;
			String usr = "aluno";
			String pswd = "123456";
			conexao = DriverManager.getConnection(url, usr, pswd);
			return conexao;

		} catch (SQLException e) {
			System.out.println("Não foi possível se conectar ao Banco" + e);
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("Class for name.");
			e.printStackTrace();
		}
		return conexao;

	}

}
