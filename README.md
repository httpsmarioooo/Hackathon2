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
