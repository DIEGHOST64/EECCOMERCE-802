package com.ecommerce.auth.domain.model.gateway;
//metodos de infraesctructura a dominio
public interface EncrypterGateway {
    String encrypt (String password);

    Boolean checkPass (String passUser, String passBD);

    String decrypt (String password);

}
