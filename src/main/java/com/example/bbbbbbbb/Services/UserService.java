package com.example.bbbbbbbb.Services;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserService {
    public String aff(){
        return "hello";
    }

    Boolean user(String a,String b) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Sirine12");

        Statement st=con.createStatement();

        String query="select * from PFE.UTILISATEUR";

        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString(3)+" "+rs.getString(4));
            if ((rs.getString(3).equals(a) && ((rs.getString(4).equals(b)))))
            {
                return true;
            }
        }
        rs.close();
        st.close();
        con.close();
        return false;
    }

    Boolean admin(String a,String b) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Sirine12");

        Statement st=con.createStatement();

        String query="select * from PFE.ADMIN";

        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString(3)+" "+rs.getString(4));
            if ((rs.getString(3).equals(a) && ((rs.getString(4).equals(b)))))
            {
                return true;
            }
        }
        rs.close();
        st.close();
        con.close();
        return false;
    }
    Boolean commercial(String a,String b) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");

        Statement st=con.createStatement();

        String query="select * from PFE.COMMERCIAL";

        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString(3)+" "+rs.getString(4));
            if ((rs.getString(3).equals(a) && ((rs.getString(4).equals(b)))))
            {
                return true;
            }
        }
        rs.close();
        st.close();
        con.close();
        return false;
    }
    public String authentification() throws IOException, ClassNotFoundException, SQLException {

        String username="user";
        String password="user";
        if (username.isEmpty())
        {
            return "Entrer username";
        }
        else if (password.isEmpty())
        {
            return"Entrer votre mot de passe";
        }
        else if(user(username,password)) {

            return"je suis un utilisateur";

        }
        else if(admin(username,password)) {

            return"je suis un admin";
        }
        else if(commercial(username,password)) {

            return"je suis un commercial";
        }
        return"email ou mot de passe invalide";
    }

}