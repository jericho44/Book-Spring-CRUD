package com.rico.demospringrico

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kalkulator")
class KalkulatorController(
    private val kalkulator: Kalkulator
) {

    // URL: /kalkulator/tambah?angka1=10&angka2=5
    @GetMapping("/tambah")
    fun actionTambah(
        @RequestParam("angka1") angka1:Int,
        @RequestParam("angka2") angka2:Int
    ): ResponseEntity<String> {
        // panggil service kalkulator
        val result = kalkulator.tambah(angka1, angka2)
        val response = "$angka1 + $angka2 = $result"
        return ResponseEntity(response, HttpStatus.OK)
    }

    /*
   * latihan path
   * */
    @GetMapping("/pangkat/{number}")
    fun dapatkanPangkat(
        @PathVariable number: Int
    ): ResponseEntity<Int> {
        return ResponseEntity(number * number, HttpStatus.OK)
    }

    /*
    * latihan headers
    * localhost:8080/kalkulator/luas-segitiga/
    * */
    @GetMapping("/luas-segitiga")
    fun dapatkanLuasSegitiga(
        @RequestHeader("alas") alas: Int,
        @RequestHeader("tinggi") tinggi: Int
    ): ResponseEntity<Int> {
        val luas = (alas * tinggi ) / 2
        return ResponseEntity(luas, HttpStatus.OK)
    }
    /*
   * latihan body
   * localhost:8080/kalkulator/volume-tabung/
   * */
    @PostMapping("/volume-tabung")
    fun getVolumeTabung(
        @RequestBody request: VolumeTabungRequest
    ): ResponseEntity<Double> {
        val luasAlas = 3.14 * request.jariJariAlas * request.jariJariAlas
        val volume = luasAlas * request.tinggi

        return ResponseEntity(volume, HttpStatus.OK)
    }
    data class VolumeTabungRequest(
        val jariJariAlas: Int,
        val tinggi: Int
    )



}