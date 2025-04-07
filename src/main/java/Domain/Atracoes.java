package Domain;

public class Atracoes {
    private int id;
    private String atracao;
    private double precoAdulto;
    private double precoCrianca;
    private int duracaoSeg;

    public Atracoes(int id, String atracao, double precoAdulto, double precoCrianca, int duracaoSeg) {
        this.id = id;
        this.atracao = atracao;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
        this.duracaoSeg = duracaoSeg;
    }

    public int getId() {
        return id;
    }

    public String getAtracao() {
        return atracao;
    }

    public double getPrecoAdulto() {
        return precoAdulto;
    }

    public double getPrecoCrianca() {
        return precoCrianca;
    }

    public int getDuracaoSeg() {
        return duracaoSeg;
    }
}
