package com.work.speak.dto;

import java.util.List;

/**
 *
 * @author linux
 */
public class ResponseSpeakDTO {

    private List<VoicesDTO> voices;

    public List<VoicesDTO> getVoices() {
        return voices;
    }

    public void setVoices(List<VoicesDTO> voices) {
        this.voices = voices;
    }

}
