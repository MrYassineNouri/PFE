package com.example.bbbbbbbb.Services;

import com.example.bbbbbbbb.entities.groupe;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class GroupService {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "SYSTEM");
    }

    public List<groupe> listGroupes() {
        List<groupe> groupes = new ArrayList<>();
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM PFE.GROUPE" )) {

            while (rs.next()) {
                Long id = Long.valueOf(rs.getString(1));
                ;
                groupes.add(new groupe(id, rs.getString(2)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return groupes;
    }

    public String newGroupe() throws IOException, SQLException {

        String a = "sssss";
        if (a.isEmpty()) {
            return "taper le nom du groupe";
        } else {
            try (Connection con = getConnection();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("INSERT INTO PFE.GROUPE(NOM) VALUES ('" + a + "')")) {
                return "création avec succés";
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public String modif() throws ClassNotFoundException, SQLException {
        String newN = "admine";
        long num = 1;
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            int rowsUpdated = st.executeUpdate("UPDATE PFE.GROUPE SET NOM = '"+newN+"' WHERE ID ='"+num+ "'");
            return rowsUpdated > 0 ? "Modification réussie" : "Aucune modification effectuée";
        }
    }
}
