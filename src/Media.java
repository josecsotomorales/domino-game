/*
 *@author:Jose Carlos Soto
 */

import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

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
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(dirSonido));
                clip.start();

            } else if (TipoSonido == 2) {
                InputStream dirSonido = Media.class.getResourceAsStream("audio/S2.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(dirSonido));
                clip.start();
            }
            Thread.sleep(1);
        } catch (IOException io) {
        } catch (InterruptedException ie) {
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}

