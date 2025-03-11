// Define the package related to the cards in the alias game
package jetbrains.kotlin.course.alias.card

// Import the necessary Identifier class from the utility packaage (it's not used, but still)
import jetbrains.kotlin.course.alias.util.Identifier

// Define a data class named 'Card', which will represent a card object in the game
data class Card(

    // 'id' is a property that holds the unique identifier for the card, repped by an integer
    val id: Identifier,

    // 'words' is an array of strings that holds the words associated with the card
    // These are the words that will be used during the game (found in jetbrains.kotlin.course.alias.util.Words.kt)
    val words: List<Word>


)