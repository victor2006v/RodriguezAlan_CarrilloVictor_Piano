package com.victor.rodriguezalan_carrillovictor_piano

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool

object SoundManager {
    private val audioAttributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_GAME)
        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        .build()

    private val soundPool: SoundPool = SoundPool.Builder()
        .setMaxStreams(50)
        .setAudioAttributes(audioAttributes)
        .build()

    private val soundMap = HashMap<Int, Int>()

    /**
     * Loads all piano sounds into the SoundPool.
     * This should be called once during app initialization.
     */
    fun initSounds(context: Context) {
        val soundResources = intArrayOf(
            R.raw.a2, R.raw.a3, R.raw.b2, R.raw.b3,
            R.raw.c2, R.raw.c3, R.raw.c4, R.raw.d2, R.raw.d3,
            R.raw.e2, R.raw.e3, R.raw.f2, R.raw.f3, R.raw.g2, R.raw.g3,
            R.raw.black_a2, R.raw.black_a3, R.raw.black_c2, R.raw.black_c3,
            R.raw.black_d2, R.raw.black_d3, R.raw.black_f2, R.raw.black_f3,
            R.raw.black_g2, R.raw.black_g3
        )

        for (resId in soundResources) {
            val soundId = soundPool.load(context, resId, 1)
            soundMap[resId] = soundId
        }
    }

    /**
     * Plays a sound by its resource ID.
     */
    fun playSound(resId: Int) {
        val soundId = soundMap[resId]
        if (soundId != null) {
            soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
        }
    }

    /**
     * Releases SoundPool resources.
     */
    fun release() {
        soundPool.release()
        soundMap.clear()
    }
}
