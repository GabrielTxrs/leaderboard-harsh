package com.harsh.leaderboard.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

@RestController
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JdbcManual jdbcManual;


    @GetMapping
    public void getUsuario() {
        try {
            jdbcManual.setConnection();
            System.out.println("Conexao feita");
            jdbcManual.select();

            jdbcManual.insert(new UsuarioDto(5l,"55555", "abcd", LocalDate.of(2000, Month.MARCH,12)));

            jdbcManual.select();

            jdbcManual.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @GetMapping
//    public List<UsuarioDto> getUsuario() {
//        return usuarioService.getUsuarios();
//    }

//    @PostMapping
//    public void addUsuario(@RequestBody UsuarioDto usuario) {
//        usuarioService.addUsuario(usuario);
//    }
}
