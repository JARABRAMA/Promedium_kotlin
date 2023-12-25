package com.jarabrama.promedium20.Activityes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.AppCompatButton
import com.jarabrama.promedium20.Application.Promedium
import com.jarabrama.promedium20.R

class CourseActivity : AppCompatActivity() {
    private lateinit var promedium: Promedium

    private lateinit var lvNames: ListView
    private lateinit var lvPercent: ListView
    private lateinit var lvQualification: ListView

    private lateinit var listNames: MutableList<String>
    private lateinit var listPercents: MutableList<String>
    private lateinit var listQualification: MutableList<String>

    private lateinit var aaNames: MutableList<String>

    private lateinit var btnNewGrade: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        promedium = application as Promedium

        lvNames = findViewById(R.id.lvNames)
        lvPercent = findViewById(R.id.lvPercent)
        lvQualification = findViewById(R.id.lvQualification)

        listNames = mutableListOf()
        listPercents = mutableListOf()
        listQualification = mutableListOf()


    }
}