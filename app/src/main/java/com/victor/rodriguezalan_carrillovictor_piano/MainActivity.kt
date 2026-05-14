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
        // Once Alan adds the IDs to the activity_main.xml, 
        // you just need to call setupKey(findViewById(R.id.YOUR_ID), R.raw.YOUR_SOUND)
        // for each piano key here.
    }

    /**
     * VICTOR DAY 2 (EXCELLENCE & MULTITOUCH): 
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
