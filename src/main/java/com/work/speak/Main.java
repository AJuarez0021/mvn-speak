package com.work.speak;

import com.work.speak.client.Speak;
import com.work.speak.client.SpeakImpl;
import com.work.speak.dto.ResponseSpeakDTO;
import com.work.speak.dto.VoicesDTO;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 *
 * @author linux
 */
public class Main {

    private static final String API_KEY = "";

    public static void main(String[] args) {
        try {
            Speak speak = new SpeakImpl();
            ResponseSpeakDTO voices = speak.getVoices(API_KEY);
            Optional<VoicesDTO> voice = voices.getVoices().stream().findFirst();
            InputStream input = speak.textToSpeech(API_KEY, voice.get().getVoiceId(), "Hello");
            InputStream[] audio = copyInput(input);
            saveToFile(audio[0], "output.mp3");
            playAudio(audio[1]);
        } catch (IOException | InterruptedException | JavaLayerException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public static InputStream[] copyInput(InputStream input) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        byte[] bytes = baos.toByteArray();
        InputStream is1 = new ByteArrayInputStream(bytes);
        InputStream is2 = new ByteArrayInputStream(bytes);
        return new InputStream[]{is1, is2};
    }

    public static void playAudio(final InputStream input) throws JavaLayerException {
        AdvancedPlayer player = new AdvancedPlayer(input,
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());

        player.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackStarted(PlaybackEvent evt) {
                System.out.println("Playback started");
            }

            @Override
            public void playbackFinished(PlaybackEvent evt) {
                System.out.println("Playback finished");
            }
        });

        player.play();
    }

    public static void saveToFile(final InputStream input, String filePath) {
        try {
            if (input != null) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(filePath); 
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
                    byte[] bytes = input.readAllBytes();
                    bufferedOutputStream.write(bytes, 0, bytes.length);
                    bufferedOutputStream.flush();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

}
