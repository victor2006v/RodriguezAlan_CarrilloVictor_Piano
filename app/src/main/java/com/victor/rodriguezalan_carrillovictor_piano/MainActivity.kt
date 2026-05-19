package com.victor.rodriguezalan_carrillovictor_piano

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // VICTOR DAY 1: Initialize the sound engine
        SoundManager.initSounds(this)

        // VICTOR DAY 2: Linking UI to Logic
        // WHITE KEYS - OCTAVE 1
        setupKey(findViewById(R.id.keyC1), R.raw.c2)
        setupKey(findViewById(R.id.keyD1), R.raw.d2)
        setupKey(findViewById(R.id.keyE1), R.raw.e2)
        setupKey(findViewById(R.id.keyF1), R.raw.f2)
        setupKey(findViewById(R.id.keyG1), R.raw.g2)
        setupKey(findViewById(R.id.keyA1), R.raw.a2)
        setupKey(findViewById(R.id.keyB1), R.raw.b2)

        // WHITE KEYS - OCTAVE 2
        setupKey(findViewById(R.id.keyC2), R.raw.c3)
        setupKey(findViewById(R.id.keyD2), R.raw.d3)
        setupKey(findViewById(R.id.keyE2), R.raw.e3)
        setupKey(findViewById(R.id.keyF2), R.raw.f3)
        setupKey(findViewById(R.id.keyG2), R.raw.g3)
        setupKey(findViewById(R.id.keyA2), R.raw.a3)
        setupKey(findViewById(R.id.keyB2), R.raw.b3)

        // BLACK KEYS - OCTAVE 1
        setupKey(findViewById(R.id.keyCs1), R.raw.black_c2)
        setupKey(findViewById(R.id.keyDs1), R.raw.black_d2)
        setupKey(findViewById(R.id.keyFs1), R.raw.black_f2)
        setupKey(findViewById(R.id.keyGs1), R.raw.black_g2)
        setupKey(findViewById(R.id.keyAs1), R.raw.black_a2)

        // BLACK KEYS - OCTAVE 2
        setupKey(findViewById(R.id.keyCs2), R.raw.black_c3)
        setupKey(findViewById(R.id.keyDs2), R.raw.black_d3)
        setupKey(findViewById(R.id.keyFs2), R.raw.black_f3)
        setupKey(findViewById(R.id.keyGs2), R.raw.black_g3)
        setupKey(findViewById(R.id.keyAs2), R.raw.black_a3)
    }

    /**
     * VICTOR DAY 2 MULTITOUCH:
     * Centralized key initialization that handles sound triggering,
     * visual press states, and accessibility requirements.
     */
    @SuppressLint("ClickableViewAccessibility")
    private fun setupKey(view: View?, soundId: Int) {
        view?.setOnTouchListener { v, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                    SoundManager.playSound(soundId)
                    v.isPressed = true // Triggers visual feedback
                    v.performClick()   // Compliance with accessibility standards
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_CANCEL -> {
                    SoundManager.stopSound(soundId)
                    v.isPressed = false
                }
            }
            true // Consumes the event to allow simultaneous touches on different views
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Prevents memory leaks by releasing SoundPool resources
        SoundManager.release()
    }
}
