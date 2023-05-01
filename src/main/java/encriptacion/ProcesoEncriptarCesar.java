package encriptacion;

public class ProcesoEncriptarCesar implements InterfaceEncriptar{
    private int desplazamiento;

    public ProcesoEncriptarCesar(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    @Override
    public String encryptar(String message, String password) throws Exception {
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char caracter = message.charAt(i);
            if (Character.isLetter(caracter)) {
                char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
                caracter = (char) (((caracter + desplazamiento - inicio) % 26) + inicio);
            }

            cifrado.append(caracter);
        }
        return cifrado.toString();
    }
}
