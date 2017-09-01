package 영화관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import 설정.데이터설정;

public class 영화DAO {

	public 영화DAO() {

	}

	public void 저장하다(영화 새영화) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		String sql = String.format("insert into 영화 (제목,부제,감독,주연,개봉일,장르_번호) values('%s', %s, '%s', '%s', '%s', %d)",
				새영화.get제목(), (새영화.get부제() != null) ? "'" + 새영화.get부제() + "'" : null, 새영화.get감독(), 새영화.get주연(),
				 df.format(새영화.get개봉일()),
				//새영화.get개봉(),
				새영화.get장르_번호());// 새영화.get장르().get이름();
		System.out.println(sql);
		// 영화 개봉일 date => sql 날짜 포맷 String
		try {
			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);

			Statement st = con.createStatement();

			st.executeUpdate(sql);
			System.out.println(con + "연결");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
