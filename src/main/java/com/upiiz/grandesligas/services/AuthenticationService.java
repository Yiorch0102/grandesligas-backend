package com.upiiz.grandesligas.services;

import com.upiiz.grandesligas.models.Usuario;
import com.upiiz.grandesligas.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(Usuario request) {
        // Crear usuario
        Usuario user = new Usuario();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // ENCRIPTAR SIEMPRE
        user.setRole("ROLE_USER"); // Rol por defecto

        usuarioRepository.save(user);

        // Devolver token inmediatamente
        return jwtService.generateToken(user);
    }

    public String authenticate(Usuario request) {
        // Esto hace la magia de verificar user y password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Si llegamos aquí, es que los datos son correctos
        Usuario user = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
        return jwtService.generateToken(user);
    }
}