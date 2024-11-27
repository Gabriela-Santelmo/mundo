package mundo;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private final List<Pais> paisesLimitrofes;

    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.paisesLimitrofes = new ArrayList<>();
    }

    public Pais(String codigoISO, String nome, double dimensao, long populacao) {
        this(codigoISO, nome, dimensao);
        this.populacao = populacao;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public List<Pais> getPaisesLimitrofes() {
        return paisesLimitrofes;
    }

    public double getDensidadePopulacional() {
        return populacao / dimensao;
    }

    public List<Pais> getVizinhosComuns(Pais outro) {
        List<Pais> vizinhosComuns = new ArrayList<>(paisesLimitrofes);
        vizinhosComuns.retainAll(outro.paisesLimitrofes);
        return vizinhosComuns;
    }
}
