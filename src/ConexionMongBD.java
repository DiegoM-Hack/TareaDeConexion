import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ConexionMongBD {
    public static void main(String[] args) {
        String uri = "mongodb+srv://diegomontaluisa:Aries1840@cluster0.1szozhu.mongodb.net/t";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Conectarse a la base de datos "test" (puede ser cualquier nombre)
            MongoDatabase database = mongoClient.getDatabase("examen");

            // Mostrar el nombre de la base de datos
            System.out.println("Nombre de la base de datos: " + database.getName());

            // Listar las colecciones dentro de la base de datos
            System.out.println("Colecciones disponibles:");
            MongoIterable<String> colecciones = database.listCollectionNames();
            for (String nombreColeccion : colecciones) {
                System.out.println(" - " + nombreColeccion);
            }

            // Elegir una colección y mostrar sus documentos (si existen)
            String coleccionEjemplo = "ejercicio11"; // cámbialo por una colección real
            if (database.listCollectionNames().into(new java.util.ArrayList<>()).contains(coleccionEjemplo)) {
                MongoCollection<Document> coleccion = database.getCollection(coleccionEjemplo);
                System.out.println("\nDocumentos en la colección '" + coleccionEjemplo + "':");
                for (Document doc : coleccion.find()) {
                    System.out.println(doc.toJson());
                }
            } else {
                System.out.println("\nLa colección '" + coleccionEjemplo + "' no existe.");
            }

        } catch (Exception e) {
            e.printStackTrace();
 }
}
}