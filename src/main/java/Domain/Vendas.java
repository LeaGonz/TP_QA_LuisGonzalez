package Domain;

public class Vendas {
    private int idAtracao;
    private String data;
    private String client;

    public Vendas(int idAtracao, String data, String client) {
        this.idAtracao = idAtracao;
        this.data = data;
        this.client = client;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public String getData() {
        return data;
    }

    public String getClient() {
        return client;
    }
}
