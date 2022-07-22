package com.example.epikgames.blackjack

import blackjack.CardImages

import org.junit.Test
import junit.framework.TestCase.assertNotSame
import junit.framework.TestCase.assertEquals

class CardImagesTest {
    private val cardImages = CardImages
    private val map = cardImages.getMap()

    @Test
    fun cardImagesSize() {
        assertEquals(map.size, 52)
    }

    // 1 in 1521 chance of failing
    @Test
    fun randomCard() {
        assertNotSame(cardImages.getRandomCard(), cardImages.getRandomCard())
    }
}