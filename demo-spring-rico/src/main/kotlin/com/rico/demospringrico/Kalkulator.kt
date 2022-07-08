package com.rico.demospringrico

import org.springframework.stereotype.Service

@Service
class Kalkulator {

    fun tambah(angka1: Int, angka2: Int): Int {
        return angka1 + angka2
    }
}