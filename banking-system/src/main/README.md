Banking System - Proyecto en Spring Boot

Descripción del Proyecto

Este proyecto es una aplicación de banca en línea desarrollada con Java Spring Boot.
El objetivo es simular la gestión de un sistema bancario, incluyendo la creación y el manejo de cuentas, usuarios y transacciones, siguiendo las buenas prácticas de arquitectura REST y Spring JPA.

El sistema permite:

Crear y administrar diferentes tipos de cuentas bancarias (Checking, Savings, CreditCard).
Gestionar usuarios y sus roles.
Registrar y consultar transacciones.
Aplicar reglas de negocio (saldo mínimo, intereses, penalizaciones).
Probar la aplicación mediante Postman.


Estructura del proyecto

src/main/java/com/bankingsystem
=>

-  config/               # Configuración inicial, DataLoader con datos de prueba
- controllers/          # Controladores REST que exponen los endpoints
- dto/                  # Objetos de transferencia de datos (Data Transfer Objects)
- enums/                # Enumeraciones (tipos de cuentas, roles, estados, etc.)
- model/                # Entidades del sistema (User, Account, Transaction, etc.)
- repository/           # Interfaces JPA para acceder a la base de datos
- service/              # Lógica de negocio y reglas bancarias
- BankingSystemApplication.java  # Clase principal para arrancar la aplicación


Tecnologías Utilizadas

Java 17
Spring Boot 3
Spring Data JPA
Hibernate
H2 Database (para desarrollo)
Postman (para pruebas de API REST)


Proyecto realizado como ejercicio práctico de Java Spring Boot para aprender:

Arquitectura REST
Gestión de datos con JPA
Pruebas unitarias e integración