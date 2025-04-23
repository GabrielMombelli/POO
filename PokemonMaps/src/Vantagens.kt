import Tipagens

class Vantagens {

    val vantagens = mapOf(
        Tipagens.Fogo to listOf(Tipagens.Planta, Tipagens.Inseto, Tipagens.Gelo, Tipagens.Aco),
        Tipagens.Planta to listOf(Tipagens.Terrestre, Tipagens.Pedra, Tipagens.Agua),
        Tipagens.Agua to listOf(Tipagens.Fogo, Tipagens.Terrestre, Tipagens.Pedra),
        Tipagens.Eletrico to listOf(Tipagens.Agua, Tipagens.Voador),
        Tipagens.Voador to listOf(Tipagens.Inseto, Tipagens.Lutador, Tipagens.Planta),
        Tipagens.Gelo to listOf(Tipagens.Dragao, Tipagens.Voador, Tipagens.Planta, Tipagens.Terrestre),
        Tipagens.Pedra to listOf(Tipagens.Inseto, Tipagens.Fogo, Tipagens.Voador, Tipagens.Gelo),
        Tipagens.Terrestre to listOf(Tipagens.Eletrico, Tipagens.Fogo, Tipagens.Venenoso, Tipagens.Pedra, Tipagens.Aco),
        Tipagens.Lutador to listOf(Tipagens.Gelo, Tipagens.Normal, Tipagens.Pedra, Tipagens.Sombrio, Tipagens.Aco),
        Tipagens.Psiquico to listOf(Tipagens.Lutador, Tipagens.Venenoso),
        Tipagens.Venenoso to listOf(Tipagens.Planta, Tipagens.Fada),
        Tipagens.Inseto to listOf(Tipagens.Planta, Tipagens.Psiquico, Tipagens.Sombrio),
        Tipagens.Dragao to listOf(Tipagens.Dragao),
        Tipagens.Normal to listOf(),
        Tipagens.Sombrio to listOf(Tipagens.Psiquico, Tipagens.Fantasma),
        Tipagens.Fantasma to listOf(Tipagens.Psiquico, Tipagens.Fantasma),
        Tipagens.Aco to listOf(Tipagens.Fada, Tipagens.Gelo, Tipagens.Pedra),
        Tipagens.Fada to listOf(Tipagens.Lutador, Tipagens.Dragao, Tipagens.Sombrio)
    )
}