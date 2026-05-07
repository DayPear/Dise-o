package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Kaleb
 */
public class ConexionMongo {

    private static final String URL = "mongodb://localhost:27017";

    private static final String BASE_DATOS = "potro_eventos";

    public static MongoClient cliente;

    public static final MongoClient obtenerCliente() {
        if (cliente == null) {
            //Proovedor pojos
            CodecProvider proovedorPojo = PojoCodecProvider.builder()
                    .automatic(true)
                    .build();

            //almacen codecs
            CodecRegistry registroCodecs = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(proovedorPojo));

            MongoClientSettings configuracionMongo = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(URL))
                    .codecRegistry(registroCodecs)
                    .build();

            cliente = MongoClients.create(configuracionMongo);
        }

        return cliente;
    }

    public static MongoDatabase obtenerBaseDatos() {
        return obtenerCliente().getDatabase(BASE_DATOS);
    }

}
