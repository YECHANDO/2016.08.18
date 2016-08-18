import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;

public class JdbcQuerySample { public static void main(String[] args) {
	//1.데이터베이스에 접속하기
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/world","root","1234");
        System.out.println("connection ok..");

        String sql = "select name, CountryCode, District, Population from city " + 
                        "where Population > 1800000 and Population < 2000000";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String name        = rs.getString("name");
            String countryCode = rs.getString("CountryCode");
            String district    = rs.getString("District");
            String population  = rs.getString("Population");
            System.out.println(name + " " + countryCode + " " + district + " " + population);
        }

    }
    catch (SQLException se) {
        System.out.println("connection fail..");
    }
    finally {
        try {
            if (conn != null) { conn.close(); }
        }
        catch (Exception e) {}
        System.out.println("connection closed..");
    }

}
}
