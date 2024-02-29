package com.harsh.leaderboard.Usuario;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;

@Service
public class JdbcManual {
    private Connection connection;

    public JdbcManual() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setConnection() throws SQLException {
        String host = "localhost:3306";
        String db = "usuario";
        String url = "jdbc:mysql://"+host+"/"+db;
        String user = "root";
        String senha = "211221";
        connection = DriverManager.getConnection(url, user, senha);
    }
    public void select() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM USUARIO_DTO";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String id = String.valueOf(rs.getInt("id"));
            String cpf = rs.getString("cpf");
            String nome = rs.getString("nome");
            Date data = rs.getDate("data_nascimento");
            System.out.print(id+" "+cpf+" "+nome+" "+data+"\n");
        }
        statement.close();
    }
    public void insert(UsuarioDto usuario) throws SQLException {
        Statement statement = connection.createStatement();
        Long id = usuario.getId();
        String cpf = usuario.getCpf();
        String nome = usuario.getNome();
        LocalDate data = usuario.getDataNascimento();

        String sql = "INSERT INTO USUARIO_DTO (ID, CPF, NOME, DATA_NASCIMENTO) VALUES ("+id+",\'"+cpf+"\',\'"+nome+"\',DATE(\'"+data+"\'))";
        System.out.println(sql);
        System.out.println(statement.execute(sql));
        statement.close();
    }
    public void fecharConexao() throws SQLException{
        connection.close();
    }
}
