package sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class ProSound {

    public void button() {
        URL url = getClass().getResource("/sound/button.wav");
        AudioClip ac = Applet.newAudioClip(url);
        ac.play();
    }
    public void computererror() {
        URL url = getClass().getResource("/sound/computererror.wav");
        AudioClip ac = Applet.newAudioClip(url);
        ac.play();
    }
    public void movingtruck() {
        URL url = getClass().getResource("/sound/movingtruck.wav");
        AudioClip ac = Applet.newAudioClip(url);
        ac.play();
    }
}
