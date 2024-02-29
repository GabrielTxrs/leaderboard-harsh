//package com.harsh.leaderboard.Usuario;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class UsuarioConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(UsuarioRepository repository) {
//        return args -> {
//            UsuarioDto mofuzinho = new UsuarioDto(
//                    123456,
//                    "Mofuzinho",
//                    LocalDate.of(2000, Month.JANUARY,5)
//            );
//
//            UsuarioDto mofu = new UsuarioDto(
//                    12345678,
//                    "Mofu",
//                    LocalDate.of(2000, Month.FEBRUARY,5)
//            );
//            for (UsuarioDto usuarioDto : List.of(mofu, mofuzinho)) {
//                repository.save(usuarioDto);
//            }
//        };
//    }
//}
