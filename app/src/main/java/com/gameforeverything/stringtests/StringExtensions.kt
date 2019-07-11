package com.gameforeverything.stringtests

/***
 *      Notes to interviewer
 *
 *      0 -> I chose extension functions as I believe that this is something other team members
 *      would like to use in the future
 *
 *      1 -> While I accept that the brief was to produce a simple Int answer to the problem, I feel that
 *      the next requirement would naturally be to display the String that was the longest hence I created
 *      a data class to hold the String and the number.
 *      This will also allow developing this in a more solid manner
 *
 *      2 -> I have added markers in my test that relate to the markers in the breif.txt file
 */



/**
 * @Note In future a suspending implementation of this function may be included for large strings,
 * for example if I supplied a String that a started `It was the best of times, it was the worst of times ....`
 * (concatenated for brevity) you may well block the UI thread.
 * @Note a blank [String] has a solution of -1
 * @see String.sentencesByLength
 * @returns The number of words in the largest sentence supplied
 */
val String.solution: Int
    get() = solutionResult?.count ?: -1

/**
 * @Note a blank [String] will return null
 * @see String.sentencesByLength
 * @returns The [SentenceResult] for the longest sentence in a given [String]
 */
val String.solutionResult: SentenceResult?
    get() = takeIf { isNotEmpty() }?.sentencesByLength?.maxBy { it.count }

/**
 * @see String.sentencesByLength
 * @returns the Number of sentences in the [String]
 */
val String.numberOfSentences: Int
    get() = sentencesByLength.size

/**
 * @Note A sentence is terminated by either ".", "?", "!"
 * @Note under our definition of a sentence it may be blank, may be all numbers and may not contain a verb
 * @Returns a list of sentences, in the order they were supplied from a [String]
 */
val String.sentencesByLength: List<SentenceResult>
    get() = split(".", "?", "!").mapTo(mutableListOf()) {
        SentenceResult(it.numberOfWords, it)
    }
/**
 * @note This does not check to see that the [String] is a complete sentence
 * @return The number of words in the supplied [String]
 */
val String.numberOfWords: Int
    get() = split(" ").filter { it.isNotEmpty() }.size


data class SentenceResult(
    val count: Int,
    val string: String
) {
    override fun toString(): String = "$string ($count words)"
}