# Taller 3 - Paradigma Funcional (Java)

Solución del taller de Java sobre Streams, expresiones lambda y recursividad.

## Requisitos

- JDK 17 o superior.
- Apache Maven 3.8 o superior.
- Conexión a internet la primera vez que se ejecuta Maven, para descargar JUnit y los plugins.

## Ejecutar

Abre una terminal en la carpeta donde está `pom.xml` y ejecuta:

```bash
mvn clean test
```

Para ejecutar el programa:

```bash
mvn exec:java
```

## Estructura

```text
Taller3_Paradigma_Funcional/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/java/com/udea/funcional/
    │   ├── Main.java
    │   └── FuncionesTaller.java
    └── test/java/com/udea/funcional/
        └── FuncionesTallerTest.java
```

## Ejercicios

1. **Ciudades:** `filter()` conserva las ciudades que empiezan por M; `map()` las convierte a mayúsculas; `sorted()` las ordena.
2. **Notas:** `filter()` conserva las notas >= 3.0; `map()` suma 0.2 y `Math.min()` limita el resultado a 5.0. `Main` usa `forEach()` para mostrar cada nota.
3. **Potencia:** caso base `exponente == 0`, que devuelve 1; caso recursivo `base * potencia(base, exponente - 1)`. No se utiliza `Math.pow()`.

## Git y GitHub

Desde esta carpeta, después de crear el repositorio vacío en GitHub:

```bash
git init
git add .
git commit -m "Completa taller 3 de paradigma funcional"
git branch -M main
git remote add origin URL_DE_TU_REPOSITORIO
git push -u origin main
```

Reemplaza `URL_DE_TU_REPOSITORIO` por la URL real del repositorio. No subas la carpeta `target/`; está excluida en `.gitignore`.

## Participación en el video

Una propuesta de reparto para tres integrantes está incluida en el documento `GUIA_VIDEO.md`.
