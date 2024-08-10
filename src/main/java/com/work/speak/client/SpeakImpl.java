package com.work.speak.client;

import com.google.gson.Gson;
import com.work.speak.dto.RequestSpeakDTO;
import com.work.speak.dto.ResponseSpeakDTO;
import com.work.speak.dto.VoiceSettingsDTO;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 *
 * @author linux
 */
public class SpeakImpl implements Speak {

    private static final int TIMEOUT = 50; //Segundos

    private static final String URL_SPEAK = "https://api.elevenlabs.io/v1/text-to-speech/%s/stream";

    private static final String MODEL_DEFAULT = "eleven_turbo_v2";

    @Override
    public ResponseSpeakDTO getVoices(String apiKey) throws IOException, InterruptedException {
        String url = "https://api.elevenlabs.io/v1/voices";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Content-Type", "application/json")
                .header("xi-api-key", apiKey)
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), ResponseSpeakDTO.class);
    }

    @Override
    public InputStream textToSpeech(RequestSpeakDTO request) throws IOException, InterruptedException {
        String url = String.format(URL_SPEAK, request.getVoiceId());
        Gson gson = new Gson();
        String body = gson.toJson(request);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .header("xi-api-key", request.getApiKey())
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<InputStream> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofInputStream());
        InputStream response = postResponse.body();
        int status = postResponse.statusCode();
        if (!isOk(status)) {
            throw new RuntimeException("Bad Speak: " + status);
        }
        return response;
    }

    @Override
    public InputStream textToSpeech(String apiKey, String voiceId, String text) throws IOException, InterruptedException {
        return textToSpeech(apiKey, voiceId, MODEL_DEFAULT, text);
    }

    @Override
    public InputStream textToSpeech(String apiKey, String voiceId, String modelId, String text) throws IOException, InterruptedException {
        RequestSpeakDTO request = new RequestSpeakDTO();
        VoiceSettingsDTO voice = new VoiceSettingsDTO();
        voice.setSimilarityBoost(0.8f);
        voice.setStability(0.5f);
        voice.setStyle(0.0f);
        voice.setUseSpeakerBoost(Boolean.TRUE);
        request.setModelId(modelId);
        request.setApiKey(apiKey);
        request.setVoiceId(voiceId);
        request.setText(text);
        request.setVoiceSettings(voice);
        return textToSpeech(request);
    }

    private static boolean isOk(int status) {
        return status >= 200 && status <= 299;
    }
}
