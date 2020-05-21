package com.sapient.week7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    private Camera camera;
    private Screen screen;
    private Speaker speaker;

    public void checkMobile() {
        System.out.println("Mobile is initialized.");
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void makeMobile() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        camera = (Camera) context.getBean("camera");
//        screen = (Screen) context.getBean("screen");
//        speaker = (Speaker) context.getBean("speaker");
        camera.checkCamera();
        screen.checkScreen();
        speaker.checkSpeaker();
    }

    public void verifyMobile() {
        System.out.println("Mobile is verified.");
    }
}
