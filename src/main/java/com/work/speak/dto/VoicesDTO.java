package com.work.speak.dto;

import java.util.List;

/**
 *
 * @author linux
 */
public class VoicesDTO {

    private String voice_id;

    private String name;

    private String preview_url;

    private LabelDTO labels;
    
    private String category;

    private List<String> high_quality_base_model_ids;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public List<String> getHighQualityBaseModelIds() {
        return high_quality_base_model_ids;
    }

    public void setHighQualityBaseModelIds(List<String> high_quality_base_model_ids) {
        this.high_quality_base_model_ids = high_quality_base_model_ids;
    }

    public LabelDTO getLabels() {
        return labels;
    }

    public void setLabels(LabelDTO labels) {
        this.labels = labels;
    }

    public String getVoiceId() {
        return voice_id;
    }

    public void setVoiceId(String voice_id) {
        this.voice_id = voice_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreviewUrl() {
        return preview_url;
    }

    public void setPreviewUrl(String preview_url) {
        this.preview_url = preview_url;
    }

    @Override
    public String toString() {
        return "Voices{" + "voice_id=" + voice_id + ", name=" + name + ", preview_url=" + preview_url + ", labels=" + labels + ", high_quality_base_model_ids=" + high_quality_base_model_ids + '}';
    }

   
}
