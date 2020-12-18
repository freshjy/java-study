package test.mriadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	public static void main(String[] args) {

		for (int i = 11; i <= 20; i++) {
			BookVo vo = new BookVo();
			vo.setTitle("책" + i);
			vo.setAuthor("저자" + i);
			vo.setPrice(2000 * i);

			boolean result = insert(vo);
			if (result) {
				System.out.println("성공!");
			}

		}
	}
	
	public static boolean insert(BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mysql://192.168.1.13:3307/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. SQL 준비
			String sql = "	insert" +
					 " into book" +
					 "	values(null,?,?,? )";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setInt(3, vo.getPrice());
			
			// 5. sql문 실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
