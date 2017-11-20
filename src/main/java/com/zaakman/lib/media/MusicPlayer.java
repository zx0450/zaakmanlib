package com.zaakman.lib.media;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by ZaakMan on 2017/8/2.
 * 播放扫描音乐
 */

public class MusicPlayer {


    private static MusicPlayer sMusicPlayer = null;

    private MediaPlayer mPlayer = null;

    private int mAudioResId ;

    private Context mContext;

    private MusicPlayer(Context context){
        this.mContext = context;
    }

    public static MusicPlayer getInstance(Context context){
        if (sMusicPlayer == null){
            sMusicPlayer = new MusicPlayer(context);
        }
        return sMusicPlayer;
    }

    public MusicPlayer setAudioResId(int id){
        if (mAudioResId == id){
            return this;
        }
        this.mAudioResId = id;
        if (mPlayer != null){
            if (mPlayer.isPlaying()){
                mPlayer.stop();
                mPlayer.reset();
                mPlayer.release();
                mPlayer = null;
            }
        }
        mPlayer = MediaPlayer.create(mContext, mAudioResId);
        return this;
    }

    public void play(){
        if (mPlayer != null && mPlayer.isPlaying()){
            mPlayer.stop();
        }
        mPlayer.start();
    }

}
