# Concesionario/Taller - API REST

Este repositorio alberga el proyecto centrado en un concesionario/taller. El sistema integra dos entidades principales, `Cliente` y `Vehículo`, las cuales se interconectan en una relación de uno a muchos. La aplicación utiliza una base de datos MySQL y expone sus funcionalidades a través de una API REST.

## Características Principales

- Conexión a una base de datos MySQL.
- Implementación de operaciones CRUD para gestionar `Cliente` y `Vehículo`.
- Relación uno a muchos entre `Cliente` y `Vehículo`.
- Exposición de endpoints para interactuar con las entidades.

## Inicio Rápido

1. **Clonar el repositorio:**
  
   ```git clone https://github.com/xxx.git```
   
3. **Acceder al directorio del proyecto**
  ```cd xxx```


# Entidades

1. **Cliente**: Representa a una persona o entidad que posee uno o más vehículos.
2. **Vehículo**: Representa a un coche, moto u otro vehículo motorizado, que pertenece a un Cliente específico.


# Servicio Cliente

A partir de una tabla que contiene los campos:  xxxx  se crean los siguientes recursos

# Servicio Vehiculo

A partir de una tabla que contiene los campos:  xxxx  se crean los siguientes recursos

# Funcionalidades
1. **Listar todos los clientes**
2. **Buscar clientes por Id**
3. **Buscar clientes por apellido**

## Endpoints 

### Clientes

1. **Listar todos los clientes**
   - **URL**: `/cliente`
   - **Método**: `GET`

2. **Buscar cliente por ID**
   - **URL**: `/cliente/{id}`
   - **Método**: `GET`

3. **Buscar clientes por apellido**
   - **URL**: `/cliente/detalle/{apellido}`
   - **Método**: `GET`



### Vehículos

1. **Listar todos los vehículos**
   - **URL**: `/vehiculo`
   - **Método**: `GET`

2. **Buscar vehículo por ID**
   - **URL**: `/vehiculo/{id}`
   - **Método**: `GET`

3. **Buscar propietario del vehículo por ID del vehículo**
   - **URL**: `/vehiculo/propietario/{id}`
   - **Método**: `GET`

4. **Buscar vehículo por matrícula**
   - **URL**: `/vehiculo/detalle/matricula/{matricula}`
   - **Método**: `GET`





 
  


   
