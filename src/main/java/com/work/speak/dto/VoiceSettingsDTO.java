package com.work.speak.dto;

/**
 *
 * @author linux
 */
public class VoiceSettingsDTO {

    private float stability;
    private float similarity_boost;
    private float style;
    private Boolean use_speaker_boost;

    public float getStability() {
        return stability;
    }

    public void setStability(float stability) {
        this.stability = stability;
    }

    public float getSimilarityBoost() {
        return similarity_boost;
    }

    public void setSimilarityBoost(float similarity_boost) {
        this.similarity_boost = similarity_boost;
    }

    public float getStyle() {
        return style;
    }

    public void setStyle(float style) {
        this.style = style;
    }

    public Boolean getUseSpeakerBoost() {
        return use_speaker_boost;
    }

    public void setUseSpeakerBoost(Boolean use_speaker_boost) {
        this.use_speaker_boost = use_speaker_boost;
    }

}
