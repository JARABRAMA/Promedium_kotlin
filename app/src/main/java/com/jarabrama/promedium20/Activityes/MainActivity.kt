package com.jarabrama.promedium20.Activityes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.jarabrama.promedium20.Application.Promedium
import com.jarabrama.promedium20.Clases.Semestre
import com.jarabrama.promedium20.R

class MainActivity : AppCompatActivity() {
    private lateinit var tvAverage: AppCompatTextView
    private lateinit var tvGoal: AppCompatTextView
    private lateinit var semestre: Semestre

    private lateinit var lvName: ListView
    private lateinit var lvCredits: ListView
    private lateinit var lvAverage: ListView

    private lateinit var listNames: MutableList<String>
    private lateinit var listCredits: MutableList<String>
    private lateinit var listAverage: MutableList<String>

    private lateinit var btnNewCourse: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val promedium: Promedium = application as Promedium
        this.semestre = promedium.semestre

        tvGoal = findViewById(R.id.tvGoal)
        tvGoal.text = semestre.goal.toString().replace(".0", "")

        tvAverage = findViewById(R.id.tvAverage)
        tvAverage.text = semestre.getAverage().toString().replace(".0", "")

        lvName = findViewById(R.id.lvNames)
        lvAverage = findViewById(R.id.lvAverage)
        lvCredits = findViewById(R.id.lvCredits)

        //list
        listNames = mutableListOf()
        listCredits = mutableListOf()
        listAverage = mutableListOf()
        fillListView(promedium.semestre, listNames, listCredits, listAverage)

        // adapter list
        var aaNames: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listNames)
        lvName.adapter = aaNames
        var aaCredits: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listCredits)
        lvCredits.adapter = aaCredits
        var aaAverage: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listAverage)
        lvAverage.adapter = aaAverage

        btnNewCourse = findViewById(R.id.btnNewCourse)
        btnNewCourse.setOnClickListener {
            var openNewCourseActivity: Intent = Intent(this, NewCourseActivity::class.java)
            startActivity(openNewCourseActivity)
        }
    }

    private fun fillListView(
        semestre: Semestre,
        listNames: MutableList<String>,
        listCredits: MutableList<String>,
        listAverage: MutableList<String>
    ) {
        semestre.courses.map { course ->
            listNames.add(course.name)
            listCredits.add(course.credits.toString())
            listAverage.add(course.getAverage().toString())
        }
    }
}