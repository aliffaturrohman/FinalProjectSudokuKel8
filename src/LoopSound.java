/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2023/2024
 * Group Capstone Project
 * Group #8
 * 1 - 5026221040 - Alif Faturrohman
 * 2 - 5026221104- Muhamad Arif Satriyo
 * 3 - 5026221132 - Zikrul Khalis
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

class LoopSound {

    private Clip clip;
    AudioInputStream sound;


    public LoopSound(String musicFilePath) throws Exception {
            File file = new File(musicFilePath);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }

    public void play() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        clip.close();
    }
}