import java.sql.*;

public class ConexionSQL {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";

        String query = "SELECT * FROM usuarios";
        try(Connection con = DriverManager.getConnection(url, user, password)){
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("Conexion establecida");
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("password");
                System.out.println("ID: " + id+ "nombre: " + nombre + "correo: " + correo + "contrasena: " + contrasena);
            }

        }catch(Exception e){
            Exception e1 =e;
            e1.printStackTrace();
        }



    }
}
