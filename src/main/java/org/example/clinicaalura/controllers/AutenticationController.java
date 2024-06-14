package org.example.clinicaalura.controllers;

import lombok.AllArgsConstructor;
import org.example.clinicaalura.domain.Usuario;
import org.example.clinicaalura.dto.login.JwtDTO;
import org.example.clinicaalura.dto.login.LoginDTO;
import org.example.clinicaalura.services.implement.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @PostMapping
    public ResponseEntity<JwtDTO> autenticarUsuario(@RequestBody LoginDTO loginDTO){
        Authentication token = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());
        authenticationManager.authenticate(token); //verifico si el usuario está autenticado
        var usuario = authenticationManager.authenticate(token); //obtengo el usuario autenticado
        var jwtToken = jwtService.generateJWT((Usuario) usuario.getPrincipal()); //paso el usuario como parametro para obtener el token JWT
        return ResponseEntity.ok(new JwtDTO(jwtToken));
    }

}
