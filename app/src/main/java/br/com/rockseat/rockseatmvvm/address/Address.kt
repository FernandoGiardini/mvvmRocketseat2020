package br.com.rockseat.rockseatmvvm.address

data class Address(
    val cep: String? = null,
    val state: String? = null,
    val city: String? = null,
    val neighbourhood: String? = null,
    val street :String? = null
)
