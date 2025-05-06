val expressaoRegular = Regex("[0-5]") // Aceita somente opções de 0 a 5 no menu

// Criação de uma lista mutável para armazenar objetos do tipo Convidado
var listaConvidados : MutableList<Convidado> = mutableListOf<Convidado>()

fun main() {
    menu()
}

private fun menu() {
    do {
        println("---MENU---")
        println("1- CADASTRAR")
        println("2- LISTAR")
        println("3- EDITAR")
        println("4- EXCLUIR")
        println("5- BUSCAR")
        println("0- SAIR")

        val opcao = readln() // Lê como string para ser validado com Regex

        if(expressaoRegular.matches(opcao)) {
            when (opcao.toInt()) {
                1 -> {
                    println("Cadastrando...")
                    cadastrar()
                }
                2 -> {
                    println("Listando...")
                    listar()
                }
                3 -> {
                    println("Editando...")
                    editar()
                }
                4 -> {
                    println("Excluindo...")
                    excluir()
                }
                5 -> {
                    println("Buscando...")
                    busca()
                }
                0 -> println("SAINDO...")
            }
        } else {
            println("\n\n\nOpção Inválida!\n")
        }
    } while (opcao != "0")
}

private fun cadastrar() {
    // Regex para validar nomes: deve começar com letra maiúscula (inclusive acentuada)
    // e conter apenas letras e espaços nos demais caracteres
    val regex = Regex("^[A-ZÀ-ÖØ-Ÿ][a-zà-ÿ ]+$")
    var nome: String
    val convidado = Convidado()

    // Loop até que um nome válido seja digitado
    do {
        println("Qual o seu nome? ")
        nome = readln()

        if (regex.matches(nome)) {
            convidado.nome = nome
        } else {
            println("Nome inválido!")
            println("O nome deve começar com letra MAIÚSCULA e conter apenas letras.")
        }
    } while (!regex.matches(nome))

    // Coleta das demais informações
    println("Qual será seu presente?")
    convidado.presente = readln()

    println("Qual sua restrição alimentar?")
    convidado.alimentar = readln()

    // Adiciona o convidado à lista
    listaConvidados.add(convidado)
}

private fun listar() {
    var i = 0

    // Só lista se a lista não estiver vazia
    if (validar()) {
        listaConvidados.forEach { convidado ->
            println(
                        "Posição: ${i++} \n"+
                        "Nome: ${convidado.nome} \n" +
                        "Presente: ${convidado.presente} \n"  +
                        "Restrição: ${convidado.alimentar} \n" +
                        "Vai à festa? ${convidado.presenca} \n"
            )
        }
    }
}

// Valida se a lista está vazia
private fun validar() : Boolean {
    if (listaConvidados.isEmpty()) {
        println("A lista está vazia!")
        return false
    }
    return true
}

// Edita a presença de um convidado
// Valida se a posição é numérica e se a resposta é S ou N
private fun editar(): Boolean {
    if (validar()) {
        val regexNum = Regex("[0-9]")
        val regexResposta = Regex("^[sSnN]$")
        var posicao: String

        do {
            println("Digite a posição a ser editada:")
            posicao = readln()

            if (regexNum.matches(posicao)) {
                if (posicao.toInt() in listaConvidados.indices) {
                    println("O convidado vai? (S/N)")
                    val resposta = readln()

                    if (regexResposta.matches(resposta)) {
                        when (resposta.uppercase()) {
                            "S" -> listaConvidados[posicao.toInt()].presenca = true
                            "N" -> listaConvidados[posicao.toInt()].presenca = false
                        }
                        return true
                    } else {
                        println("Digite uma resposta válida (S ou N).")
                    }
                } else {
                    println("Posição inválida, fora da lista!")
                }
            } else {
                println("Posição inválida, digite apenas números.")
            }
        } while (true)
    }
    return false
}

// Exclui um convidado da lista
// Valida que a posição digitada é numérica e está dentro do intervalo da lista
private fun excluir(): Boolean {
    if (validar()) {
        listar()
        var posicao: String
        val regexNum = Regex("^[0-9]+$")
        var excluiu = false

        do {
            println("Quem deseja remover? (Digite a posição ou 'N' para cancelar)")
            posicao = readln().uppercase()

            if (posicao == "N") {
                println("Exclusão cancelada.")
                break
            }

            if (regexNum.matches(posicao)) {
                try {
                    val posicaoInt = posicao.toInt()
                    if (posicaoInt in listaConvidados.indices) {
                        listaConvidados.removeAt(posicaoInt)
                        println("Convidado excluído.")
                        excluiu = true
                        break
                    } else {
                        println("Posição inválida, fora da lista!")
                    }
                } catch (e: NumberFormatException) {
                    println("Erro: digite um número válido.")
                }
            } else {
                println("Entrada inválida. Digite um número ou 'N'.")
            }
        } while (!excluiu)

        return excluiu
    }
    return false
}

// Busca convidados pelo nome
// Valida que a entrada contenha apenas letras e ignora maiúsculas/minúsculas
private fun busca(): Boolean {
    println("Digite o nome para buscar:")
    var busca: String
    val regex = Regex("^[a-zA-ZÀ-ÖØ-ÿ ]+$")
    var encontradoAlgum = false

    do {
        busca = readln()

        if (regex.matches(busca) || busca.isEmpty()) {
            var encontradoNestaBusca = false

            listaConvidados.forEachIndexed { index, convidado ->
                if (convidado.nome.lowercase().contains(busca.lowercase())) {
                    encontradoNestaBusca = true
                    encontradoAlgum = true
                    if (convidado.presenca) {
                        println("Posição $index: ${convidado.nome} (Confirmado)")
                    } else {
                        println("Posição $index: ${convidado.nome} (Não Confirmado)")
                    }
                }
            }

            if (!encontradoNestaBusca && busca.isNotEmpty()) {
                println("Nenhum convidado encontrado com o nome \"$busca\".")
            }
            break
        } else {
            println("Entrada inválida. Use apenas letras.")
            println("Tentar novamente? (S/N)")
            val tentarNovamente = readln().uppercase()
            if (tentarNovamente != "S") break
        }
    } while (true)

    return encontradoAlgum
}
