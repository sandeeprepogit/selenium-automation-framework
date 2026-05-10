package DBUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Database Connection Utility Class
*/
public class SQLconnection {

    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/automation";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Brownee@2026";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection connection;

    /**
     * Constructor - Initializes database driver
     */
    public SQLconnection() {
        try {
            Class.forName(DRIVER);
            System.out.println("MySQL Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found!");
            throw new RuntimeException("Failed to load MySQL driver", e);
        }
    }

    /**
     * Establishes database connection
     */
    public SQLconnection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connected successfully!");
        }
        return this;
    }

    /**
     * Executes SELECT query and returns all results as List of Maps
     */
    public List<Map<String, Object>> executeQuery(String query) throws SQLException {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    row.put(columnName, value);
                }
                resultList.add(row);
            }

            System.out.println("Query executed successfully! Rows fetched: " + resultList.size());

        } catch (SQLException e) {
            System.err.println("Query execution failed: " + query);
            throw e;
        }

        return resultList;
    }

    /**
     * Executes INSERT, UPDATE, DELETE queries
     */
    public int executeUpdate(String query) throws SQLException {
        int rowsAffected = 0;

        try (Statement stmt = connection.createStatement()) {
            rowsAffected = stmt.executeUpdate(query);
            System.out.println("Update executed successfully! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Update failed: " + query);
            throw e;
        }

        return rowsAffected;
    }

    /**
     * Executes parameterized query to prevent SQL injection
     */
    public List<Map<String, Object>> executePreparedQuery(String query, Object... parameters) throws SQLException {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {

            // Set parameters
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(metaData.getColumnName(i), rs.getObject(i));
                    }
                    resultList.add(row);
                }
            }

            System.out.println("Prepared query executed! Rows: " + resultList.size());

        } catch (SQLException e) {
            System.err.println("Prepared query failed: " + query);
            throw e;
        }

        return resultList;
    }

    /**
     * Executes parameterized UPDATE/INSERT/DELETE
     */
    public int executePreparedUpdate(String query, Object... parameters) throws SQLException {
        int rowsAffected = 0;

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }

            rowsAffected = pstmt.executeUpdate();
            System.out.println("Prepared update executed! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Prepared update failed: " + query);
            throw e;
        }

        return rowsAffected;
    }

    /**
     * Gets specific column value from first row
     */
    public Object getSingleValue(String query, String columnName) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getObject(columnName);
            }
            return null;

        } catch (SQLException e) {
            System.err.println("Failed to get single value: " + query);
            throw e;
        }
    }

    /**
     * Gets row count for a table
     */
    public int getRowCount(String tableName) throws SQLException {
        String query = "SELECT COUNT(*) as count FROM " + tableName;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getInt("count");
            }
            return 0;

        } catch (SQLException e) {
            System.err.println("Failed to get row count for: " + tableName);
            throw e;
        }
    }

    /**
     * Checks if a record exists
     */
    public boolean recordExists(String query) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next();
        }
    }

    /**
     * Closes the database connection
     */
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }

    /**
     * Gets the active connection object
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Checks if connection is active
     */
    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}