package com.example.houseedge

import androidx.compose.runtime.*


class CountSession(val playerName : String, val tableName : String,
                   val seatNumber : Int, val deckCount :Int )
{
    var runningCount by mutableIntStateOf(0)
        private set
    private var decksRemaining = deckCount

    //Operator input is pushed onto the countStack
    private val countStack :MutableList<String> = mutableListOf()
    private var trueCount = 0       // trueCount = runningCount/decksRemaining
    var hand by mutableIntStateOf(1)
        private set
    var wager by mutableIntStateOf(0)
    private var wagerAdvantage = 0
    private var wagerDisadvantage = 0

    fun undoLastInput()
    {
        //pops last off of countStack then recalculates allowing operator to fix their mistake

    }

    fun calculateTrueCount()
    {
        if (decksRemaining > 0)
        {
            this.trueCount = runningCount / decksRemaining
        }

    }
    fun updateRunningCount( newRCount : Int)
    {
        runningCount = newRCount
    }
    fun getDecksRemaining() : Int
    {
        return decksRemaining
    }
    fun setDecksRemaining(newDecksRemaining : Int)
    {
        decksRemaining = newDecksRemaining
    }
    fun getTrueCount() : Int
    {
        return trueCount
    }
    fun setWagerAdvantage( newAdvantage : Int)
    {
        wagerAdvantage = newAdvantage
    }
    fun getWagerAdvantage() : Int
    {
        return wagerAdvantage
    }
    fun setWagerDisadvantage( newDisad : Int)
    {
        wagerDisadvantage = newDisad
    }
    fun getWagerDisadvantage() : Int
    {
        return wagerDisadvantage
    }
    fun updateHand()
    {
        hand++
    }
}