package com.decorator.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Sindicato {

    private final String nome;
    private final String cnpj;
    private final LocalDate dataFundacao;
    private final String categoriaProfissional;
    private final String endereco;
    private final List<String> municipiosAtendidos;
    private final int quantidadeAssociados;

    // Construtor com visibilidade de pacote para ser usado apenas pelo builder
    Sindicato(String nome,
              String cnpj,
              LocalDate dataFundacao,
              String categoriaProfissional,
              String endereco,
              List<String> municipiosAtendidos,
              int quantidadeAssociados) {
        this.nome = Objects.requireNonNull(nome, "nome é obrigatório");
        this.cnpj = Objects.requireNonNull(cnpj, "cnpj é obrigatório");
        this.dataFundacao = dataFundacao;
        this.categoriaProfissional = categoriaProfissional;
        this.endereco = endereco;
        this.municipiosAtendidos = municipiosAtendidos == null
                ? List.of()
                : Collections.unmodifiableList(new ArrayList<>(municipiosAtendidos));
        if (quantidadeAssociados < 0) {
            throw new IllegalArgumentException("quantidadeAssociados nao pode ser negativa");
        }
        this.quantidadeAssociados = quantidadeAssociados;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public String getCategoriaProfissional() {
        return categoriaProfissional;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<String> getMunicipiosAtendidos() {
        return municipiosAtendidos;
    }

    public int getQuantidadeAssociados() {
        return quantidadeAssociados;
    }

    @Override
    public String toString() {
        return "Sindicato{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", dataFundacao=" + dataFundacao +
                ", categoriaProfissional='" + categoriaProfissional + '\'' +
                ", endereco='" + endereco + '\'' +
                ", municipiosAtendidos=" + municipiosAtendidos +
                ", quantidadeAssociados=" + quantidadeAssociados +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sindicato sindicato = (Sindicato) o;
        return Objects.equals(cnpj, sindicato.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }
}

