package com.deimoshall.matchprogramminglanguages

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.deimoshall.matchprogramminglanguages.databinding.ActivityMainBinding
import com.deimoshall.matchprogramminglanguages.dialogs.LoseGameDialogFragment
import com.deimoshall.matchprogramminglanguages.dialogs.WinGameDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var attempts: Double = 0.0
    private lateinit var musicPlayer: MediaPlayer
    private val game = Game(this)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        val card1 = Card(this, supportFragmentManager, binding.cardContainer1, cards[0][0] as Fragment, cards[0][1] as String, backCard1)
        val card2 = Card(this, supportFragmentManager, binding.cardContainer2, cards[1][0] as Fragment, cards[1][1] as String, backCard2)
        val card3 = Card(this, supportFragmentManager, binding.cardContainer3, cards[2][0] as Fragment, cards[2][1] as String, backCard3)
        val card4 = Card(this, supportFragmentManager, binding.cardContainer4, cards[3][0] as Fragment, cards[3][1] as String, backCard4)
        val card5 = Card(this, supportFragmentManager, binding.cardContainer5, cards[4][0] as Fragment, cards[4][1] as String, backCard5)
        val card6 = Card(this, supportFragmentManager, binding.cardContainer6, cards[5][0] as Fragment, cards[5][1] as String, backCard6)
        val card7 = Card(this, supportFragmentManager, binding.cardContainer7, cards[6][0] as Fragment, cards[6][1] as String, backCard7)
        val card8 = Card(this, supportFragmentManager, binding.cardContainer8, cards[7][0] as Fragment, cards[7][1] as String, backCard8)
        val card9 = Card(this, supportFragmentManager, binding.cardContainer9, cards[8][0] as Fragment, cards[8][1] as String, backCard9)
        val card10 = Card(this, supportFragmentManager, binding.cardContainer10, cards[9][0] as Fragment, cards[9][1] as String, backCard10)
        val card11 = Card(this, supportFragmentManager, binding.cardContainer11, cards[10][0] as Fragment, cards[10][1] as String, backCard11)
        val card12 = Card(this, supportFragmentManager, binding.cardContainer12, cards[11][0] as Fragment, cards[11][1] as String, backCard12)
        val card13 = Card(this, supportFragmentManager, binding.cardContainer13, cards[12][0] as Fragment, cards[12][1] as String, backCard13)
        val card14 = Card(this, supportFragmentManager, binding.cardContainer14, cards[13][0] as Fragment, cards[13][1] as String, backCard14)
        val card15 = Card(this, supportFragmentManager, binding.cardContainer15, cards[14][0] as Fragment, cards[14][1] as String, backCard15)
        val card16 = Card(this, supportFragmentManager, binding.cardContainer16, cards[15][0] as Fragment, cards[15][1] as String, backCard16)

        binding.cardContainer1.setOnClickListener { cardClick(card1) }
        binding.cardContainer2.setOnClickListener { cardClick(card2) }
        binding.cardContainer3.setOnClickListener { cardClick(card3) }
        binding.cardContainer4.setOnClickListener { cardClick(card4) }
        binding.cardContainer5.setOnClickListener { cardClick(card5) }
        binding.cardContainer6.setOnClickListener { cardClick(card6) }
        binding.cardContainer7.setOnClickListener { cardClick(card7) }
        binding.cardContainer8.setOnClickListener { cardClick(card8) }
        binding.cardContainer9.setOnClickListener { cardClick(card9) }
        binding.cardContainer10.setOnClickListener { cardClick(card10) }
        binding.cardContainer11.setOnClickListener { cardClick(card11) }
        binding.cardContainer12.setOnClickListener { cardClick(card12) }
        binding.cardContainer13.setOnClickListener { cardClick(card13) }
        binding.cardContainer14.setOnClickListener { cardClick(card14) }
        binding.cardContainer15.setOnClickListener { cardClick(card15) }
        binding.cardContainer16.setOnClickListener { cardClick(card16) }
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

    private fun init() {
        musicPlayer = MediaPlayer.create(this, R.raw.it_s_a_good_practice_bro)
        musicPlayer.start()
        musicPlayer.setVolume(0.2f, 0.2f)
        musicPlayer.isLooping = true

        val userName: String? = intent.getStringExtra("username")
        val testYourself: String? = intent.getStringExtra("test_yourself")
        attempts = intent.getStringExtra("attempts")!!.toDouble()

        if (testYourself == "false") {
            binding.tvAttempts.isVisible = false
            attempts = 100.0 // This avoids to lose the game, I guess
        }

        cards.shuffle()

        setUserName(userName)
        setPoints()
        setAttempts()
    }

    private fun cardClick(card: Card) {
        card.toggle()
        updateAttempts()
        lifecycleScope.launch {
            withContext(Dispatchers.IO) { game.run(card) }
            setPoints(game.getFoundPairs())
            winOrLoseListener(game.getFoundPairs())
        }
    }

    private fun setUserName(userName: String?) {
        binding.tvUsername.text = userName
    }

    private fun setPoints(pairs: Int = 0) {
        binding.tvPoints.text = "${getString(R.string.points)} ${pairs * 100}"
    }

    private fun updateAttempts() {
        attempts -= 0.5
        setAttempts()
    }

    private fun setAttempts() {
        binding.tvAttempts.text = "${getString(R.string.attempts)} ${attempts.toInt()}"
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
        when {
            pairs == 8 && attempts > -0.5 -> winGame()
            attempts == 0.0 -> loseGame()
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