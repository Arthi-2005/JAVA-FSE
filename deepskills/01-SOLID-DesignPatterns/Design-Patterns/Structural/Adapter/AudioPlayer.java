package Structural.Adapter;

public class AudioPlayer implements MediaPlayer {
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3: " + fileName);
        } else {
            System.out.println("Unsupported format: " + audioType);
        }
    }
}
