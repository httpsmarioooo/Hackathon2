# Agenda Telefónica

Este proyecto consiste en un sistema para gestionar una agenda telefónica con las siguientes características y reglas:

## Definición de Contacto
- Un contacto está definido por:
  - Nombre
  - Apellido
  - Teléfono (no se valida el formato del teléfono)
- Dos contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar mayúsculas o minúsculas.

## Agenda de Contactos
- La agenda está formada por un conjunto de contactos.
- Se puede crear la agenda de dos formas:
  - Indicando el tamaño máximo de contactos.
  - Usando un tamaño por defecto de 10 contactos.

## Validaciones
- Los nombres y apellidos no pueden estar vacíos.
- No se permite añadir contactos duplicados (contactos con el mismo nombre y apellido).


## Herramientas y Funcionalidades

Se crea un menú por consola para probar todas las funcionalidades de la agenda telefónica:

### añadirContacto(Contacto c)
- Añade un contacto a la agenda.
- Si no hay espacio suficiente, se indica al usuario que la agenda está llena.
- Antes de añadir el contacto, se verifica que no exista ya (contactos con el mismo nombre y apellido se consideran duplicados).
- No se puede añadir un contacto si el nombre o apellido están vacíos.

### existeContacto(Contacto c)
- Verifica si un contacto ya existe en la agenda.
- Los contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar el teléfono.

### listarContactos()
- Muestra todos los contactos en el formato: `Nombre Apellido - Teléfono`.
- Ordena los contactos alfabéticamente por nombre y apellido antes de mostrarlos.

### buscaContacto(String nombre)
- Permite buscar un contacto por nombre y apellido.
- Si el contacto existe, muestra el teléfono.
- Si no existe, muestra un mensaje indicando que no se ha encontrado.

### eliminarContacto(Contacto c)
- Elimina un contacto de la agenda.
- Muestra un mensaje indicando si la eliminación fue exitosa o no.
- Si se intenta eliminar un contacto que no existe, se indica al usuario.

### modificarTelefono(String nombre, String apellido, String nuevoTelefono)
- Permite modificar el teléfono de un contacto existente.
- Si el contacto no existe, muestra un mensaje.

### agendaLlena()
- Indica si la agenda está llena.
- Muestra un mensaje indicando que no hay espacio disponible para nuevos contactos.

### espacioLibres()
- Muestra cuántos contactos más se pueden agregar a la agenda.
- Esto se basa en el tamaño máximo definido al crear la agenda.
