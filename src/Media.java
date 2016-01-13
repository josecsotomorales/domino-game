/*
 *@author:Jose Carlos Soto
 */

import java.io.*;
import javax.swing.ImageIcon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Media {

    int TipoSonido;

    public static ImageIcon cIcon(String p) {
        java.net.URL imgURL = Media.class.getResource(p);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + p);
            return null;
        }
    }

    public void PlayAudio(int p) {
        TipoSonido = p;

        try {
            if (TipoSonido == 1) {
                InputStream dirSonido = Media.class.getResourceAsStream("audio/S1.wav");
                AudioStream as = new AudioStream(dirSonido);
                AudioPlayer.player.start(as);
            } else if (TipoSonido == 2) {
                InputStream dirSonido = Media.class.getResourceAsStream("audio/S2.wav");
                AudioStream as = new AudioStream(dirSonido);
                AudioPlayer.player.start(as);
            }
            Thread.sleep(1);
        } catch (IOException io) {
        } catch (InterruptedException ie) {
        }
    }
}

