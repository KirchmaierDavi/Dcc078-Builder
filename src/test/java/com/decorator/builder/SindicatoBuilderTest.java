package com.decorator.builder;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SindicatoBuilderTest {

    @Test
    void deveConstruirSindicatoComSucesso() {
        Sindicato sindicato = new SindicatoBuilder()
                .comNome("Sindicato dos Metalúrgicos")
                .comCnpj("00.000.000/0001-00")
                .comDataFundacao(LocalDate.of(1980, 5, 10))
                .comCategoriaProfissional("Metalúrgicos")
                .comEndereco("Av. Central, 1000")
                .adicionarMunicipio("São Paulo")
                .adicionarMunicipio("Santo André")
                .comQuantidadeAssociados(1500)
                .build();

        assertAll(
                () -> assertEquals("Sindicato dos Metalúrgicos", sindicato.getNome()),
                () -> assertEquals("00.000.000/0001-00", sindicato.getCnpj()),
                () -> assertEquals(LocalDate.of(1980, 5, 10), sindicato.getDataFundacao()),
                () -> assertEquals("Metalúrgicos", sindicato.getCategoriaProfissional()),
                () -> assertEquals("Av. Central, 1000", sindicato.getEndereco()),
                () -> assertEquals(List.of("São Paulo", "Santo André"), sindicato.getMunicipiosAtendidos()),
                () -> assertEquals(1500, sindicato.getQuantidadeAssociados())
        );
    }

    @Test
    void naoDevePermitirQuantidadeAssociadosNegativa() {
        SindicatoBuilder builder = new SindicatoBuilder()
                .comNome("Sindicato X")
                .comCnpj("11.111.111/0001-11")
                .comQuantidadeAssociados(-1);

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void naoDeveConstruirSemNomeOuCnpj() {
        SindicatoBuilder builderSemNome = new SindicatoBuilder()
                .comCnpj("11.111.111/0001-11");

        assertThrows(IllegalStateException.class, builderSemNome::build);

        SindicatoBuilder builderSemCnpj = new SindicatoBuilder()
                .comNome("Sindicato X");

        assertThrows(IllegalStateException.class, builderSemCnpj::build);
    }
}
