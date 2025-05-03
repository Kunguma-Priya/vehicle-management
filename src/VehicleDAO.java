import java.sql.*;

public class VehicleDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/vehiclemanagement";
    private static final String USER = "root";
    private static final String PASSWORD = "Priya1604.";
    static {
        try {
            // Explicitly load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void saveVehicle(String type, String brand, String model, int year, int speed, int gear) {
        String sql = "INSERT INTO vehicles (type, brand, model, year, speed, gear) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            pstmt.setString(2, brand);
            pstmt.setString(3, model);
            pstmt.setInt(4, year);
            pstmt.setInt(5, speed);
            pstmt.setInt(6, gear);
            pstmt.executeUpdate();

            System.out.println(type + " added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayVehicles() {
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nVehicle List:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("type") + " " +
                        rs.getString("brand") + " " + rs.getString("model") + " (" + rs.getInt("year") + ") | Speed: " +
                        rs.getInt("speed") + " km/h | Gear: " + rs.getInt("gear"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
