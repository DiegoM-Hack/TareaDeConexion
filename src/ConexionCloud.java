import java.sql.*;
public class ConexionCloud {

    public static void main(String[] args) {

        String url = "jdbc:mysql://uh0g1dmvpttfzqgy:ayvunG7TPyzES6tzkKEN@bky82g6qfh9n6w50rkaf-mysql.services.clever-cloud.com:3306/bky82g6qfh9n6w50rkaf";
        String user = "uh0g1dmvpttfzqgy";
        String pass = "ayvunG7TPyzES6tzkKEN";
        String query = "SELECT * FROM personas";

        try{
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion establecida");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);

        }



    }

}
