package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class UpdateManuscrito {

	public static void main(String[] args) {
		try {
			//abri conexao com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//Importa a classe de transição de dados no SQL
			Manuscrito manuscrito = new Manuscrito();
			
			//envia o dado para a classe manuscrito()
			manuscrito.setId(JOptionPane.showInputDialog("Entre com o Id a ser alterado"));
			manuscrito.setTitulo(JOptionPane.showInputDialog("Entre com o titulo do manuscrito"));
			manuscrito.setAutor(JOptionPane.showInputDialog("Entre com o nome do autor"));
			
			String sql = "update manuscrito set titulo = ?, autor = ? Where id = ?;"; 
			
			//update manuscrito set 
			//titulo = 'manuscrito.getTitulo()' and
			//autor = 'manuscrito.getAutor()'
			//where where id = 'manuscrito. getId()';
			
			//system.out.println(sql);
			
			//Criando um comando para passar o sql
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, manuscrito.getTitulo());
			cmd.setString(2, manuscrito.getAutor());
			cmd.setString(3, manuscrito.getId());
			
			cmd.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "dado atualizado com sucesso!");
			
			cmd.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
