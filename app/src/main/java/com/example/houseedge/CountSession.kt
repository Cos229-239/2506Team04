package com.example.houseedge

class CountSession(val playerName : String, val tableName : String,
                   val seatNumber : Int, val deckCount :Int )
{
    private var runningCount = 0
    private var decksRemaining = deckCount

    //Operator input is pushed onto the countStack
    private val countStack :MutableList<String> = mutableListOf()
    private var trueCount = 0       // trueCount = runningCount/decksRemaining
    private var hand = 1
    private var wager = 0
    private var wagerAdvantage = 0
    private var wagerDisadvantage = 0

    fun UndoLastInput()
    {
        //pops last off of countStack then recalculates allowing operator to fix their mistake

    }

    fun CalculateTrueCount()
    {
        if (decksRemaining > 0)
        {
            this.trueCount = runningCount / decksRemaining
        }

    }
    fun setRunningCount( newRCount : Int)
    {
        runningCount = newRCount
    }
    fun getRunningCount() : Int
    {
        return runningCount;
    }
    fun getDecksRemaining() : Int
    {
        return decksRemaining;
    }
    fun setDecksRemaining(newDecksRemaining : Int)
    {
        decksRemaining = newDecksRemaining
    }
    fun getTrueCount() : Int
    {
        return trueCount
    }
    fun setWager( newWager : Int)
    {
        wager = newWager
    }
    fun getWager() : Int
    {
        return wager;
    }
    fun setWagerAdvantage( newAdvantage : Int)
    {
        wagerAdvantage = newAdvantage
    }
    fun getWagerAdvantage() : Int
    {
        return wagerAdvantage;
    }
    fun setWagerDisadvantage( newDisad : Int)
    {
        wagerDisadvantage = newDisad
    }
    fun getWagerDisadvantage() : Int
    {
        return wagerDisadvantage;
    }
    fun setHand( newHand : Int)
    {
        hand = newHand
    }
    fun getHand() : Int
    {
        return hand;
    }






}