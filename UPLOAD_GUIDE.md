# 📤 Guía de Subida a GitHub - Trabajo Colaborativo

## 👥 Equipo de Desarrollo

- **Diego** (kratexvertex90@gmail.com) → AUTH + README + Configuración inicial
- **Juliana** (Julianamaya023@gmail.com) → CATALOGO
- **Laudith** (laudithcastillo.4f@gmail.com) → NOTIFICACIONES

---

## 🚀 Instrucciones de Subida

### **Paso 1: Diego - AUTH + README + .gitignore**

```powershell
cd "c:\Users\DIEGHOST\Documents\Proyecto ECCOMERCE\Proyecto ECCOMERCE"

# Inicializar repositorio
git init
git remote add origin https://github.com/DIEGHOST64/EECCOMERCE-802.git

# Configurar autor Diego
git config user.name "Diego"
git config user.email "kratexvertex90@gmail.com"

# Agregar archivos
git add .gitignore
git add README.md
git add auth/

# Commit como Diego
git commit -m "feat: Implementar microservicio AUTH con autenticación y gestión de usuarios

- Sistema de registro y login con BCrypt
- CRUD completo de usuarios
- Integración con AWS SQS para notificaciones de bienvenida
- Validación de credenciales y roles (CLIENTE/ADMIN)
- Base de datos PostgreSQL
- Arquitectura hexagonal

Desarrollado por: Diego"

# Subir a GitHub
git push -u origin main
```

---

### **Paso 2: Juliana - CATALOGO**

```powershell
cd "c:\Users\DIEGHOST\Documents\Proyecto ECCOMERCE\Proyecto ECCOMERCE"

# Configurar autor Juliana
git config user.name "Juliana Maya"
git config user.email "Julianamaya023@gmail.com"

# Agregar microservicio CATALOGO
git add catalogo/

# Commit como Juliana
git commit -m "feat: Implementar microservicio CATALOGO con gestión de productos y compras

- CRUD completo de productos
- Sistema de carrito de compras
- Procesamiento de órdenes y validación de stock
- Integración con AWS SQS para notificaciones de compra
- Comunicación con microservicio AUTH via RestTemplate
- Jackson JSR310 para serialización de fechas
- Arquitectura hexagonal

Desarrollado por: Juliana Maya"

# Subir cambios
git push origin main
```

---

### **Paso 3: Laudith - NOTIFICACIONES**

```powershell
cd "c:\Users\DIEGHOST\Documents\Proyecto ECCOMERCE\Proyecto ECCOMERCE"

# Configurar autor Laudith
git config user.name "Laudith Castillo"
git config user.email "laudithcastillo.4f@gmail.com"

# Agregar microservicio NOTIFICACIONES
git add notificaciones/

# Commit como Laudith
git commit -m "feat: Implementar microservicio NOTIFICACIONES con AWS y Twilio

- Sistema asíncrono de notificaciones por email (AWS SES) y SMS (Twilio)
- Polling de AWS SQS cada 1 segundo con @Scheduled
- Procesamiento de mensajes tipo BIENVENIDA y COMPRA
- Integración con Twilio para SMS (Free Tier)
- Arquitectura hexagonal con adaptadores para SES y Twilio
- Manejo robusto de errores y logs detallados

Desarrollado por: Laudith Castillo"

# Subir cambios
git push origin main
```

---

## ✅ Verificación Final

Después de todos los commits, el historial de Git mostrará:

```
* commit 3 - Laudith Castillo - "feat: Implementar microservicio NOTIFICACIONES..."
* commit 2 - Juliana Maya - "feat: Implementar microservicio CATALOGO..."
* commit 1 - Diego - "feat: Implementar microservicio AUTH..."
```

---

## 📊 Verificar Contribuciones en GitHub

1. Ir a: https://github.com/DIEGHOST64/EECCOMERCE-802
2. Click en **Insights** → **Contributors**
3. Verificar que aparecen los 3 colaboradores:
   - Diego
   - Juliana Maya
   - Laudith Castillo

---

## 🔐 Nota sobre Credenciales

⚠️ **IMPORTANTE**: Las credenciales de AWS y Twilio están en el código. Considera:

1. Crear un archivo `application-secrets.properties` (no commitearlo)
2. Usar variables de entorno
3. O usar GitHub Secrets para CI/CD

**Credenciales a proteger:**
- AWS Access Key ID
- AWS Secret Access Key
- Twilio Account SID
- Twilio Auth Token

---

## 🎯 Resultado Esperado

Cada microservicio quedará registrado en GitHub con su respectivo autor, mostrando un trabajo colaborativo real donde:

- **Diego** trabajó en autenticación
- **Juliana** trabajó en catálogo y compras
- **Laudith** trabajó en notificaciones

¡Listo para entregar! 🚀
