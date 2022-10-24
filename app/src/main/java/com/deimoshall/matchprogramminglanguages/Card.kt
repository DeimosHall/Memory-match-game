package com.deimoshall.matchprogramminglanguages

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class Card(
    private val fragmentManager: FragmentManager,
    private val cardContainer: View,
    private val languageCard: Fragment,
    private val backCard: Fragment) {

    private var isVisible: Boolean = false

    fun toggle() {
        if (isVisible) {
            isVisible = false

            Log.d("myTag", "$languageCard, $backCard isVisible: $isVisible")
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

            Log.d("myTag", "$languageCard, $backCard isVisible: $isVisible")
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
}