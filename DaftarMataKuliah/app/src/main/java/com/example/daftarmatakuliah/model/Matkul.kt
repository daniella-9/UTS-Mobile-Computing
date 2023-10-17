package com.example.daftarmatakuliah.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class Matkul(
    @StringRes val namamatkul: Int,
    @StringRes val sks: Int,
    @DrawableRes val pict: Int
)
