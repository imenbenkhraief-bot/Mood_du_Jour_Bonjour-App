package com.example.mdjb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MoodDAO {

    public static boolean saveRecord(String date, String sleep, String water, String food, String activity, String energy, String note) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO daily_wellnesss (date, sleep_status, water_status, food_status, activity_status, energy_status, note) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, date);
            pst.setString(2, sleep);
            pst.setString(3, water);
            pst.setString(4, food);
            pst.setString(5, activity);
            pst.setString(6, energy);
            pst.setString(7, note);

            int result = pst.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<String[]> getAllRecords() {
        List<String[]> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT date, (sleep_status + water_status + food_status + activity_status + energy_status)/5.0 as moyenne, note FROM daily_wellnesss ORDER BY date DESC";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("date"),
                        String.valueOf(Math.round(rs.getFloat("moyenne"))),
                        rs.getString("note")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}