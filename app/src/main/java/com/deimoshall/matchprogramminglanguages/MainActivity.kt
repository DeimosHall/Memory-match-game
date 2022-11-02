package com.deimoshall.matchprogramminglanguages

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var cardsOrdering = mutableMapOf<Int, Fragment>()
    private var cardNames = mutableMapOf<Int, String>()
    private var attempts: Int = 20
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
    lateinit var musicPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicPlayer = MediaPlayer.create(this, R.raw.it_s_a_good_practice_bro)
        musicPlayer.start()
        musicPlayer.isLooping = true

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

        val languagesCards = listOf(
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

        val languagesCardNames = listOf(
            kotlinCard1.name,
            kotlinCard2.name,
            cCard1.name,
            cCard2.name,
            pythonCard1.name,
            pythonCard2.name,
            javaCard1.name,
            javaCard2.name,
            cSharpCard1.name,
            cSharpCard2.name,
            cPlusPlusCard1.name,
            cPlusPlusCard2.name,
            javascriptCard1.name,
            javascriptCard2.name,
            goCard1.name,
            goCard2.name
        )

        setCardsOrdering(languagesCards, languagesCardNames)

        val card1 = Card(supportFragmentManager, cardContainer1, cardsOrdering.getValue(1), cardNames.getValue(1), backCard1)
        val card2 = Card(supportFragmentManager, cardContainer2, cardsOrdering.getValue(2), cardNames.getValue(2), backCard2)
        val card3 = Card(supportFragmentManager, cardContainer3, cardsOrdering.getValue(3), cardNames.getValue(3), backCard3)
        val card4 = Card(supportFragmentManager, cardContainer4, cardsOrdering.getValue(4), cardNames.getValue(4), backCard4)
        val card5 = Card(supportFragmentManager, cardContainer5, cardsOrdering.getValue(5), cardNames.getValue(5), backCard5)
        val card6 = Card(supportFragmentManager, cardContainer6, cardsOrdering.getValue(6), cardNames.getValue(6), backCard6)
        val card7 = Card(supportFragmentManager, cardContainer7, cardsOrdering.getValue(7), cardNames.getValue(7), backCard7)
        val card8 = Card(supportFragmentManager, cardContainer8, cardsOrdering.getValue(8), cardNames.getValue(8), backCard8)
        val card9 = Card(supportFragmentManager, cardContainer9, cardsOrdering.getValue(9), cardNames.getValue(9), backCard9)
        val card10 = Card(supportFragmentManager, cardContainer10, cardsOrdering.getValue(10), cardNames.getValue(10), backCard10)
        val card11 = Card(supportFragmentManager, cardContainer11, cardsOrdering.getValue(11), cardNames.getValue(11), backCard11)
        val card12 = Card(supportFragmentManager, cardContainer12, cardsOrdering.getValue(12), cardNames.getValue(12), backCard12)
        val card13 = Card(supportFragmentManager, cardContainer13, cardsOrdering.getValue(13), cardNames.getValue(13), backCard13)
        val card14 = Card(supportFragmentManager, cardContainer14, cardsOrdering.getValue(14), cardNames.getValue(14), backCard14)
        val card15 = Card(supportFragmentManager, cardContainer15, cardsOrdering.getValue(15), cardNames.getValue(15), backCard15)
        val card16 = Card(supportFragmentManager, cardContainer16, cardsOrdering.getValue(16), cardNames.getValue(16), backCard16)

        val game = Game()

        val userName: String? = intent.getStringExtra("username")
        val testYourself: String? = intent.getStringExtra("test_yourself")
        setUserName(userName)

        cardContainer1.setOnClickListener {
            card1.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card1) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer2.setOnClickListener {
            card2.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card2) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer3.setOnClickListener {
            card3.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card3) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer4.setOnClickListener {
            card4.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card4) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer5.setOnClickListener {
            card5.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card5) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer6.setOnClickListener {
            card6.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card6) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer7.setOnClickListener {
            card7.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card7) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer8.setOnClickListener {
            card8.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card8) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer9.setOnClickListener {
            card9.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card9) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer10.setOnClickListener {
            card10.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card10) }
                setFoundPairs(game.getFoundPairs())
            }

        }

        cardContainer11.setOnClickListener {
            card11.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card11) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer12.setOnClickListener {
            card12.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card12) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer13.setOnClickListener {
            card13.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card13) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer14.setOnClickListener {
            card14.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card14) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer15.setOnClickListener {
            card15.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card15) }
                setFoundPairs(game.getFoundPairs())
            }
        }

        cardContainer16.setOnClickListener {
            card16.toggle()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card16) }
                setFoundPairs(game.getFoundPairs())
            }
        }
    }

    override fun onPause() {
        super.onPause()

        musicPlayer.pause()
    }

    override fun onResume() {
        super.onResume()

        musicPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        musicPlayer.release()
    }

    private fun setCardsOrdering(languagesCards: List<Fragment>, languagesCardNames: List<String>) {
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

        cardNames[1] = languagesCardNames[0]
        cardNames[2] = languagesCardNames[5]
        cardNames[3] = languagesCardNames[1]
        cardNames[4] = languagesCardNames[10]
        cardNames[5] = languagesCardNames[9]
        cardNames[6] = languagesCardNames[6]
        cardNames[7] = languagesCardNames[8]
        cardNames[8] = languagesCardNames[2]
        cardNames[9] = languagesCardNames[12]
        cardNames[10] = languagesCardNames[7]
        cardNames[11] = languagesCardNames[13]
        cardNames[12] = languagesCardNames[15]
        cardNames[13] = languagesCardNames[3]
        cardNames[14] = languagesCardNames[14]
        cardNames[15] = languagesCardNames[11]
        cardNames[16] = languagesCardNames[4]
    }

    private fun setUserName(userName: String?) {
        tvUsername.text = userName
    }

    private fun setFoundPairs(pairs: Int) {
        tvFoundPairs.text = getString(R.string.found_pairs) + " " + pairs
    }
}