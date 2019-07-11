package com.gameforeverything.stringtests

import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtensionsKtTest {
    private val standard = "We test coders. Give us a try?"
    private val secondSample = "Forget  CVs..Save time . x x"

    @Test
    fun `getSolution will return values specified as per the test`() {
        assertEquals(4, standard.solution)
        assertEquals(2, secondSample.solution)
        assertEquals(-1,"".solution)
        assertEquals(0," . . ".solution)
    }

    @Test
    fun `number of sentences will return the correct number as specified at note 1`() {
        // arrange
        // act
        val actual = standard.numberOfSentences

        // assert
        assertEquals(3, actual)
    }

    @Test
    fun `test splitting the string return the expected sentence`() {
        // arrange

        // act
        val actual = standard.sentencesByLength
        val expected = listOf(
            SentenceResult( 3, "We test coders"),
            SentenceResult( 4, " Give us a try"),
            SentenceResult( 0, ""))

        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun `test splitting the string return the expected sentence at note 2`() {
        // arrange
        // act
        val actual = secondSample.sentencesByLength
        val expected = listOf(
            SentenceResult(2 ,"Forget  CVs"),
            SentenceResult( 0,""),
            SentenceResult(2 , "Save time "),
            SentenceResult( 2 , " x x"))

        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun `number of words will return desired values`() {
        // arrange
        val sampleText1 = "We test coders"
        val sampleText2 = "Give us a try"

        // act
        // assert
        assertEquals(3, sampleText1.numberOfWords)
        assertEquals(4, sampleText2.numberOfWords)
        assertEquals(0, "".numberOfWords)
        assertEquals(1, "one".numberOfWords)
        assertEquals(1, " one".numberOfWords)
        assertEquals(1, " one       ".numberOfWords)
        assertEquals(4, " one ee  ee  ee  ".numberOfWords)
    }
}