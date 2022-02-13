public class ClientePrivado extends Cliente {
    private int CodigoPostal;

    // Constructor

    public ClientePrivado() {
        this.CodigoPostal = CodigoPostal;
    }

    public ClientePrivado(String nombre5, String apellidos5, String dni5, String email5, String codigoPostal5) {
        super(nombre5, apellidos5, dni5, email5);
        CodigoPostal = Integer.parseInt(codigoPostal5);
    }

    // Getters y Setters

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(int CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }


}
