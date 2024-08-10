package com.work.speak.client;

import com.work.speak.dto.RequestSpeakDTO;
import com.work.speak.dto.ResponseSpeakDTO;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author linux
 */
public interface Speak {

    ResponseSpeakDTO getVoices(String apiKey) throws IOException, InterruptedException;

    InputStream textToSpeech(RequestSpeakDTO request) throws IOException, InterruptedException;

    InputStream textToSpeech(String apiKey, String voiceId, String text) throws IOException, InterruptedException;

    InputStream textToSpeech(String apiKey, String voiceId, String modelId, String text) throws IOException, InterruptedException;
}
