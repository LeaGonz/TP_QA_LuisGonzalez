package Domain;

public class Custos {
    private int idAtracao;
    private double manutencaoBilhete;
    private double fixoMes;

    public Custos(int idAtracao, double manutencaoBilhete, double fixoMes) {
        this.idAtracao = idAtracao;
        this.manutencaoBilhete = manutencaoBilhete;
        this.fixoMes = fixoMes;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public double getManutencaoBilhete() {
        return manutencaoBilhete;
    }

    public double getFixoMes() {
        return fixoMes;
    }
}
