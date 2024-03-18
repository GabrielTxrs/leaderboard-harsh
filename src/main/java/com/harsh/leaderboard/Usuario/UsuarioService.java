package com.harsh.leaderboard.Usuario;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final JdbcManual jdbcManual;

    public UsuarioService(JdbcManual jdbcManual) {
        this.jdbcManual = jdbcManual;
    }

    public List<UsuarioDto> getUsuarioBancoLocal() {
        try {
            jdbcManual.setConnection("localhost:3306", "usuario", "root", "211221");
            System.out.println("Conexao feita");
            List<UsuarioDto> usuarios = jdbcManual.select();
            jdbcManual.fecharConexao();
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<UsuarioDto> getUsuarioLeaderboard() {
        try {
            jdbcManual.setConnection("professor.cywhulnakf35.us-east-1.rds.amazonaws.com",
                    "professor", "professor", "professor");
            System.out.println("Conexao feita");
            List<UsuarioDto> usuarios = jdbcManual.select();
            jdbcManual.fecharConexao();
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String inserirUsuarioBancoLocal(UsuarioDto usuario) {
        try {
            jdbcManual.setConnection("localhost:3306", "usuario", "root", "211221");
            String sucesso = jdbcManual.insert(usuario);
            jdbcManual.fecharConexao();
            return sucesso;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Não foi possivel inserir o usuario";
    }
    public String inserirUsuarioLeaderboard(UsuarioDto usuario) {
        try {
            jdbcManual.setConnection("professor.cywhulnakf35.us-east-1.rds.amazonaws.com",
                    "professor", "professor", "professor");
            String sucesso = jdbcManual.insert(usuario);
            jdbcManual.fecharConexao();
            return sucesso;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Não foi possivel inserir o usuario";
    }


}
