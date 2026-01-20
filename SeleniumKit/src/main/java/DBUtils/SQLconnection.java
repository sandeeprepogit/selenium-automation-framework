package DBUtils;

import java.sql.*;


public class SQLconnection {

    public SQLconnection() throws SQLException {
        String url = "";
        String userName = "";
        String password= "";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("query");

        while (rs.next()){
            String query ="SELECT name FROM emp_table WHERE salary > 600000";
            System.out.println("Result::"+rs);
        }

    }
}
