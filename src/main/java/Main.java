import java.sql.*;

public class Main {

    private static final String GET_SALARY = "SELECT DEPARTMENT, sum(SALARY) FROM employees GROUP BY DEPARTMENT";

    public static void main(String[] args) {
        new Main().getSumSalary();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/rider_soft",
                "postgres",
                "1qaz2WSX3edc");
    }

    public void getSumSalary() {

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_SALARY)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("DEPARTMENT") + ": " + rs.getString("sum"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}