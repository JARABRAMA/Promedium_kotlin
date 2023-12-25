package com.jarabrama.promedium20.Application

import android.app.Application
import com.jarabrama.promedium20.Clases.Semestre

class Promedium: Application() {
    var semestre: Semestre = Semestre(0.0, 0.0, 0.0, mutableListOf())
}