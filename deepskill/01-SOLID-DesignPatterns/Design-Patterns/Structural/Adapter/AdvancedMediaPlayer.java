package Structural.Adapter;

public class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc: " + fileName);
    }
    public void playMp4(String fileName) {
        System.out.println("Playing mp4: " + fileName);
    }
}
