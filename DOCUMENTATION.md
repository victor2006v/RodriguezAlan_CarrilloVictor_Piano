# Proyecto Piano - Documentación Técnica

Este documento detalla el cumplimiento de los criterios de evaluación establecidos para el desarrollo de la aplicación de piano.

## 1. Interfaz Gráfica (UI)
- **Diseño y Estética:** La interfaz utiliza una distribución proporcional y estética de las teclas blancas y negras, emulando un piano real. Se ha implementado un fondo oscuro (`#1E1E1E`) para resaltar los elementos interactivos.
- **Estados Visuales:** Se utilizan selectores de estado para proporcionar retroalimentación visual inmediata al usuario. Las teclas blancas cambian a un gris claro (`#D9D9D9`) y las negras a un gris oscuro (`#333333`) al ser presionadas.

## 2. Reproducción de Sonido
- **Tecnología:** Se utiliza la clase `SoundPool` de Android, la cual está optimizada para la reproducción de sonidos cortos con baja latencia, ideal para instrumentos musicales.
- **Precisión:** Cada tecla está vinculada a su recurso de audio correspondiente (`.ogg`), garantizando que se reproduzca el sonido correcto sin retrasos perceptibles.
- **Control de Audio:** Se ha implementado la funcionalidad para detener el sonido inmediatamente al soltar la tecla, mejorando el realismo de la ejecución.

## 3. Manejo de Eventos Táctiles
- **Eventos:** Se utiliza `MotionEvent` con soporte para `ACTION_DOWN`, `ACTION_POINTER_DOWN`, `ACTION_UP`, `ACTION_POINTER_UP` y `ACTION_CANCEL`.
- **Fluidez:** La interacción es fluida y permite una ejecución rápida de notas sucesivas sin perder la detección de las pulsaciones.

## 4. Accesibilidad y Buenas Prácticas
- **Compatibilidad:** En el `OnTouchListener`, se invoca explícitamente `v.performClick()` al detectar una pulsación. Esto garantiza la compatibilidad con servicios de accesibilidad como TalkBack.
- **Código Limpio:** El código es modular y fácil de mantener. La lógica de sonido está encapsulada en un objeto `SoundManager`, separando la gestión del audio de la lógica de la interfaz.

## 5. Uso de StateListDrawable
- **Implementación:** Se han creado archivos XML de tipo `<selector>` (`white_key_selector.xml` y `black_key_selector.xml`) para gestionar los cambios de apariencia de las teclas de forma declarativa.
- **Optimización:** El uso de `StateListDrawable` permite que el sistema Android gestione los cambios de estado visual de manera eficiente sin intervención manual en el código Kotlin.

## 6. Estructura del Código y Optimización
- **Modularidad:** La función `setupKey()` centraliza la configuración de cada tecla, evitando la duplicación de código y facilitando la inicialización masiva de los 24 componentes de la interfaz.
- **Gestión de Recursos:** Los sonidos se cargan una sola vez durante el inicio de la aplicación y se liberan correctamente en el método `onDestroy()` de la actividad principal para evitar fugas de memoria.

## 7. Multitouch
- **Soporte:** La aplicación soporta multitouch nativamente, permitiendo al usuario tocar acordes o varias teclas simultáneamente.
- **Independencia:** Cada flujo de toque se gestiona de forma independiente, asegurando que la liberación de una tecla no afecte la reproducción de otra que aún se mantenga presionada.
