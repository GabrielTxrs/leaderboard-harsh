package com.harsh.leaderboard.usuario;

import com.harsh.leaderboard.JdbcManual;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("adicionar-usuario")
    public UsuarioDto adicionarUsuario(UsuarioDto usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("get-usuarios")
    public List<UsuarioDto> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("get-usuario/{id}")
    public Optional<UsuarioDto> getUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @PutMapping("alterar-usuario/{id}")
    public UsuarioDto alterarUsuarioPorId(Long id, UsuarioDto dadosUsuario) {
        UsuarioDto usuarioAtualizado = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Não há usuário com id: "+id));

        usuarioAtualizado.setIdade(dadosUsuario.getIdade());
        usuarioAtualizado.setSenha(dadosUsuario.getSenha());
        usuarioAtualizado.setPrimeiroNome(dadosUsuario.getPrimeiroNome());
        usuarioAtualizado.setSobrenome(dadosUsuario.getSobrenome());
        usuarioAtualizado.setTelefone(dadosUsuario.getTelefone());
        usuarioAtualizado.setDataNascimento(dadosUsuario.getDataNascimento());

        usuarioRepository.save(usuarioAtualizado);
        return usuarioAtualizado;
    }

    @DeleteMapping("remover-usuario/{id}")
    public String removerUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario removido com sucesso";
    }

    @DeleteMapping("remover-usuario")
    public String removerUsuario(UsuarioDto usuario) {
        usuarioRepository.delete(usuario);
        return "Usuario removido com sucesso";
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
