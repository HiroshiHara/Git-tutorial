package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import model.LoginLogic;

/**
 * ログイン処理に関するこコントローラを担当するサーブレットです。 doGet()ではログイン画面への遷移を行います。
 * doPost()ではログイン処理のコントロールを行います。
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * ログイン画面へ遷移するコントローラです。
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginForm.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * ログイン処理のコントローラです。 リクエストパラメータよりIDとパスワードを取得し、ログイン認証をmodel.LoginLogicへ移譲します。<br/>
	 * ログイン認証に成功した場合、管理者インスタンスを生成し、セッションスコープに保存します。
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		ServletContext context = this.getServletContext();
		String path = context.getRealPath("/WEB-INF/props/admin.properties");
		
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		if (LoginLogic.loginAuthentication(id, password, path)) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/administorator.jsp");
			
			// 管理者インスタンスをセッションスコープに保存
			User admin = new User(id, password);
			session.setAttribute("admin", admin);
		} else {
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginForm.jsp");
			
			// エラーメッセージのみを与えて管理者インスタンスを生成
			User error = new User("Authentication failed");
			session.setAttribute("error", error);
		}
		dispatcher.forward(request, response);
	}
}
