interface ICrud<T> {
    fun insertar(obj: T): Boolean
    fun actualizar(obj: T): Boolean
    fun eliminar(id: Int): Boolean
    fun obtenerTodos(): List<T>
    fun obtenerPorId(id: Int): T?
}

