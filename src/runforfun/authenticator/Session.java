package runforfun.authenticator;

import java.net.HttpCookie;

public class Session {
	private String mLogin;
	private String mPassword;
	private HttpCookie mCookie;
	
	public String getLogin() {
		return mLogin;
	}
	public void setLogin(String login) {
		mLogin = login;
	}
	public String getPassword() {
		return mPassword;
	}
	public void setPassword(String password) {
		mPassword = password;
	}
	public HttpCookie getCookie() {
		return mCookie;
	}
	public void setCookie(HttpCookie cookie) {
		mCookie = cookie;
	}

}
