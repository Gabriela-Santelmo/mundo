package mundo;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private final String nome;
    private final List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public String getNome() {
        return nome;
    }

    public double getDimensaoTotal() {
        return paises.stream().mapToDouble(Pais::getDimensao).sum();
    }

    public long getPopulacaoTotal() {
        return paises.stream().mapToLong(Pais::getPopulacao).sum();
    }

    public double getDensidadePopulacional() {
        return getPopulacaoTotal() / getDimensaoTotal();
    }

    public Pais getPaisMaiorPopulacao() {
        return paises.stream().max((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    public Pais getPaisMenorPopulacao() {
        return paises.stream().min((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    public Pais getPaisMaiorDimensao() {
        return paises.stream().max((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
    }

    public Pais getPaisMenorDimensao() {
        return paises.stream().min((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
    }
}
