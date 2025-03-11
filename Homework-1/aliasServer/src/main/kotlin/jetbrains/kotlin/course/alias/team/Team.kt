// Define a data class named 'Team' within the 'jetbrains.kotlin.course.alias.team' package
package jetbrains.kotlin.course.alias.team

// Import the 'Identifier' class from the 'jetbrains.kotlin.course.alias.util' package to be used in this particular class (Team)
import jetbrains.kotlin.course.alias.util.Identifier

// Define the 'Team' data class
data class Team(
    // 'id' = property type of type 'Identifier'
    // It's used to uniquely identify each team in the game
    val id: Identifier,

    // 'points' is a mutable property that stores the team's score/points
    // The default score is obviously 0
    var points: Int = 0
) {

    // 'name' is a read-only property that generates the team's name using its id
    // The team name is of the format "Team#<id+1>", where
    // <id+1> is the unique identifier of the team (think, PK)
    val name: String = "Team#${id + 1}"
}