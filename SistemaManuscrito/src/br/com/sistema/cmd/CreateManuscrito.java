package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class CreateManuscrito {

	public static void main(String[] args) {
		try {
			//importa a classe de conexão com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			//Importa a classe de transição de dados no SQL
			Manuscrito manuscrito = new Manuscrito();
			//envia o dado para a classe manuscrito()
			manuscrito.setTitulo(JOptionPane.showInputDialog("Entre com o titulo do manuscrito"));
			manuscrito.setAutor(JOptionPane.showInputDialog("Entre com o nome do autor"));
			
			//Criar o sql para inserir dados no banco
			String sql = "insert into manuscrito (titulo, autor) values (?,?)";
			
			//Criando um comando para passar o SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1,manuscrito.getTitulo());
			cmd.setString(2,manuscrito.getAutor());
			
			//Execução do comando SQL
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Manuscrito inserido com sucesso");
			
			cmd.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
