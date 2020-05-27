package cn.wxk.bank.beans;

import javax.enterprise.context.SessionScoped;
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


}
