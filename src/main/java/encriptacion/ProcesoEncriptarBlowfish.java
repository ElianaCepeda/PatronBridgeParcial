/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Java
 * Clase que hereda de InterfaceEncriptar y encripta el mensaje mediante el algoritmo Blowfish.
 */
package encriptacion;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ProcesoEncriptarBlowfish implements InterfaceEncriptar {

    @Override
    public String encryptar(String message, String password) throws Exception {
        // Se crea la llave a partir del password
        SecretKeySpec key = new SecretKeySpec(password.getBytes(), "Blowfish");

        // Se obtiene una instancia del cifrador para el algoritmo Blowfish
        Cipher cipher = Cipher.getInstance("Blowfish");

        // Se inicializa el cifrador en modo de encriptación con la llave generada
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Se encripta el mensaje y se codifica en Base64 para obtener un String
        byte[] encrypted = cipher.doFinal(message.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(encrypted);

        return encodedString;
    }
}