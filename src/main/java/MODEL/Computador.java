package MODEL;

public class Computador {
    private int IDPC;
    public static String marca = "Rafael Goulart";
    private String HD;
    private String processador;

    public Computador() {
    }

    public Computador(String marca, String HD, String processador) {
        this.marca = marca;
        this.HD = HD;
        this.processador = processador;
    }

    public int getIDPC() {
        return IDPC;
    }

    public void setIDPC(int IDPC) {
        this.IDPC = IDPC;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Computador.marca = marca;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }
}