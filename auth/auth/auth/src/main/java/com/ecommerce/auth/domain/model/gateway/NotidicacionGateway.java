package com.ecommerce.auth.domain.model.gateway;

import com. ecommerce.auth.domain.model.Notificacion;

public interface NotidicacionGateway {

    void enviarNotificacion(Notificacion mensajeJson);
    
}
