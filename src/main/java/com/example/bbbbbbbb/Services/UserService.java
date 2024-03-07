package com.example.bbbbbbbb.Services;
import com.example.bbbbbbbb.entities.Utilisateur;
import com.example.bbbbbbbb.entities.groupe;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public String aff() {
        return "hello";
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sirine12");
    }

    private boolean checkCredentials(String tableName, String username, String password) throws ClassNotFoundException, SQLException {
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM PFE." + tableName)) {

            while (rs.next()) {
                System.out.println(rs.getString(3) + " " + rs.getString(4));
                if (rs.getString(3).equals(username) && rs.getString(4).equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }



    private boolean testActivation(String tableName, String username) throws ClassNotFoundException, SQLException {
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM PFE." + tableName + " WHERE EMAIL = '" + username + "'")) {

            while (rs.next()) {
                if (rs.getString(5).equals("D") ) {
                    return true;
                }
            }
        }
        return false;
    }


    ////////////////////////////////Authentification///////////////////////////
    public String authentification() throws ClassNotFoundException, SQLException {

        String username="admin";
        String password="admin";
        if (username.isEmpty()) {
            return "Enter username";
        } else if (password.isEmpty()) {
            return "Enter your password";
        } else if (checkCredentials("UTILISATEUR", username, password)) {
            if (testActivation("UTILISATEUR",username)){
                return "Votre Compte est désactiver";
            }
            else
                return "Je suis un utilisateur";
        } else if (checkCredentials("ADMIN", username, password)) {
            if (testActivation("ADMIN",username)){
                return "Votre Compte est désactiver";
            }
            else
                return "Je suis un admin";
        } else if (checkCredentials("COMMERCIAL", username, password)) {
            if (testActivation("COMMERCIAL",username)){
                return "Votre Compte est désactiver";
            }
            else
                return "Je suis un commercial";
        }
        return "Email ou mot de passe invalide";
    }

    Boolean test(String s,String tableName) throws IOException, SQLException {
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from PFE."+tableName)) {
            while (rs.next()) {
                if ((rs.getString(3).equals(s))) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }





    ///////////////////////Création Compte////////////////////////////////////////
    public String compte() throws IOException, SQLException {

        String a = "addd";
        String b = "112233";
        String c = "112233";
        String tableName = "ADMIN";
        if (a.isEmpty()) {
            return "taper l'email";
        } else if (b.isEmpty()) {
            return "taper le mot de passe";
        } else if (c.isEmpty()) {
            return "Confirmer le mot de passe";
        } else if (!(b.equals(c))) {
            return "Vérifier le mot de passe";
        } else if (test(a, tableName)) {
            return "Email existe deja choisir un autre";
        } else {
            char stat='A';
            try (Connection con = getConnection();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("INSERT INTO PFE." + tableName + "(EMAIL, PASSWORD,STATUS) VALUES ('" + a + "','" + b + "','"+stat+"')")) {
                return "création avec succés";
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }





    //////////////////////Afficher liste user////////////////////////
    public List<Utilisateur> listUsers(){
        List<Utilisateur> users=new ArrayList<>();
        String tableName="ADMIN";
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM PFE." + tableName)) {

            while (rs.next()) {
                Long id= Long.valueOf(rs.getString(1));;
                users.add(new Utilisateur(id,rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


    public String check() throws ClassNotFoundException, SQLException {

        String tableName = "ADMIN";
        String username = "admin";
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM PFE." + tableName + " WHERE EMAIL = '" + username + "'")) {
            while (rs.next()) {
                if (rs.getString(5).equals("A")) {
                    char newStatus='D';
                    int rowsUpdated = st.executeUpdate("UPDATE PFE." + tableName + " SET status = '" + newStatus + "' WHERE EMAIL ='" + username + "'");
                    if (rowsUpdated > 0) {
                        return "DESACTIVATION AVEC SUCCES";
                    } else {
                        return "Echec de la desactivation";
                    }
                } else {
                    char newStatus='A';
                    int rowsUpdated = st.executeUpdate("UPDATE PFE." + tableName + " SET status = '" + newStatus + "' WHERE EMAIL ='" + username + "'");
                    if (rowsUpdated > 0) {
                        return "ACTIVATION AVEC SUCCES";
                    } else {
                        return "Echec de l'activation";
                    }
                }
            }
        }
        return "modification avec succès";
    }




    public String update() throws ClassNotFoundException, SQLException {
        String tableName = "ADMIN";
        String newN = "admine";
        String newE = "admine";
        String newP = "admine";
        long num = 1;
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            int rowsUpdated = st.executeUpdate("UPDATE PFE." + tableName + " SET NOM = '" + newN + "', EMAIL = '" + newE + "', PASSWORD = '" + newP + "' WHERE ID ='"+num+ "'");
            return rowsUpdated > 0 ? "Modification réussie" : "Aucune modification effectuée";
        }
    }



}
