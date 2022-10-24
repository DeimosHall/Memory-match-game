package com.deimoshall.matchprogramminglanguages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var cardVisible = false
    private var cardsOrdering = mutableMapOf<Int, Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardContainer1: View = findViewById(R.id.container_1)
        val cardContainer2: View = findViewById(R.id.container_2)
        val cardContainer3: View = findViewById(R.id.container_3)
        val cardContainer4: View = findViewById(R.id.container_4)

        val backCard1 = BackCardFragment()
        val backCard2 = BackCardFragment()
        val backCard3 = BackCardFragment()
        val backCard4 = BackCardFragment()
        val backCard5 = BackCardFragment()
        val backCard6 = BackCardFragment()
        val backCard7 = BackCardFragment()
        val backCard8 = BackCardFragment()
        val backCard9 = BackCardFragment()
        val backCard10 = BackCardFragment()
        val backCard11 = BackCardFragment()
        val backCard12 = BackCardFragment()
        val backCard13 = BackCardFragment()
        val backCard14 = BackCardFragment()
        val backCard15 = BackCardFragment()
        val backCard16 = BackCardFragment()

        val kotlinCard = KotlinCardFragment()
        val cCard = CCardFragment()
        val pythonCard = PythonCardFragment()
        val javaCard = JavaCardFragment()

        cardsOrdering.put(1, kotlinCard)
        cardsOrdering.put(2, pythonCard)
        cardsOrdering.put(3, javaCard)
        cardsOrdering.put(4, cCard)

        val card1 = Card(supportFragmentManager, cardContainer1, cardsOrdering.getValue(1), backCard1)
        val card2 = Card(supportFragmentManager, cardContainer2, cardsOrdering.getValue(2), backCard2)
        val card3 = Card(supportFragmentManager, cardContainer3, cardsOrdering.getValue(3), backCard3)
        val card4 = Card(supportFragmentManager, cardContainer4, cardsOrdering.getValue(4), backCard4)

        cardContainer1.setOnClickListener {
            card1.toggle()
        }

        cardContainer2.setOnClickListener {
            card2.toggle()
        }

        cardContainer3.setOnClickListener {
            card3.toggle()
        }

        cardContainer4.setOnClickListener {
            card4.toggle()
        }
    }
}