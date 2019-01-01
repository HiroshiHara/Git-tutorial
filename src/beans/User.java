package beans;

import java.io.Serializable;

/**
 * ログインユーザのID・パスワードを保持しておく為のクラスです。
 * @author HiroshiHara
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String errorMsg;
	
	public User (String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public User (String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
