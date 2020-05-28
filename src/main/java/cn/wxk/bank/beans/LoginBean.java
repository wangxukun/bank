package cn.wxk.bank.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 7765876811740798583L;

    // Simple user databases
    private static final String[] users = {"wangzilin:123456","wangxukun:654321"};

    private String username;
    private String password;

    private boolean loggedIn;

    @Inject
    private NavigationBean navigationBean;

    /**
     * Login operation.
     * @return
     */
    public String doLogin() {
        // Get every user from our sample database :)
        for (String user: users) {
            String dbUsername = user.split(":")[0];
            String dbPassword = user.split(":")[1];

            // Successful login
            if (dbUsername.equals(username) && dbPassword.equals(password)) {
                loggedIn = true;
                return navigationBean.redirectToMain();
            }
        }

        // Set login ERROR
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        // To to login page
        return navigationBean.toLogin();
    }

    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;

        // Set logout message
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return navigationBean.toLogin();
    }

    // ------------------------------
    // Getters & Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
}
