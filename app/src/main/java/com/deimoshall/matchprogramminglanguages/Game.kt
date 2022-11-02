package com.deimoshall.matchprogramminglanguages

import android.content.Context
import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.TextView

class Game() {
    private var foundPairs: Int = 0
    private var visibleCards: Int = 0
    private var currentVisibleCards = mutableListOf<Card>()

    fun run(card: Card) {
        countVisibleCards(card)
        //currentVisibleCards.forEachIndexed { index, view -> Log.d("myTAG", "Card $index: ${view.getName()}") }
    }

    fun getFoundPairs(): Int {
        return foundPairs
    }

    private fun arePairs(): Boolean {
        Log.d("myTAG", "Count pairs: ${currentVisibleCards[0].getName() == currentVisibleCards[1].getName()}")
        if (currentVisibleCards[0].getName() == currentVisibleCards[1].getName()) {
            currentVisibleCards.forEach { it.blockClick() }
            foundPairs++
            return true
        } else {
            return false
        }
    }

    private fun hideTwoCards() {
        if (visibleCards == 2) {
            visibleCards = 0
            if (!arePairs()) {
                Thread.sleep(500)
                currentVisibleCards.forEach { it.toggle() }
            }
            currentVisibleCards.clear()
        }
    }

    private fun countVisibleCards(card: Card) {
        if (card.isVisible) {
            currentVisibleCards.add(card)
            visibleCards++
        }
        hideTwoCards()
    }
}