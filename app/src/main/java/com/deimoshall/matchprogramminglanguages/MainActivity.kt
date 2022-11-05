package com.deimoshall.matchprogramminglanguages

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.deimoshall.matchprogramminglanguages.dialogs.LoseGameDialogFragment
import com.deimoshall.matchprogramminglanguages.dialogs.WinGameDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {

    private var cardsOrdering = mutableListOf<Fragment>()
    private var cardNames = mutableListOf<String>()
    private var attempts: Double = 0.0
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
    private lateinit var tvPoints: TextView
    private lateinit var tvAttempts: TextView
    lateinit var musicPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicPlayer = MediaPlayer.create(this, R.raw.it_s_a_good_practice_bro)
        musicPlayer.start()
        musicPlayer.setVolume(0.2f, 0.2f)
        musicPlayer.isLooping = true

        tvUsername = findViewById(R.id.tv_username)
        tvPoints = findViewById(R.id.tv_points)
        tvAttempts = findViewById(R.id.tv_attempts)

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

        val languagesCards = mutableListOf(
            listOf(kotlinCard1, kotlinCard1.name),
            listOf(kotlinCard2, kotlinCard2.name),
            listOf(cCard1, cCard1.name),
            listOf(cCard2, cCard2.name),
            listOf(pythonCard1, pythonCard1.name),
            listOf(pythonCard2, pythonCard2.name),
            listOf(javaCard1, javaCard1.name),
            listOf(javaCard2, javaCard2.name),
            listOf(cSharpCard1, cSharpCard1.name),
            listOf(cSharpCard2, cSharpCard2.name),
            listOf(cPlusPlusCard1, cPlusPlusCard1.name),
            listOf(cPlusPlusCard2, cPlusPlusCard2.name),
            listOf(javascriptCard1, javascriptCard1.name),
            listOf(javascriptCard2, javascriptCard2.name),
            listOf(goCard1, goCard1.name),
            listOf(goCard2, goCard2.name)
        )
        languagesCards.shuffle()

        val card1 = Card(this, supportFragmentManager, cardContainer1, languagesCards[0][0] as Fragment, languagesCards[0][1] as String, backCard1)
        val card2 = Card(this, supportFragmentManager, cardContainer2, languagesCards[1][0] as Fragment, languagesCards[1][1] as String, backCard2)
        val card3 = Card(this, supportFragmentManager, cardContainer3, languagesCards[2][0] as Fragment, languagesCards[2][1] as String, backCard3)
        val card4 = Card(this, supportFragmentManager, cardContainer4, languagesCards[3][0] as Fragment, languagesCards[3][1] as String, backCard4)
        val card5 = Card(this, supportFragmentManager, cardContainer5, languagesCards[4][0] as Fragment, languagesCards[4][1] as String, backCard5)
        val card6 = Card(this, supportFragmentManager, cardContainer6, languagesCards[5][0] as Fragment, languagesCards[5][1] as String, backCard6)
        val card7 = Card(this, supportFragmentManager, cardContainer7, languagesCards[6][0] as Fragment, languagesCards[6][1] as String, backCard7)
        val card8 = Card(this, supportFragmentManager, cardContainer8, languagesCards[7][0] as Fragment, languagesCards[7][1] as String, backCard8)
        val card9 = Card(this, supportFragmentManager, cardContainer9, languagesCards[8][0] as Fragment, languagesCards[8][1] as String, backCard9)
        val card10 = Card(this, supportFragmentManager, cardContainer10, languagesCards[9][0] as Fragment, languagesCards[9][1] as String, backCard10)
        val card11 = Card(this, supportFragmentManager, cardContainer11, languagesCards[10][0] as Fragment, languagesCards[10][1] as String, backCard11)
        val card12 = Card(this, supportFragmentManager, cardContainer12, languagesCards[11][0] as Fragment, languagesCards[11][1] as String, backCard12)
        val card13 = Card(this, supportFragmentManager, cardContainer13, languagesCards[12][0] as Fragment, languagesCards[12][1] as String, backCard13)
        val card14 = Card(this, supportFragmentManager, cardContainer14, languagesCards[13][0] as Fragment, languagesCards[13][1] as String, backCard14)
        val card15 = Card(this, supportFragmentManager, cardContainer15, languagesCards[14][0] as Fragment, languagesCards[14][1] as String, backCard15)
        val card16 = Card(this, supportFragmentManager, cardContainer16, languagesCards[15][0] as Fragment, languagesCards[15][1] as String, backCard16)

        val game = Game(this)

        val userName: String? = intent.getStringExtra("username")
        val testYourself: String? = intent.getStringExtra("test_yourself")
        attempts = intent.getStringExtra("attempts")!!.toDouble()

        if (testYourself == "false") {
            tvAttempts.isVisible = false
            attempts = 100.0 // This avoids to lose the game, I guess
        }

        setUserName(userName)
        setPoints()
        setAttempts()

        cardContainer1.setOnClickListener {
            card1.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card1) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer2.setOnClickListener {
            card2.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card2) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer3.setOnClickListener {
            card3.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card3) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer4.setOnClickListener {
            card4.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card4) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer5.setOnClickListener {
            card5.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card5) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer6.setOnClickListener {
            card6.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card6) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer7.setOnClickListener {
            card7.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card7) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer8.setOnClickListener {
            card8.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card8) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer9.setOnClickListener {
            card9.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card9) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer10.setOnClickListener {
            card10.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card10) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }

        }

        cardContainer11.setOnClickListener {
            card11.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card11) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer12.setOnClickListener {
            card12.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card12) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer13.setOnClickListener {
            card13.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card13) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer14.setOnClickListener {
            card14.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card14) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer15.setOnClickListener {
            card15.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card15) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
            }
        }

        cardContainer16.setOnClickListener {
            card16.toggle()
            updateAttempts()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) { game.run(card16) }
                setPoints(game.getFoundPairs())
                winOrLoseListener(game.getFoundPairs())
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

    private fun setUserName(userName: String?) {
        tvUsername.text = userName
    }

    private fun setPoints(pairs: Int = 0) {
        tvPoints.text = "${getString(R.string.points)} ${pairs * 100}"
    }

    private fun updateAttempts() {
        attempts -= 0.5
        setAttempts()
    }

    private fun setAttempts() {
        tvAttempts.text = "${getString(R.string.attempts)} ${attempts.toInt()}"
    }

    private fun playWinSound() {
        val soundPlayer = MediaPlayer.create(this, R.raw.win_game)
        soundPlayer.start()
    }

    private fun playLoseSound() {
        val soundPlayer = MediaPlayer.create(this, R.raw.lose_game)
        soundPlayer.start()
    }

    private fun restartGame() {
        startActivity(intent)
        finish()
    }

    private fun winOrLoseListener(pairs: Int) {
        if (pairs == 8 && attempts > 0.0) {
            winGame()
        }
        if (attempts == 0.0) {
            loseGame()
        }
    }

    private fun winGame() {
        playWinSound()

        WinGameDialogFragment(
            onSubmitClickListener = { restartGame() }
        ).show(supportFragmentManager, "WIN_DIALOG")
    }

    private fun loseGame() {
        playLoseSound()

        LoseGameDialogFragment(
            onSubmitClickListener = { restartGame()}
        ).show(supportFragmentManager, "LOSE_DIALOG")
    }
}