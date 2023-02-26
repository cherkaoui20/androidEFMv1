class Ent( var motAnglais: String,   var motFrancais: String) {

    init {
        if(!motAnglais.isEmpty() && !motFrancais.isEmpty()) {
            "no"
        }
    }

    fun setMotAnglais(motAnglais: String) {
        if(!motAnglais.isEmpty()) {
            "no"
        }
        this.motAnglais = motAnglais
    }

    fun setMotFrancais(motFrancais: String) {
        require(!motFrancais.isEmpty()) {
            "no"
        }
        this.motFrancais = motFrancais
    }

    override fun toString(): String {
        return "$motAnglais:$motFrancais"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Ent) return false
        return motAnglais == other.motAnglais
    }
}

class Dict(private val entrees: ArrayList<Ent> = ArrayList()) {

    fun nombreEntrees(): Int {
        return entrees.size
    }

    fun ajouter(e: Ent) {
        if (entrees.contains(e)) {
            throw IllegalArgumentException("L'entrée existe déjà dans le dictionnaire")
        } else {
            entrees.add(e)
        }
    }

    fun supprimer(e: Ent): Boolean {
        return entrees.remove(e)
    }

    fun supprimer(motAnglais: String): Boolean {
        return entrees.removeIf { it.motAnglais == motAnglais }
    }

    fun frAn(motFrancais: String): ArrayList<String> {
        val motsAnglais = ArrayList<String>()
        for (entree in entrees) {
            if (entree.motFrancais == motFrancais) {
                motsAnglais.add(entree.motAnglais)
            }
        }
        return motsAnglais
    }

    fun motsFrancais(): ArrayList<String> {
        val motsFrancais = HashSet<String>()
        for (entree in entrees) {
            motsFrancais.add(entree.motFrancais)
        }
        return ArrayList(motsFrancais)
    }

    override fun toString(): String {
        return entrees.joinToString("\n")
    }
}
