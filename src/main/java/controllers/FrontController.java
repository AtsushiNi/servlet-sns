package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import actions.Action;

@WebServlet(urlPatterns = {"*.action"})
public class FrontController extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("init DB data");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("/sql/init.sql");
		Connection connection = null;
		
		try {
//			SQLファイルの読み込み
			File file = new File(path);
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String sql = "";
			String data;
			while((data = bufferedReader.readLine()) != null) {
				sql = sql + data;
			}
		
//			データ初期化SQLの実行
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/login");
			connection = ds.getConnection();
			Statement statement = connection.createStatement();
			statement.execute(sql);

			bufferedReader.close();
			statement.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
			}
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			String path = request.getServletPath().substring(5);
			String name = "actions." + path.replace(".action", "Action").replace('/', '.');
			Action action = (Action)Class.forName(name).getDeclaredConstructor(null).newInstance();
			String url = action.execute(request, response);
			request.getRequestDispatcher(url).forward(request, response);
		} catch(Exception e) {
			e.printStackTrace(out);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
