package gui;

import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {

    public static void playWav(String path) {
        try {
            File file = new File(path);

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}