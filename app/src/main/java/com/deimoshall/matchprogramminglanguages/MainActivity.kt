package com.deimoshall.matchprogramminglanguages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var cardsOrdering = mutableMapOf<Int, Fragment>()
    lateinit var cardContainer1: View
    lateinit var cardContainer2: View
    lateinit var cardContainer3: View
    lateinit var cardContainer4: View
    lateinit var cardContainer5: View
    lateinit var cardContainer6: View
    lateinit var cardContainer7: View
    lateinit var cardContainer8: View
    lateinit var cardContainer9: View
    lateinit var cardContainer10: View
    lateinit var cardContainer11: View
    lateinit var cardContainer12: View
    lateinit var cardContainer13: View
    lateinit var cardContainer14: View
    lateinit var cardContainer15: View
    lateinit var cardContainer16: View

    private lateinit var tvUsername: TextView
    private lateinit var tvFoundPairs: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUsername = findViewById(R.id.tv_username)
        tvFoundPairs = findViewById(R.id.tv_found_pairs)

        cardContainer1 = findViewById(R.id.container_1)
        cardContainer2 = findViewById(R.id.container_2)
        cardContainer3 = findViewById(R.id.container_3)
        cardContainer4 = findViewById(R.id.container_4)
        cardContainer5 = findViewById(R.id.container_5)
        cardContainer6 = findViewById(R.id.container_6)
        cardContainer7 = findViewById(R.id.container_7)
        cardContainer8 = findViewById(R.id.container_8)
        cardContainer9 = findViewById(R.id.container_9)
        cardContainer10 = findViewById(R.id.container_10)
        cardContainer11 = findViewById(R.id.container_11)
        cardContainer12 = findViewById(R.id.container_12)
        cardContainer13 = findViewById(R.id.container_13)
        cardContainer14 = findViewById(R.id.container_14)
        cardContainer15 = findViewById(R.id.container_15)
        cardContainer16 = findViewById(R.id.container_16)

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

        val kotlinCard1 = KotlinCardFragment()
        val kotlinCard2 = KotlinCardFragment()
        val cCard1 = CCardFragment()
        val cCard2 = CCardFragment()
        val pythonCard1 = PythonCardFragment()
        val pythonCard2 = PythonCardFragment()
        val javaCard1 = JavaCardFragment()
        val javaCard2 = JavaCardFragment()
        val cSharpCard1 = CSharpCardFragment()
        val cSharpCard2 = CSharpCardFragment()
        val cPlusPlusCard1 = CPlusPlusCardFragment()
        val cPlusPlusCard2 = CPlusPlusCardFragment()
        val javascriptCard1 = JavascriptCardFragment()
        val javascriptCard2 = JavascriptCardFragment()
        val goCard1 = GoCardFragment()
        val goCard2 = GoCardFragment()

        val languagesCards = listOf<Fragment>(
            kotlinCard1,
            kotlinCard2,
            cCard1,
            cCard2,
            pythonCard1,
            pythonCard2,
            javaCard1,
            javaCard2,
            cSharpCard1,
            cSharpCard2,
            cPlusPlusCard1,
            cPlusPlusCard2,
            javascriptCard1,
            javascriptCard2,
            goCard1,
            goCard2
        )

        setCardsOrdering(languagesCards)

        val card1 = Card(supportFragmentManager, cardContainer1, cardsOrdering.getValue(1), backCard1)
        val card2 = Card(supportFragmentManager, cardContainer2, cardsOrdering.getValue(2), backCard2)
        val card3 = Card(supportFragmentManager, cardContainer3, cardsOrdering.getValue(3), backCard3)
        val card4 = Card(supportFragmentManager, cardContainer4, cardsOrdering.getValue(4), backCard4)
        val card5 = Card(supportFragmentManager, cardContainer5, cardsOrdering.getValue(5), backCard5)
        val card6 = Card(supportFragmentManager, cardContainer6, cardsOrdering.getValue(6), backCard6)
        val card7 = Card(supportFragmentManager, cardContainer7, cardsOrdering.getValue(7), backCard7)
        val card8 = Card(supportFragmentManager, cardContainer8, cardsOrdering.getValue(8), backCard8)
        val card9 = Card(supportFragmentManager, cardContainer9, cardsOrdering.getValue(9), backCard9)
        val card10 = Card(supportFragmentManager, cardContainer10, cardsOrdering.getValue(10), backCard10)
        val card11 = Card(supportFragmentManager, cardContainer11, cardsOrdering.getValue(11), backCard11)
        val card12 = Card(supportFragmentManager, cardContainer12, cardsOrdering.getValue(12), backCard12)
        val card13 = Card(supportFragmentManager, cardContainer13, cardsOrdering.getValue(13), backCard13)
        val card14 = Card(supportFragmentManager, cardContainer14, cardsOrdering.getValue(14), backCard14)
        val card15 = Card(supportFragmentManager, cardContainer15, cardsOrdering.getValue(15), backCard15)
        val card16 = Card(supportFragmentManager, cardContainer16, cardsOrdering.getValue(16), backCard16)

        val userName: String? = intent.getStringExtra("username")
        val testYourself: String? = intent.getStringExtra("test_yourself")
        setUserName(userName)
        Toast.makeText(applicationContext, testYourself, Toast.LENGTH_SHORT).show()

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

        cardContainer5.setOnClickListener {
            card5.toggle()
        }

        cardContainer6.setOnClickListener {
            card6.toggle()
        }

        cardContainer7.setOnClickListener {
            card7.toggle()
        }

        cardContainer8.setOnClickListener {
            card8.toggle()
        }

        cardContainer9.setOnClickListener {
            card9.toggle()
        }

        cardContainer10.setOnClickListener {
            card10.toggle()
        }

        cardContainer11.setOnClickListener {
            card11.toggle()
        }

        cardContainer12.setOnClickListener {
            card12.toggle()
        }

        cardContainer13.setOnClickListener {
            card13.toggle()
        }

        cardContainer14.setOnClickListener {
            card14.toggle()
        }

        cardContainer15.setOnClickListener {
            card15.toggle()
        }

        cardContainer16.setOnClickListener {
            card16.toggle()
        }
    }

    private fun setCardsOrdering(languagesCards: List<Fragment>) {
        cardsOrdering[1] = languagesCards[0]
        cardsOrdering[2] = languagesCards[5]
        cardsOrdering[3] = languagesCards[1]
        cardsOrdering[4] = languagesCards[10]
        cardsOrdering[5] = languagesCards[9]
        cardsOrdering[6] = languagesCards[6]
        cardsOrdering[7] = languagesCards[8]
        cardsOrdering[8] = languagesCards[2]
        cardsOrdering[9] = languagesCards[12]
        cardsOrdering[10] = languagesCards[7]
        cardsOrdering[11] = languagesCards[13]
        cardsOrdering[12] = languagesCards[15]
        cardsOrdering[13] = languagesCards[3]
        cardsOrdering[14] = languagesCards[14]
        cardsOrdering[15] = languagesCards[11]
        cardsOrdering[16] = languagesCards[4]
    }

    private fun setUserName(userName: String?) {
        tvUsername.text = userName
    }

    private fun setFoundPairs() {

    }

    private fun countPairs() {

    }

    private fun countActiveCards() {

    }

    private fun hideTwoCards() {

    }
}