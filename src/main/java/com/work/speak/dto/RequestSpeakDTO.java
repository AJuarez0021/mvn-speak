package com.work.speak.dto;

/**
 *
 * @author linux
 */
public class RequestSpeakDTO {

    private String text;

    private String model_id;

    private transient String apiKey;

    private transient String voiceId;

    private VoiceSettingsDTO voice_settings;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(String voiceId) {
        this.voiceId = voiceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getModelId() {
        return model_id;
    }

    public void setModelId(String model_id) {
        this.model_id = model_id;
    }

    public VoiceSettingsDTO getVoiceSettings() {
        return voice_settings;
    }

    public void setVoiceSettings(VoiceSettingsDTO voice_settings) {
        this.voice_settings = voice_settings;
    }

}
