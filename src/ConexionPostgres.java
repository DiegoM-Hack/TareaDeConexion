import java.sql.*;
public class ConnexionPostgres {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/usuario";
        String user = "postgres";
        String password = "1234";
        String query = "select * from personas"; // VER TABLA
        try (Connection conector = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = conector.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            System.out.println("Conectado con exito!!!!!!!!!");
            while (resultado.next()) {
                int codigo = resultado.getInt("id");
                String identificacion = resultado.getString("identificacion");
                String nombre = resultado.getString("nombres");
                String apellido = resultado.getString("apellidos");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                String direccion = resultado.getString("direccion");
                System.out.println("Codigo: " + codigo);
                System.out.println("Identificacion: " + identificacion);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Telefono: " + telefono);
                System.out.println("Correo: " + correo);
                System.out.println("Direccion: " + direccion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
