package org.example.clinicaalura.services.implement;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.example.clinicaalura.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public class JWTService {



    public String generateJWT(Usuario usuario){
        String token;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secretsecretsecretsecretsecret");
            token = JWT.create()
                    .withIssuer("clinica-alura")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
        return token;
    }
}
