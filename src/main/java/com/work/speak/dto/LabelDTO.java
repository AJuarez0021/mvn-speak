package com.work.speak.dto;

/**
 *
 * @author linux
 */
public class LabelDTO {
    private String age;
    private String use_case;
    private String description;
    private String accent;
    private String gender;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUseCase() {
        return use_case;
    }

    public void setUseCase(String use_case) {
        this.use_case = use_case;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccent() {
        return accent;
    }

    public void setAccent(String accent) {
        this.accent = accent;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Label{" + "age=" + age + ", use_case=" + use_case + ", description=" + description + ", accent=" + accent + ", gender=" + gender + '}';
    }
    
    
    
}
