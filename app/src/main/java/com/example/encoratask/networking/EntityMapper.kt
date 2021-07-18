package com.example.encoratask.networking

interface EntityMapper<E, D>  {
    fun mapFromEntity(entity: E): D
    fun mapToEntity(domain: D): E
}