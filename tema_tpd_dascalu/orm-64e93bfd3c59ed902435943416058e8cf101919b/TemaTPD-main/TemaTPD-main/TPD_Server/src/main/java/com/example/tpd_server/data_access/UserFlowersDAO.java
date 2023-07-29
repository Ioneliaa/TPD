package com.example.tpd_server.data_access;

import com.example.tpd_server.models.Flowers;
import com.example.tpd_server.models.UserFlowers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserFlowersDAO {

    public static ArrayList<UserFlowers> getAll() {
        ArrayList<UserFlowers> result = new ArrayList<>();

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM public.\"UserFlowers\"")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(new UserFlowers(resultSet.getInt(1),
                        resultSet.getInt(2)));
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static List<Flowers> getFlowersForUser(int userId){
        List<UserFlowers> ownedFlowers = UserFlowersDAO.getAll().stream().filter(userFlowers -> userFlowers.getUserId() == userId).collect(Collectors.toList());
        List<Flowers> flowers = new ArrayList<>();
        for(UserFlowers userFlowers : ownedFlowers){
            flowers.add(FlowersDAO.get(userFlowers.getFlowersId()));
        }

        return flowers;
    }

    public static void add(UserFlowers userFlowers) {
        if (userFlowers == null) {
            return;
        }

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO public.\"UserFlowers\"(\n" +
                     "\t\"userId\", \"flowersId\")\n" +
                     "\tVALUES (?, ?);")) {

            preparedStatement.setInt(1, userFlowers.getUserId());
            preparedStatement.setInt(2, userFlowers.getFlowersId());

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int userId, int flowersId) {

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM public.\"UserFlowers\" WHERE \"userId\" = ? AND \"flowersId\" = ?")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, flowersId);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
