package test.mriadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectTest {

	public static void main(String[] args) {
		List<BookVo> list = select();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static List<BookVo> select(){
		List<BookVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mysql://192.168.1.13:3307/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. SQL 준비
			String sql = "select no, title, author, price from book order by no desc";
			pstmt = conn.prepareStatement(sql);
			
			// 4. sql문 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 가져오기
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				Integer price = rs.getInt(4);
				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setAuthor(author);
				vo.setPrice(price);
				
				list.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if(rs != null) {
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	return list;
	}

}
