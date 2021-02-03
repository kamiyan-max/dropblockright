package com.light.dropblockright;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int hitSound;


    public SoundPlayer(Context context) {

        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        hitSound = soundPool.load(context, R.raw.b, 1);

    }

    public void DestroySound() {
        soundPool.play(hitSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }


}

