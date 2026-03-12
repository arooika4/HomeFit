# HomeFit
## App Fitness - Registro de Rutinas

### 1. Descripción del proyecto
Breve explicación de la aplicación.

### 2. Wireframe inicial
Imagen o explicación del flujo por consola.

### 3. Modelo de datos
#### RUTINA
int id_rutina (PK)

String nombre

#### EJERCICIO
int id_ejercicio (PK)

String nombre

String descripcion

String referencia

int id_rutina (FK)

#### SESION
int id_sesion (PK)

Date fecha

#### REGISTRO_EJERCICIO
int id_registro (PK)

int tiempo

int nivel

String referencia

int id_sesion (FK)

int id_ejercicio (FK)

### 4. Arquitectura
Explicación del patrón DAO usado.

### 5. Tecnologías utilizadas
- Java
- NetBeans
- Back4App (Parse)
- GitHub

### 6. Estructura del proyecto

### 7. Funcionamiento por consola

### 8. Conexión con Back4App

### 9. Instrucciones para ejecutar el proyecto
