package fabricas;

import encriptacion.InterfaceEncriptar;
import java.util.Properties;
import utilidades.UtilidadesAcceso;

/**
 * Fábrica para crear implementaciones de encriptación.
 * @author Eliana
 */
public class FabricaEncriptacion {

    // 1. Apuntamos a nuestro nuevo archivo de propiedades
    private static final String ENCRYPTION_FACTORY_PROPERTY_URL = "Propiedades/ConfiguracionEncriptacion.properties";

    // 2. Definimos el nombre de la propiedad que queremos leer
    private static final String DEFAULT_ENCRYPTION_CLASS_PROP = "defaultEncryptionClass";

    /**
     * Obtiene el encriptador por defecto definido en el archivo .properties.
     */
    public static InterfaceEncriptar getDefaultEncriptador() {
        try {
            Properties prop = UtilidadesAcceso.loadProperty(ENCRYPTION_FACTORY_PROPERTY_URL);

            // Leemos el nombre de la clase del archivo
            String defaultEncryptionClass = prop.getProperty(DEFAULT_ENCRYPTION_CLASS_PROP);

            System.out.println("DefaultEncryptionClass ==> " + defaultEncryptionClass);

            // Usamos reflexión para crear una instancia de esa clase
            return (InterfaceEncriptar) Class.forName(defaultEncryptionClass).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}