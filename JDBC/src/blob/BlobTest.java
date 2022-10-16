package blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import bean.User;
import util.JDBCUtil;

/**
 * 操作Blob类型的数据
 * 
 * @author shizhiang
 *
 */
public class BlobTest {
	@Test
	public void testBlobInset() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into `users` (name, email, birth, photo) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "Trump");
			ps.setObject(2, "trump@gmail.com");
			ps.setObject(3, "1964-2-12");
			FileInputStream is = new FileInputStream(new File("house-of-the-dragon-button-02-1645217002655.jpg"));
			ps.setBlob(4, is);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps);
		}
	}
	
	@Test
	public void testBlobQuery() throws Exception {
		InputStream is = null;
		FileOutputStream os = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select id, name, email, photo, birth from `users` where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 3);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				User user = new User(id, name, email, birth);
				System.out.println(user);
				
				// 将Blob保存为本地文件
				Blob photo = rs.getBlob("photo");
				is = photo.getBinaryStream();
				os = new FileOutputStream("house of dragons.jpg");
				byte[] buffer = new byte[1024];
				int len;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
			} else {
				System.out.println("no such user");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null)
				is.close();
			if (os != null)
				os.close();
			
			JDBCUtil.closeResource(conn, ps, rs);
		}
	}
}
