package controllers;

import config.DBConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserController {

    public boolean login(User user) {

        boolean check = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = true;
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
}