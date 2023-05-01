/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Main()
 */

package patronbridge;
import encriptacion.ProcesoEncriptarAES;
import encriptacion.ProcesoEncriptarCesar;
import encriptacion.ProcesoEncriptarDES;
import encriptacion.ProcesoSinEncriptar;
import implementacion.PuenteMensajeEncriptacion;
import implementacion.InterfaceMensajeEncriptacion;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronBridgeMain {

    public static void main(String[] args) {
        InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());
        InterfaceMensajeEncriptacion FormatoDES = new PuenteMensajeEncriptacion(new ProcesoEncriptarDES());
        InterfaceMensajeEncriptacion SinFormato = new PuenteMensajeEncriptacion(new ProcesoSinEncriptar());
        InterfaceMensajeEncriptacion FormatoCesar = new PuenteMensajeEncriptacion(new ProcesoEncriptarCesar(5));

        try {
            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String messageAES = FormatoAES.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Formato AES > " + messageAES + "\n");

            String messageDES = FormatoDES.EncryptarMensaje(message, "XMzDdG4D03CKm2Ix");
            System.out.println("Formato DES > " + messageDES + "\n");

            String messageNO = SinFormato.EncryptarMensaje(message, null);
            System.out.println("Sin Formato > " + messageNO + "\n");

            String messageCesar = FormatoCesar.EncryptarMensaje(message, null);
            System.out.println("Formato Cesar > " + messageCesar + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
