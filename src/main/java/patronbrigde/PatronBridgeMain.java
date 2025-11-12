package patronbrigde;

import encriptacion.InterfaceEncriptar;
import fabricas.FabricaEncriptacion;
import implementacion.PuenteMensajeEncriptacion;
import implementacion.InterfaceMensajeEncriptacion;

public class PatronBridgeMain {

    public static void main(String[] args) {

        // 1. Le pedimos a la fábrica que cree la implementación
        InterfaceEncriptar implementacionDefault = FabricaEncriptacion.getDefaultEncriptador();

        // 2. Construimos el Bridge usando la implementación que nos dio la fábrica.
        InterfaceMensajeEncriptacion formatoConfigurado = new PuenteMensajeEncriptacion(implementacionDefault);

        try {

            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String messageCifrado = formatoConfigurado.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Mensaje Cifrado (desde config) > " + messageCifrado + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}