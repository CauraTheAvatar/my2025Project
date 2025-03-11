// Define a package for utility functions and classes related to identifiers
package jetbrains.kotlin.course.alias.util

// Create a type alias 'Identifier' for the 'Int' type
// This means that wherever 'Identifier' is used, it's the same as using an 'Int'
typealias Identifier = Int

// Define the 'IdentifierFactory' class, which is responsible for generating unique identifiers
class IdentifierFactory {

    // Declare a private mutable property 'counter' of type 'Identifier'
    // This will track the next available unique identifier
    private var counter: Identifier = 0

    // Define a method 'uniqueIdentifier', which returns the current unique identifer
    // Increment the counter for the next call
    fun uniqueIdentifier(): Identifier {
        return counter++  // After the increment, this function returns the current 'counter' value, and then increments that
    }
}