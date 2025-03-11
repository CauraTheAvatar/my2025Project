// Define the package related to cards in the alias course
package jetbrains.kotlin.course.alias.card

// Import necessary classes
import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

// Annotate the 'CardService' class with '@Service', which marks it as a Spring service component
// This class will contain business logic related to the cards in the game
@Service
class CardService {

    // Create an instance of the 'IdentifierFactory' to generate unique ids for the cards
    private val identifierFactory = IdentifierFactory()

    // Define a list of words that will be used to generate cards
    private val words = listOf(
        // Used words from Words.kt for consistency and to avoid unnecessary bugs
        "afterthought",
        "boundary",
        "canvas",
        "daughter",
        "eye",
        "flight",
        "glass",
        "hands"
    )

    // Generate a list of cards by calling the 'generateCards' function
    private val cards = generateCards()

    // Companion object is used for static-like members in Kotlin
    // It defines constants and static variables
    companion object {
        // Definie the constant 'WORDS_IN_CARD', which indicates how many words each card will contain (four in this case)
        private const val WORDS_IN_CARD = 4

        // Calculate the number of cards based on the size of the 'words' list,
        // divided by the number of words per card
        private val cardsAmount = words.size / WORDS_IN_CARD
    }

    // Define a method to generate cards from the 'words' list
    // It shuffles the words, splits them into clusters of 4 words per card,
    // and maps each cluster into a 'Card' object with a unique identifier
    private fun generateCards(): List<Card> {
        return words.shuffled()   // Shuffle the list of words to randomise their order
            .chunked(WORDS_IN_CARD)   // Split the shuffled words into clusters of 4 words per cards
            .take(cardsAmount)   // Limit the number of cards to the calculated amount
            .map { Card(identifierFactory.uniqueIdentifier(), it.toWords()) }   // Create a card for each cluster
    }

    // Extension function to convert a list of strings to a list of 'Word' objects
    private fun List<String>.toWords(): List<Word> {
        // Convert each string into a 'Word' object
        return this.map { Word(it) }
    }

    // Define a method to retrieve a card by its index
    // If the index is valid, it returns the card;
    // Else, it throws an 'IllegalArgumentException'
    fun getCardByIndex(index: Int): Card {
        // Safely get a card by the index, or return a defualt if its out of bounds
        return cards.getOrElse(index) {
            // Throw an exception for invalid indices
            throw IllegalArgumentException("Invalid card index")
        }
    }
}
