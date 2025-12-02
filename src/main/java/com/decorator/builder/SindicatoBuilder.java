package com.decorator.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do padrão Builder para {@link Sindicato}.
 *
 * Uso típico:
 * <pre>
 * Sindicato sindicato = new SindicatoBuilder()
 *      .comNome("Sindicato dos Metalúrgicos")
 *      .comCnpj("00.000.000/0001-00")
 *      .comCategoriaProfissional("Metalúrgicos")
 *      .adicionarMunicipio("São Paulo")
 *      .adicionarMunicipio("Santo André")
 *      .comQuantidadeAssociados(1500)
 *      .build();
 * </pre>
 */
public class SindicatoBuilder {

    private String nome;
    private String cnpj;
    private LocalDate dataFundacao;
    private String categoriaProfissional;
    private String endereco;
    private List<String> municipiosAtendidos = new ArrayList<>();
    private int quantidadeAssociados;

    public SindicatoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public SindicatoBuilder comCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public SindicatoBuilder comDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
        return this;
    }

    public SindicatoBuilder comCategoriaProfissional(String categoriaProfissional) {
        this.categoriaProfissional = categoriaProfissional;
        return this;
    }

    public SindicatoBuilder comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public SindicatoBuilder adicionarMunicipio(String municipio) {
        if (municipio != null && !municipio.isBlank()) {
            this.municipiosAtendidos.add(municipio);
        }
        return this;
    }

    public SindicatoBuilder comMunicipios(List<String> municipios) {
        this.municipiosAtendidos.clear();
        if (municipios != null) {
            this.municipiosAtendidos.addAll(municipios);
        }
        return this;
    }

    public SindicatoBuilder comQuantidadeAssociados(int quantidadeAssociados) {
        this.quantidadeAssociados = quantidadeAssociados;
        return this;
    }

    /**
     * Valida os campos obrigatórios e cria a instância de {@link Sindicato}.
     */
    public Sindicato build() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalStateException("nome é obrigatório");
        }
        if (cnpj == null || cnpj.isBlank()) {
            throw new IllegalStateException("cnpj é obrigatório");
        }
        return new Sindicato(
                nome,
                cnpj,
                dataFundacao,
                categoriaProfissional,
                endereco,
                municipiosAtendidos,
                quantidadeAssociados
        );
    }
}

