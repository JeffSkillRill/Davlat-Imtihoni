package com.example.myapplication.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.Item

class HomeViewModel(val model: HomeModel) : ViewModel() {
    private var _items = MutableLiveData(mutableListOf<Item>())
    val items: LiveData<MutableList<Item>> = _items

    val database = listOf(
        Item(name = "Nyutonning mexanikasi", description = "Nyutonning uchta harakat qonunlari jismning harakatini tasvirlaydi va kuchlarni tushuntiradi."),
        Item(name = "Maxvell tenglamalari", description = "James Clerk Maxwell tomonidan elektromagnit maydonlarni tasvirlaydigan to'rtta tenglama.e"),
        Item(name = "Max Planckning kvant nazariyasi", description = "Energiya kvantlar shaklida uzatilishini tushuntiradi."),
        Item(name = "Albert Eynshteynning maxsus nisbiylik nazariya", description = "Harakat va tezlikning vaqt va makonga qanday ta'sir qilishini tushuntiradi."),
        Item(name = "Albert Eynshteynning umumiy nisbiylik nazariyasi ", description = "Gravitatsiya va egrilikning makon-vaqtga qanday ta'sir qilishini tushuntiradi."),
        Item(name = "Nima uchun osmonda yulduzlar miltillaydi? ", description = "Atmosferadagi turli zichlikdagi qatlamlar yorug'likni sinishiga sabab bo'ladi, bu esa yulduzlarning miltillashiga olib keladi."),
        Item(name = "Og'irlik kuchi qanday ta'sir qiladi?", description = "Og'irlik kuchi yerning tortish kuchi tufayli jismlarni pastga tortadi."),
        Item(name = "Nur sinishi nima? ", description = "Nur bir muhitdan ikkinchi muhitga o'tganda yo'nalishini o'zgartiradi."),
        Item(name = "Issiqlik uzatishning qanday usullari mavjud?", description = "Issiqlik uzatishning uch usuli mavjud: konveksiya, konduktsiya va radiatsiya."),
    )

    init {
        if (model.isFirstRun()) addItems()
        getItems()
    }

    private fun getItems() {
        _items.value = model.getItems()
    }

    private fun addItems() {
        for (item in database) {
            model.addItem(item)
        }
    }
}