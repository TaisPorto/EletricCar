package com.example.eletriccar.ui.adapter

import com.example.eletriccar.dominio.Carro

object CarFactory {
    val list = listOf(
        Carro(
            id = 1,
            preco = "R$ 300.000,00",
            bateria = "300 kWh",
            potencia = "200cv",
            recarga = "30 min",
            urlPhoto = "www.google.com.br",
            isFavorite = false

            ),
        Carro(
            id = 2,
            preco = "R$ 200.000,00",
            bateria = "300 kWh",
            potencia = "200cv",
            recarga = "23 min",
            urlPhoto = "www.google.com.br",
            isFavorite = false

        )
    )

    // VERBOS HTTP
    // - GET -> PARA RECUPERAR INFORMACOES
    // - POST -> PARA ENVIAR INFORMACOES PARA UM SERVIDOR
    // - DELETE -> PARA DELETAR ALGUM RECURSO
    // - PUT -> PARA ALTERAR UMA ENTIDADE COMO UM TODO
    // - PACTCH -> ALTERA UM ATRIBUTO POR ENTIDADE

}