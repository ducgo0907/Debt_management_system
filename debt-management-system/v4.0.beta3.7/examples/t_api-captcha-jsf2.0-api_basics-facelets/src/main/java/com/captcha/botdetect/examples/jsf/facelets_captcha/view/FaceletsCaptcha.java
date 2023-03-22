package com.captcha.botdetect.examples.jsf.facelets_captcha.view;

import com.captcha.botdetect.web.jsf.JsfCaptcha;
import com.captcha.botdetect.web.servlet.Captcha;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="jsfFaceletsCaptchaExample")
@RequestScoped
public class FaceletsCaptcha {

    private String captchaCode;
    private JsfCaptcha captcha;
    private boolean correctLabelVisible, incorrectLabelVisible;

    public FaceletsCaptcha() {
    }

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public JsfCaptcha getCaptcha() {
        return captcha;
    }

    public void setCaptcha(JsfCaptcha captcha) {
        this.captcha = captcha;
    }

    public boolean isCorrectLabelVisible() {
        return correctLabelVisible;
    }

    public boolean isIncorrectLabelVisible() {
        return incorrectLabelVisible;
    }

    public void validate(){
        // validate the Captcha to check we're not dealing with a bot
        boolean isHuman = captcha.validate(captchaCode);
        if (isHuman) {
            correctLabelVisible = true;
            incorrectLabelVisible = false;
        } else {
            correctLabelVisible = false;
            incorrectLabelVisible = true;
        }
        this.captchaCode = "";
    }
    
    
    public String getLibInfo() {
        return Captcha.getLibInfo();
    }
    
    public boolean isFree() {
        return Captcha.isFree();
    }
}

