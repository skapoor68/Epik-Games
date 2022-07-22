package blackjack

import com.example.epikgames.R
import kotlin.random.Random

data class Key<Suite, Rank>(val key1: Suite, val key2: Rank)

object CardImages {

    private val cardDrawableMap: MutableMap<Key<*, *>, Int> = HashMap()

    init {
        cardDrawableMap[Key(Suite.SPADE, Rank.ACE)] = R.drawable.ace_of_clubs
        cardDrawableMap[Key(Suite.SPADE, Rank.TWO)] = R.drawable.clubs_2
        cardDrawableMap[Key(Suite.SPADE, Rank.THREE)] = R.drawable.clubs_3
        cardDrawableMap[Key(Suite.SPADE, Rank.FOUR)] = R.drawable.clubs_4
        cardDrawableMap[Key(Suite.SPADE, Rank.FIVE)] = R.drawable.clubs_5
        cardDrawableMap[Key(Suite.SPADE, Rank.SIX)] = R.drawable.clubs_6
        cardDrawableMap[Key(Suite.SPADE, Rank.SEVEN)] = R.drawable.clubs_7
        cardDrawableMap[Key(Suite.SPADE, Rank.EIGHT)] = R.drawable.clubs_8
        cardDrawableMap[Key(Suite.SPADE, Rank.NINE)] = R.drawable.clubs_9
        cardDrawableMap[Key(Suite.SPADE, Rank.TEN)] = R.drawable.clubs_10
        cardDrawableMap[Key(Suite.SPADE, Rank.JACK)] = R.drawable.jack_of_clubs
        cardDrawableMap[Key(Suite.SPADE, Rank.QUEEN)] = R.drawable.queen_of_clubs
        cardDrawableMap[Key(Suite.SPADE, Rank.KING)] = R.drawable.king_of_clubs


        cardDrawableMap[Key(Suite.HEART, Rank.ACE)] = R.drawable.ace_of_hearts
        cardDrawableMap[Key(Suite.HEART, Rank.TWO)] = R.drawable.hearts_2
        cardDrawableMap[Key(Suite.HEART, Rank.THREE)] = R.drawable.hearts_3
        cardDrawableMap[Key(Suite.HEART, Rank.FOUR)] = R.drawable.hearts_4
        cardDrawableMap[Key(Suite.HEART, Rank.FIVE)] = R.drawable.hearts_5
        cardDrawableMap[Key(Suite.HEART, Rank.SIX)] = R.drawable.hearts_6
        cardDrawableMap[Key(Suite.HEART, Rank.SEVEN)] = R.drawable.hearts_7
        cardDrawableMap[Key(Suite.HEART, Rank.EIGHT)] = R.drawable.hearts_8
        cardDrawableMap[Key(Suite.HEART, Rank.NINE)] = R.drawable.hearts_9
        cardDrawableMap[Key(Suite.HEART, Rank.TEN)] = R.drawable.hearts_10
        cardDrawableMap[Key(Suite.HEART, Rank.JACK)] = R.drawable.jack_of_hearts
        cardDrawableMap[Key(Suite.HEART, Rank.QUEEN)] = R.drawable.queen_of_hearts
        cardDrawableMap[Key(Suite.HEART, Rank.KING)] = R.drawable.king_of_hearts


        cardDrawableMap[Key(Suite.DIAMOND, Rank.ACE)] = R.drawable.ace_of_diamonds
        cardDrawableMap[Key(Suite.DIAMOND, Rank.TWO)] = R.drawable.diamonds_2
        cardDrawableMap[Key(Suite.DIAMOND, Rank.THREE)] = R.drawable.diamonds_3
        cardDrawableMap[Key(Suite.DIAMOND, Rank.FOUR)] = R.drawable.diamonds_4
        cardDrawableMap[Key(Suite.DIAMOND, Rank.FIVE)] = R.drawable.diamonds_5
        cardDrawableMap[Key(Suite.DIAMOND, Rank.SIX)] = R.drawable.diamonds_6
        cardDrawableMap[Key(Suite.DIAMOND, Rank.SEVEN)] = R.drawable.diamonds_7
        cardDrawableMap[Key(Suite.DIAMOND, Rank.EIGHT)] = R.drawable.diamonds_8
        cardDrawableMap[Key(Suite.DIAMOND, Rank.NINE)] = R.drawable.diamonds_9
        cardDrawableMap[Key(Suite.DIAMOND, Rank.TEN)] = R.drawable.diamonds_10
        cardDrawableMap[Key(Suite.DIAMOND, Rank.JACK)] = R.drawable.jack_of_diamonds
        cardDrawableMap[Key(Suite.DIAMOND, Rank.QUEEN)] = R.drawable.queen_of_diamonds
        cardDrawableMap[Key(Suite.DIAMOND, Rank.KING)] = R.drawable.king_of_diamonds


        cardDrawableMap[Key(Suite.SPADE, Rank.ACE)] = R.drawable.ace_of_spades
        cardDrawableMap[Key(Suite.SPADE, Rank.TWO)] = R.drawable.spades_2
        cardDrawableMap[Key(Suite.SPADE, Rank.THREE)] = R.drawable.spade_3
        cardDrawableMap[Key(Suite.SPADE, Rank.FOUR)] = R.drawable.spades_4
        cardDrawableMap[Key(Suite.SPADE, Rank.FIVE)] = R.drawable.spades_5
        cardDrawableMap[Key(Suite.SPADE, Rank.SIX)] = R.drawable.spades_6
        cardDrawableMap[Key(Suite.SPADE, Rank.SEVEN)] = R.drawable.spades_7
        cardDrawableMap[Key(Suite.SPADE, Rank.EIGHT)] = R.drawable.spaces_8
        cardDrawableMap[Key(Suite.SPADE, Rank.NINE)] = R.drawable.spades_9
        cardDrawableMap[Key(Suite.SPADE, Rank.TEN)] = R.drawable.spades_10
        cardDrawableMap[Key(Suite.SPADE, Rank.JACK)] = R.drawable.jack_of_spades
        cardDrawableMap[Key(Suite.SPADE, Rank.QUEEN)] = R.drawable.queen_of_spades
        cardDrawableMap[Key(Suite.SPADE, Rank.KING)] = R.drawable.king_of_spades
    }

    fun getCardResource(suite: Suite, rank: Rank): Int? {
        return cardDrawableMap[Key(suite, rank)]
    }
    
    fun getRandomCard(): Int {
        val rand = Random
        return cardDrawableMap.entries.elementAt(rand.nextInt(cardDrawableMap.size)).value
    }

    fun getMap(): MutableMap<Key<*, *>, Int> {
        return cardDrawableMap
    }
}
