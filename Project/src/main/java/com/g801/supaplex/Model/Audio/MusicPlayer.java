package com.g801.supaplex.Model.Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Objects;

public class MusicPlayer {

    private Clip backgroundMusic;
    private String file;

    public MusicPlayer(String fileName) {
        this.file = fileName;
        this.backgroundMusic = loadMusic(fileName);
    }

    private Clip loadMusic(String fileName) throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/Music/" + fileName)).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void startMusic() {
        backgroundMusic.setMicrosecondPosition(0);
        backgroundMusic.start();
        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
