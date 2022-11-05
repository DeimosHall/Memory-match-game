package com.deimoshall.matchprogramminglanguages

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class Card(
    context: Context,
    private val fragmentManager: FragmentManager,
    private val cardContainer: View,
    private val languageCard: Fragment,
    private val languageCardName: String,
    private val backCard: Fragment) {

    private var musicPlayer = MediaPlayer.create(context, R.raw.toggle_card)
    var isVisible: Boolean = false

    fun toggle() {
        playToggleSound()

        if (isVisible) {
            isVisible = false

            //Log.d("myTag", "$languageCard, $backCard isVisible: ${this.isVisible}")
            //Log.d("myTag", "Tag: ${cardContainer.tag}, card: $languageCard")
            try {
                fragmentManager.commit {
                    replace(cardContainer.id, backCard)
                    setReorderingAllowed(true)
                }
            } catch (e: Exception) {
                Log.d("myTag", "Toggle card error: $e")
            }
        } else {
            isVisible = true

            //Log.d("myTag", "$languageCard, $backCard isVisible: ${this.isVisible}")
            try {
                fragmentManager.commit {
                    replace(cardContainer.id, languageCard)
                    setReorderingAllowed(true)
                }
            } catch (e: Exception) {
                Log.d("myTag", "Toggle card error: $e")
            }
        }
    }

    private fun playToggleSound() {
        musicPlayer.start()
    }

    fun getName(): String {
        return languageCardName
    }

    fun blockClick() {
        cardContainer.isEnabled = false
    }

    fun allowClick() {
        cardContainer.isEnabled = true
    }
}