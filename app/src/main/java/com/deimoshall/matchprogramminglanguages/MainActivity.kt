package com.deimoshall.matchprogramminglanguages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private var cardVisible = false
    private var cardsOrdering = mutableMapOf<Int, Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val card1: View = findViewById(R.id.container_1)
        val card2: View = findViewById(R.id.container_2)
        val card3: View = findViewById(R.id.container_3)
        val card4: View = findViewById(R.id.container_4)

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

        card1.setOnClickListener {
            if (cardVisible) {
                toggleCard(it, backCard1)
                cardVisible = false
            } else {
                toggleCard(it, kotlinCard)
                cardVisible = true
            }
        }

        card2.setOnClickListener {
            if (cardVisible) {
                toggleCard(it, backCard2)
                cardVisible = false
            } else {
                toggleCard(it, pythonCard)
                cardVisible = true
            }
        }

        card3.setOnClickListener {
            if (cardVisible) {
                toggleCard(it, backCard3)
                cardVisible = false
            } else {
                toggleCard(it, javaCard)
                cardVisible = true
            }
        }

        card4.setOnClickListener {
            if (cardVisible) {
                toggleCard(it, backCard4)
                cardVisible = false
            } else {
                toggleCard(it, cCard)
                cardVisible = true
            }
        }
    }

    private fun toggleCard(cardContainer: View, card: Fragment) {
        Log.d("myTag", "Id: ${cardContainer.tag}, card: ${card}")
        try {
            supportFragmentManager.commit {
                replace(cardContainer.id, card, "${cardContainer.id}")
                setReorderingAllowed(true)
            }
        } catch (e: Exception) {
            Log.d("myTag", "Toggle card error: $e")
        }
    }
}