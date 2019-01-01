package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * このクラスはログイン認証に関わる処理ロジックを提供します。
 * @author HiroshiHara
 *
 */
public final class LoginLogic {

	private LoginLogic() {

	}
	
	/**
	 * 第一引数、第二引数に与えられたデータが、プロジェクト内に保存してあるadmin.txtの内容と一致しているか確認するメソッドです。<br/>
	 * admin.txtにはCSV形式でID、パスワードの順にデータが保存されています。
	 * 第一引数、第二引数とそれぞれが一致した場合true、そうでない場合falseを返します。
	 * @param id ログインID
	 * @param password ログインパスワード
	 * @param path 設定ファイルのパス
	 * @return ログイン認証に成功した場合true, 失敗した場合false
	 */
	public static boolean loginAuthentication(String id, String password, String path) {

		// txt.ファイルより管理者ID, パスワードを取得
		String adminId = null;
		String adminPass = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));) {
			Properties properties = new Properties();
			properties.load(br);
			adminId = properties.getProperty("Admin");
			adminPass = properties.getProperty("Password");
			
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("ログイン認証用のデータが見つかりませんでした。指定のファイルパスを確認してください", e);
		} catch (IOException e) {
			throw new AssertionError("ログイン認証用のデータの読み込みに失敗しました。", e);
		}
		
		// 引数id, passwordがそれぞれtxt.ファイルより取得したデータと一致しているか確認
		if (id.equals(adminId) && password.equals(adminPass)) {
			return true;
		}
		return false;
	}
}
