package com.ecommerce.auth.infraestructura.Security;


import com.ecommerce.auth.domain.model.gateway.EncrypterGateway;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncrypterGatewayImpl implements EncrypterGateway {
    @Override
    public String encrypt(String password) {
        return encoder.encode(password);
    }
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public Boolean checkPass(String passUser, String passBD) {
        return encoder.matches(passUser, passBD);
    }

    @Override
    public String decrypt(String password) {
        return "";
    }
}
