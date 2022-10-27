import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;

public class LoginTest {
	@Test
	public void loginTest() {
	try {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Class.forName("org.mariadb.jdbc.Driver");
		String DB_URL = "jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db";
		String userName = "sang";
		String password = "sang1234";

		con = DriverManager.getConnection(DB_URL, userName, password);

		// 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
		String id = request.getParameter("ID");
		String pw = request.getParameter("PWD");
		String admin = "Admin";
		String user = "User";

		//id에 해당하는 passwd 가져오기
		String sql = "SELECT USER_PW, User_NO FROM USER WHERE USER_ID=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);

		//실행  rs에 저장
		rs = pstmt.executeQuery();

		//rs에 데이터(행)가 있으면 아이디 있음
		//패스워드비교 맞으면 로그인 인증(세션값 생성 "ID")
		//패스워드비교 틀리면 "패스워드틀림" 로그인페이지로 이동
		//rs에 데이터(행)가 없으면 "아이디없음" 로그인페이지로 이동
		assertTrue(rs.next());
	}
	}
}
