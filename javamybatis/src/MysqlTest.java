import java.sql.*;

public class MysqlTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.连接到数据"库"上去
            conn = DriverManager.getConnection("jdbc:mysql://10.255.255.224:3306/javadb?characterEncoding=utf-8", "root", "123");
            //3.构建SQL命令
            stmt = conn.createStatement();
            stmt.execute("use javadb");
            ResultSet rs = stmt.executeQuery("SELECT  * from tb_users");
            //position result to first
            rs.first();
            System.out.println(rs.getString(2)); //result is "Hello World!"
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
