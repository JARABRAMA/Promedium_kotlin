package com.jarabrama.promedium20.Clases

class Course(var name: String, var credits: Int, var grades: MutableList<Grade>) {

    fun getAverage(): Double {
        return grades.sumByDouble { grade -> (grade.percent/100) * grade.qualification }
    }
}



