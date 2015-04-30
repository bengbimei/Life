package com.qf.www.life.Beans;

/**
 * Created by asus on 2015/4/30.
 */
public class Scenes {
    private String sceneTitle;
    private String sceneTitleImage;
    private String sceneBackgroundImage;
    private String sceneDescription;

    public String getSceneTitle() {
        return sceneTitle;
    }

    public void setSceneTitle(String sceneTitle) {
        this.sceneTitle = sceneTitle;
    }

    public String getSceneTitleImage() {
        return sceneTitleImage;
    }

    public void setSceneTitleImage(String sceneTitleImage) {
        this.sceneTitleImage = sceneTitleImage;
    }

    public String getSceneBackgroundImage() {
        return sceneBackgroundImage;
    }

    public void setSceneBackgroundImage(String sceneBackgroundImage) {
        this.sceneBackgroundImage = sceneBackgroundImage;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }

    public void setSceneDescription(String sceneDescription) {
        this.sceneDescription = sceneDescription;
    }

    @Override
    public String toString() {
        return "Scenes{" +
                "sceneTitle='" + sceneTitle + '\'' +
                ", sceneTitleImage='" + sceneTitleImage + '\'' +
                ", sceneBackgroundImage='" + sceneBackgroundImage + '\'' +
                ", sceneDescription='" + sceneDescription + '\'' +
                '}';
    }
}
