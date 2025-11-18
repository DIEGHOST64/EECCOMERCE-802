package com.ecommerce.auth.infraestructura.driver_adapters.jpa_repository;

import com.ecommerce.auth.domain.model.Usuario;
import com.ecommerce.auth.domain.model.gateway.UsuarioGateway;
import com.ecommerce.auth.infraestructura.mapper.MapperUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;

@Repository // Consultas a la BD
@RequiredArgsConstructor
public class UsuarioDataGatewayImpl implements UsuarioGateway {

    private final MapperUsuario mapperUsuario;
    private final UsuarioDataJpaRepository repository;
    private final ModelMapper modelMapper; // ✅ Inyectado desde MapperConfig (@Bean)

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioData usuarioData = mapperUsuario.toUsuarioData(usuario);
        return mapperUsuario.toUsuario(repository.save(usuarioData));
    }

    @Override
    public void eliminarPorID(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario buscarPorID(Long id){
        var usuarioData = repository.findById(id).get();
        return mapperUsuario.toUsuario(usuarioData);
    }

    @Override
    public Usuario actualizarUsario(Usuario usuario) {
        UsuarioData usuarioExistente = repository.findById(usuario.getId()).orElseThrow(() -> new RuntimeException("Usuario con id " + usuario.getId() + " no existe"));

        UsuarioData usuarioNuevo = mapperUsuario.toUsuarioData(usuario);

        modelMapper.map(usuarioNuevo, usuarioExistente);

        if (usuario.getPassword() != null && usuario.getPassword().isEmpty()) {
            UsuarioData original = repository.findById(usuario.getId()).get();
            usuarioExistente.setPassword(original.getPassword());
        }

        return mapperUsuario.toUsuario(repository.save(usuarioExistente));
    }

    //para login
    @Override
    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email)
                .map(mapperUsuario::toUsuario)
                .orElse(null);
    }
}