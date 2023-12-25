package com.jarabrama.promedium20.Clases

class Semestre(
    var inferiorLimit: Double,
    var superiorLimit: Double,
    var goal: Double,
    var courses: MutableList<Course>
) {
    fun getAverage(): Double {
        return courses.sumByDouble { course ->
            (course.credits * course.getAverage())/ courses.sumByDouble { course -> course.credits.toDouble() }
        }
    }
}