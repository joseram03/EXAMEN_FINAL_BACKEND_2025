# 🛠️ Sistema de Taller Mecánico – Backend en Java EE

Este proyecto consiste en una aplicación backend minimalista para gestionar servicios realizados en un taller mecánico. Fue desarrollado como trabajo práctico para la materia **Programación Web - Backend**, utilizando exclusivamente tecnologías **Java EE puras**, con integración a una base de datos PostgreSQL y exposición de servicios RESTful.

---

## 🔧 Tecnologías utilizadas

- **Java EE** (JPA, EJB 3, JAX-RS)
- **Servidor de aplicaciones**: Wildfly
- **Base de datos**: PostgreSQL
- **ORM**: JPA con Hibernate
- **Gestor de proyecto**: Maven
- **Frontend**: HTML, CSS y JavaScript puro

---

## 📚 Funcionalidad principal

### Backend:
- Registro de clientes, vehículos, mecánicos y repuestos.
- Registro de servicios realizados a vehículos, con detalles asociados:
  - Descripción del trabajo
  - Costo
  - Repuestos utilizados
  - Mecánicos involucrados
- Consulta de servicios, con opción de ver sus detalles completos.

### Frontend:
- Formulario para registrar servicios (`registrar.html`)
- Vista para consultar servicios registrados (`consultar.html`)

---

## 🚀 Cómo ejecutar el proyecto

1. Crear la base de datos PostgreSQL (por ejemplo, `taller`)
2. Configurar el datasource en Wildfly (`java:jboss/datasources/taller`)
3. Ejecutar:
   ```bash
   mvn clean install
   ```
4. Desplegar el archivo `target/taller.war` en Wildfly
5. Acceder a:
   - `http://localhost:8080/taller/registrar.html`
   - `http://localhost:8080/taller/consultar.html`

---

## 📝 Notas adicionales

- El sistema utiliza `hibernate.hbm2ddl.auto=create`, por lo que las tablas se recrean al reiniciar.
- Para registrar servicios, es necesario precargar previamente clientes, vehículos, repuestos y mecánicos.

---

## ✍️ Autor

- José Ramírez Duré
