# 🎹 Piano App Development Roadmap

**Team:** Alan & Victor  
**Duration:** 2 Days  
**Goal:** Achieve "Excelente" (9-10 pts) according to the grading rubric.

---

## 📅 Day 1: Foundation & Asset Design
*Goal: Build the engine and the "Skin" of the piano.*

### **Alan (UI & Design Expert)**
- **09:00 - 11:00 | Visual Assets:** 
    - Design `white_key_selector.xml` and `black_key_selector.xml` in `res/drawable`.
    - Use `<selector>` with `state_pressed="true"` for visual feedback.
- **11:00 - 13:00 | Landscape Layout:** 
    - Configure `AndroidManifest.xml` for landscape orientation.
    - Update `activity_main.xml` with a `ConstraintLayout` to align white keys and overlay black keys proportionally.
- **14:00 - 17:00 | UI Integration:** 
    - Apply selectors to piano keys.
    - Ensure aesthetic and proportional distribution.

### **Victor (Logic & Audio Architect)**
- **09:00 - 11:00 | Sound Sourcing:** 
    - Gather short, high-quality `.ogg` or `.wav` samples for at least one full octave.
    - Add to `app/src/main/res/raw`.
- **11:00 - 13:00 | Audio Engine:** 
    - Create `SoundManager.kt`.
    - Initialize `SoundPool` with `AudioAttributes` (USAGE_GAME) for low-latency.
- **14:00 - 17:00 | Sound Loading:** 
    - Implement async loading.
    - Map resource IDs to `SoundPool` IDs for efficient playback.

---

## 📅 Day 2: Interaction, Multitouch & Excellence
*Goal: Real instrument feel and rubric compliance.*

### **Alan (Interaction & Accessibility)**
- **09:00 - 12:00 | Advanced Touch Handling:** 
    - Implement `OnTouchListener`.
    - Use `MotionEvent.ACTION_DOWN` to play sound and `ACTION_UP` for release.
- **12:00 - 13:00 | Accessibility & Standards:** 
    - Implement `view.performClick()` for screen readers.
    - Ensure "Código limpio y modular."
- **14:00 - 16:00 | Visual Refinement:** 
    - Polish UI with shadows and rounded corners.
    - Finalize "Beautiful" aesthetics.

### **Victor (Multitouch & Optimization)**
- **09:00 - 12:00 | Multitouch Logic:** 
    - Ensure simultaneous key presses trigger multiple sounds.
    - Handle `ACTION_POINTER_DOWN` and `ACTION_POINTER_UP`.
- **12:00 - 13:00 | Code Structure:** 
    - Implement `setupKey(view, soundId)` to centralize key initialization.
    - Eliminate code duplication.
- **14:00 - 16:00 | Latency Tuning:** 
    - Rigorous testing to ensure "sin latencia."
    - Verify `SoundPool` lifecycle management.

---

## 🏆 Rubric Checklist (Targeting "Excelente")

| Criterion | Target Requirement |
| :--- | :--- |
| **Interfaz gráfica (UI)** | Proportional, aesthetic, and uses `StateListDrawable`. |
| **Reproducción de sonido** | Use `SoundPool` for low latency and multitouch. |
| **Manejo de eventos** | Correct use of `ACTION_DOWN` and `ACTION_UP`. |
| **Accesibilidad** | Use `performClick()` and maintain clean/modular code. |
| **StateListDrawable** | Visual changes on press/release via selectors. |
| **Estructura y optimización** | Use `setupKey()` and efficient sound loading. |
| **Multitouch** | Support multiple keys pressed at once. |
