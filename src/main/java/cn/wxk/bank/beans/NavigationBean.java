package cn.wxk.bank.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    private static final long serialVersionUID = 1520318172495977648L;

    /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }

    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "/login.xhtml";
    }

    /**
     * Redirect to sign up page.
     * @return Sign up name.
     */
    public String redirectToSignUp() {
        return "/signup.xhtml?faces-redirect=true";
    }

    /**
     * Go to sign up page.
     * @return Sign up page name.
     */
    public String toSignUp() {
        return "/signup.xhtml";
    }

    /**
     * Redirect to main page.
     * @return main page name.
     */
    public String redirectToMain() {
        return "/secured/main.xhtml?faces-redirect=true";
    }

    /**
     * Go to main page.
     * @return main page name.
     */
    public String toMain() {
        return "/secured/main.xhtml";
    }
}
