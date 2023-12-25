package com.jarabrama.promedium20.Activityes

import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.jarabrama.promedium20.Application.Promedium
import com.jarabrama.promedium20.Clases.Course
import com.jarabrama.promedium20.R

class NewCourseActivity : AppCompatActivity() {
    private lateinit var edName: TextView
    private lateinit var edCretids: TextView
    private lateinit var btnNext: AppCompatButton
    private lateinit var promedium: Promedium

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_course)
        promedium = application as Promedium

        edName = findViewById(R.id.edName)
        edCretids = findViewById(R.id.edCredits)

        // button next
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            try {
                val name: String = edName.text.toString()
                val credits: Int = edCretids.text.toString().toInt()
                val newCourse: Course = Course(name, credits, mutableListOf())
                promedium.semestre.courses.add(newCourse)
            } catch (e: IllegalArgumentException) {
                val invalidDate: AlertDialog.Builder = AlertDialog.Builder(this, R.style.Base_Theme_Promedium20)
                invalidDate.setTitle("Dato invalido").
                        setMessage("Upps! algo a salido mal asegurate de que todos los datos sean validos").
                        setPositiveButton("Corregir") { dialog, which ->
                            dialog.dismiss()
                        }.show()
                edName.text = ""
                edCretids.text = ""
            }
        }
    }

}