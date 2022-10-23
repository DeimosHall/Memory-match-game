package com.deimoshall.matchprogramminglanguages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val card1: View = findViewById(R.id.container_1)
        val kotlinCard = KotlinCardFragment()

        card1.setOnClickListener {
            Toast.makeText(this, "${it.id}, ${R.id.container_1}", Toast.LENGTH_SHORT).show()
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.container_1, KotlinCardFragment())
            }
        }
    }
}