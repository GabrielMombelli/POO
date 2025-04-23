import Vantagens


fun main() {
    val efetividade = Vantagens()

    print("Digite o nome do Pokémon que você quer buscar: ")
    val nomePokemon = readlnOrNull()?.lowercase()

    if (nomePokemon != null && Pokedex.todosPoke.containsKey(nomePokemon)) {
        val pokemonEncontrado = Pokedex.todosPoke[nomePokemon]!!
        val tipoPokemon = if (pokemonEncontrado.tipoSecundario != null) {
            pokemonEncontrado.tipoPrimario.toString() + " e " + pokemonEncontrado.tipoSecundario.toString()

        } else {
            pokemonEncontrado.tipoPrimario.toString()
        }
        val vantagensDoTipoPrimario = listOf( efetividade.vantagens[pokemonEncontrado.tipoPrimario])
        val vantagensDoTipoSecundario = listOf( efetividade.vantagens[pokemonEncontrado.tipoSecundario])



        println("\nInformações do Pokémon:")
        println("Nome: ${pokemonEncontrado.nome }")
        println("ID: ${pokemonEncontrado.numPokedex}")
        println("Tipo(s): $tipoPokemon")
        println("Vantagens contra os tipos: ${vantagensDoTipoPrimario.joinToString()} ${vantagensDoTipoSecundario.joinToString()}")

    } else {
        println("\nPokémon não encontrado na Pokédex.")
    }
}