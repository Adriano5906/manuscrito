package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectItemManuscrito {

	public static void main(String[] args) {
		try {
			//abrir conexão com o banco
			Connection conexao = ConnectionFactory.createConnection();
			
			//Criar variavel para buscar um registro no banco
			String id;
			
			// ID irá receber o valor digitado pelo usuario
			id = JOptionPane.showInputDialog("Digite o ID do manuscrito: ");
			
			//criar o sql para extrair os dodos do banco
			String sql;
			
			sql ="select * from manuscrito where id = " + id +";";
			//linha abaixo para fazer o teste do banco de dados
			System.out.println(sql);
			
			//Preparar para receber os dados
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//Executar o comando
			ResultSet resultado = cmd.executeQuery();
			
			
			//Criar uma variavel para receber os dados
			String manuscritos;
			manuscritos = "<< Manuscritos encontrados >>\n";
			while(resultado.next()) {
				manuscritos +="ID: " + resultado.getInt("id")
				+ " - Titulo"+ resultado.getString("titulo")
				+ " - Autor:" + resultado.getString("autor")
				+"\n";
			}
			JOptionPane.showMessageDialog(null, manuscritos);
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
