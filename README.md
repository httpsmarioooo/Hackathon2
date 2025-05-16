# Agenda Telefónica 📱

Este proyecto consiste en un sistema para gestionar una agenda telefónica con las siguientes características y reglas:

---
## 💡 Proceso de implementacion diseño & referencias visuales

Se organizó el equipo para llevar un buen flujo de trabajo el cual fue el siguiente:

1. Creación y organización carpetas proyecto.
2. Asignación de tareas por medio de trello. 
3. Realización del código (main, clases, metodos)
4. Prueba y funcionalidad por consola
5. Investigación de interfaces.
6. Selección de interfaz.
7. Creación visual.
8. Prueba de funcionalidad. 

## Diseño🎨

Inspirados por los celulares clásicos tipo **Nokia**, decidimos simular una interfaz gráfica retro usando **JavaFX Scene Builder**, integrando una imagen como fondo para recrear la experiencia visual de un teléfono antiguo.

Aquí algunas imágenes que usamos como referencia para la UI:


| Fase                                   | Imagen                                                                                                                                    |
|----------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| 🖼️ Imagen inicial de referencia       | <img src="https://s0.smartresize.com/wallpaper/892/584/HD-wallpaper-nokia-black-cell-phone-menu-mobile-numbers-pnone.jpg" width="100px"/> |
| 📟 Diseño tipo Nokia clásico           | <img src="https://i.pinimg.com/736x/15/e8/c5/15e8c56a7aca78ed0348cd2497544a38.jpg" width="150px"/>                                        |
| 📱 Versión final usada creacion propia | <img src="https://i.pinimg.com/736x/15/e8/c5/15e8c56a7aca78ed0348cd2497544a38.jpg" width="150px"/>                                        |


## PROYECTO: 

## 📝Definición de Contacto 
-  Un contacto está definido por:
  -  Nombre
  -  Apellido
  - Teléfono (no se valida el formato del teléfono)
  
- Dos contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar mayúsculas o minúsculas.

## 📝Agenda de Contactos 
- La agenda está formada por un conjunto de contactos.
- Se puede crear la agenda de dos formas:
  - Indicando el tamaño máximo de contactos.
  - Usando un tamaño por defecto de 10 contactos.

## ⚠️Validaciones 
- Los nombres y apellidos no pueden estar vacíos.
- No se permite añadir contactos duplicados (contactos con el mismo nombre y apellido).

## 🔣 Herramientas y Funcionalidades 

Se crea un menú por consola para probar todas las funcionalidades de la agenda telefónica:

### 👤añadirContacto(Contacto c) 
- Añade un contacto a la agenda.
- Si no hay espacio suficiente, se indica al usuario que la agenda está llena.
- Antes de añadir el contacto, se verifica que no exista ya (contactos con el mismo nombre y apellido se consideran duplicados).
- No se puede añadir un contacto si el nombre o apellido están vacíos.

### ✅existeContacto(Contacto c) 
- Verifica si un contacto ya existe en la agenda.
- Los contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar el teléfono.

### 🎈listarContactos() 
- Muestra todos los contactos en el formato: `Nombre Apellido - Teléfono`.
- Ordena los contactos alfabéticamente por nombre y apellido antes de mostrarlos.

### ✅buscaContacto(String nombre) 
- Permite buscar un contacto por nombre y apellido.
- Si el contacto existe, muestra el teléfono.
- Si no existe, muestra un mensaje indicando que no se ha encontrado.

### ❌eliminarContacto(Contacto c) 
- Elimina un contacto de la agenda.
- Muestra un mensaje indicando si la eliminación fue exitosa o no.
- Si se intenta eliminar un contacto que no existe, se indica al usuario.

### 🎈modificarTelefono(String nombre, String apellido, String nuevoTelefono) 
- Permite modificar el teléfono de un contacto existente.
- Si el contacto no existe, muestra un mensaje.

### 📵agendaLlena() 
- Indica si la agenda está llena.
- Muestra un mensaje indicando que no hay espacio disponible para nuevos contactos.

### ⭕espacioLibres() 
- Muestra cuántos contactos más se pueden agregar a la agenda.
- Esto se basa en el tamaño máximo definido al crear la agenda.

---
## 🛠️ Tecnologías Usadas
- Java 
- JavaFX
- IntelliJ IDEA
- Git & GitHub
- Adobe Ilustrator

---

## 👥 Colaboradores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/httpsmarioooo">
        <img src="https://avatars.githubusercontent.com/u/111519152?v=4" width="80px;" alt=""/>
        <br /><sub><b>Carlos Torres</b></sub>
      </a>
    </td>
  </tr>
--
<tr>
    <td align="center">
      <a href="https://github.com/Angela0697">
        <img src="https://avatars.githubusercontent.com/u/200633499?v=4" width="80px;" alt=""/>
        <br /><sub><b>Angela Laverde</b></sub>
      </a>
    </td>
  </tr>
--
<tr>
    <td align="center">
      <a href="https://github.com/Anderzon-1989">
        <img src="https://avatars.githubusercontent.com/u/204398340?v=4" width="80px;" alt=""/>
        <br /><sub><b>Richard Chavez</b></sub>
      </a>
    </td>
  </tr>
--
<tr>
    <td align="center">
      <a href="https://github.com/VeronicaCardenasR">
        <img src="https://avatars.githubusercontent.com/u/204398198?v=4" width="80px;" alt=""/>
        <br /><sub><b>Veronica Cardenas</b></sub>
      </a>
    </td>
  </tr>
</table>