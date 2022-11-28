enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (var nome: String, val matricula: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarInscritos() {
        inscritos.forEach { u -> println("Nome: ${u.nome} - Matrícula: ${u.matricula}") }
    }

    fun listarConteudos(){
        println("Conteúdos da formação: $nome:")
        for ( c in conteudos) println("- ${c.nome}")
    }
}

fun main() {
    val conteudosKotlin = listOf(ConteudoEducacional("Introdução ao Kotlin", 20, Nivel.BASICO),
        ConteudoEducacional("Controle de Fluxo", 10, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Módulo Avançado", 50, Nivel.AVANCADO))

    val formacaoKotlin = Formacao("Formação Kotlin", conteudosKotlin)

    formacaoKotlin.matricular(Usuario("Emerson Silva",202201))
    formacaoKotlin.listarInscritos()
    formacaoKotlin.listarConteudos()
}