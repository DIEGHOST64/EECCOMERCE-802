package com.ecommerce.auth.infraestructura.entry_points;

import com.ecommerce.auth.aplicacion.config.LoginRequestDTO;
import com.ecommerce.auth.aplicacion.config.LoginResponseDTO;
import com.ecommerce.auth.domain.model.Usuario;
import com.ecommerce.auth.domain.usecase.UsuarioUseCase;
import com.ecommerce.auth.infraestructura.driver_adapters.jpa_repository.UsuarioData;
import com.ecommerce.auth.infraestructura.mapper.MapperUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecommerce/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;
    private final MapperUsuario mapperUsuario;

    @PostMapping("/save")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody UsuarioData usuarioData) {
        Usuario usuario = mapperUsuario.toUsuario(usuarioData);
        Usuario usuarioValidadoGuardado = usuarioUseCase.guardarUsuario(usuario);

        if(usuarioValidadoGuardado.getId() != null){
            return new ResponseEntity<>(usuarioValidadoGuardado, HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioValidadoGuardado, HttpStatus.CONFLICT);
    }

    // ⭐ NUEVO ENDPOINT DE LOGIN
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            Usuario usuario = usuarioUseCase.login(loginRequest.getEmail(), loginRequest.getPassword());

            LoginResponseDTO response = new LoginResponseDTO();
            response.setId(usuario.getId());
            response.setEmail(usuario.getEmail());
            response.setNombre(usuario.getNombre());
            response.setRole(usuario.getRole());
            response.setMensaje("Login exitoso");

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            LoginResponseDTO response = new LoginResponseDTO();
            response.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findByIdusuario(@PathVariable Long id){
        Usuario usuarioValidadoGuardado = usuarioUseCase.buscarPorIdUsuario(id);
        if (usuarioValidadoGuardado != null){
            return new ResponseEntity<>(usuarioValidadoGuardado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

        // Endpoint para verificar si el usuario existe (para microservicio catálogo)
        @GetMapping("/{id}/existe")
        public ResponseEntity<Boolean> usuarioExiste(@PathVariable Long id) {
            boolean existe = usuarioUseCase.buscarPorIdUsuario(id) != null;
            return ResponseEntity.ok(existe);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioUseCase.eliminarPorIdUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody UsuarioData usuarioData) {
        try{
            // Validar que el ID venga
            if (usuarioData.getId() == null) {
                return ResponseEntity.badRequest().build();
            }
            Usuario usuario = mapperUsuario.toUsuario(usuarioData);
            Usuario usuarioValidadoActualizado = usuarioUseCase.actualizarUsuario(usuario);
            return new ResponseEntity<>(usuarioValidadoActualizado, HttpStatus.OK);
        }catch (Exception error) {
            return ResponseEntity.notFound().build();
        }
    }
}