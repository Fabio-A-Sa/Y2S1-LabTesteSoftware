package com.g801.supaplex.Model.Audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.Objects;

public class SoundPlayer {

    private Clip sound;

    private Clip loadSound(String fileName) throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/Sounds/" + fileName)).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void setSound(String fileName) {
        this.sound = loadSound(fileName);
    }

    public void playSound() {
        sound.setMicrosecondPosition(0);
        sound.start();
    }

    public void playGameWinSound() {
        this.setSound("exit-sample.wav");
        this.playSound();
    }

    public void decreaseInfotronSound() {
        this.setSound("infotron-sample.wav");
        this.playSound();
    }

    public void playFallSound() {
        this.setSound("fall-beep.wav");
        this.playSound();
    }
}