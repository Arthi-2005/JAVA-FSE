package Structural.Adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "song.mp3");
        MediaAdapter adapter = new MediaAdapter();
        adapter.play("vlc", "movie.vlc");
        adapter.play("mp4", "video.mp4");
    }
}
