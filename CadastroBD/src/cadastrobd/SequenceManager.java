/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;

/**
 *
 * @author Misael
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SequenceManager {
    public int getValue(String sequenceName) {
        int nextVal = 0;
        String sql = "SELECT NEXT VALUE FOR " + sequenceName;
        try (Connection conn = ConectorBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                nextVal = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return nextVal;
    }
}
