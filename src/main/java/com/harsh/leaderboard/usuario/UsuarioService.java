package com.harsh.leaderboard.usuario;

import com.harsh.leaderboard.JdbcManual;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final JdbcManual jdbcManual;
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(JdbcManual jdbcManual, UsuarioRepository usuarioRepository) {
        this.jdbcManual = jdbcManual;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario alterarUsuarioPorId(Long id, Usuario dadosUsuario) {
        Usuario usuarioAtualizado = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Não há usuário com id: "+id));

        usuarioAtualizado.setIdade(dadosUsuario.getIdade());
        usuarioAtualizado.setSenha(dadosUsuario.getSenha());
        usuarioAtualizado.setPrimeiroNome(dadosUsuario.getPrimeiroNome());
        usuarioAtualizado.setSobrenome(dadosUsuario.getSobrenome());
        usuarioAtualizado.setTelefone(dadosUsuario.getTelefone());
        usuarioAtualizado.setDataNascimento(dadosUsuario.getDataNascimento());

        usuarioRepository.save(usuarioAtualizado);
        return usuarioAtualizado;
    }

    public String removerUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario removido com sucesso";
    }

    public String removerUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
        return "Usuario removido com sucesso";
    }


    public List<Usuario> getUsuarioBancoLocal() {
        try {
            jdbcManual.setConnection("localhost:3306", "usuario", "root", "211221");
            System.out.println("Conexao feita");
            List<Usuario> usuarios = jdbcManual.select();
            jdbcManual.fecharConexao();
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> getUsuarioLeaderboard() {
        try {
            jdbcManual.setConnection("professor.cywhulnakf35.us-east-1.rds.amazonaws.com",
                    "professor", "professor", "professor");
            System.out.println("Conexao feita");
            List<Usuario> usuarios = jdbcManual.select();
            jdbcManual.fecharConexao();
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String inserirUsuarioBancoLocal(Usuario usuario) {
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

    public String inserirUsuarioLeaderboard(Usuario usuario) {
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
