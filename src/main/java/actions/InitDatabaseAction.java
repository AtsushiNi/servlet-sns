package actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class InitDatabaseAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("init DB data");
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
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
		
		return (new HomeAction()).execute(request, response);
	}
}
