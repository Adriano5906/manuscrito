package br.com.sistema.cmd;

import java.sql.Connection;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	public static Connection createConnection() {
		String StringDeConexao = "jdbc:mysql://localhost:3306/manuscritos";
		String usuario = "root";
		String senha = "";
		
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(StringDeConexao, usuario, senha);
			JOptionPane.showMessageDialog(null, "conexao realizada!");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, " Falha na Conexao !");
		}
		return conexao;
	
	}
	
	}
