package com.talhakilic.kasimhocaodev.odev2

fun main() {

    println(fahrenheitDonustur(28.0))
    println(dikdortgenCevreHesapla(6, 15))
    println(faktoriyelHesapla(7))
    println(aHarfiSayisi("Istanbul"))
    println(icAciToplami(6))
    println(maasHesaplama(24))
    println(kotaUcretiHesaplama(82))
}

fun fahrenheitDonustur(derece: Double) : Double{
    val fahrenhietSonuc = (derece * 1.8) + 32
return fahrenhietSonuc
}

fun dikdortgenCevreHesapla(uzunKenar :Int, kisaKenar:Int) :Int{
    return 2* (kisaKenar + uzunKenar)
}

fun faktoriyelHesapla(deger :Int):Int{
    var sonuc =1
    for(i in 1..deger){
        sonuc = sonuc * i
    }
    return sonuc
}

fun aHarfiSayisi(kelime: String): Int {
    return kelime.lowercase().count { it == 'a' }
}
fun icAciToplami(kenarSayisi: Int): Int {
    return (kenarSayisi - 2) * 180
}
fun maasHesaplama(gunSayisi: Int): Int {
    val saatlikUcret = 10
    val mesaiUcreti = 20
    val calismaSaati = gunSayisi * 8

    return if (calismaSaati <= 160) {
        calismaSaati * saatlikUcret
    } else {
        val normalSaat = 160
        val mesaiSaat = calismaSaati - 160
        (normalSaat * saatlikUcret) + (mesaiSaat * mesaiUcreti)
    }
}

fun kotaUcretiHesaplama(kotaDegeri: Int): Int {
    val temelUcret = 100 // 50 GB için
    return if (kotaDegeri <= 50) {
        temelUcret
    } else {
        val ekstraGb = kotaDegeri - 50
        temelUcret + (ekstraGb * 4)
    }
}
