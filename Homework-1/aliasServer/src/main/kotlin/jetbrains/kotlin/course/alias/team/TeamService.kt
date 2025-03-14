// Define the package related to teams in the alias game
package jetbrains.kotlin.course.alias.team

// Import all the necessary classes and annotations (including the ones you created from the utility classes)
import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

// Annotate the 'TeamService' class with '@Service',
// which indicates that it is a service component in the Spring framework
// This class will contain the logic related to the teams in the game
@Service
class TeamService {

    // Create an instance of the 'IdentifierFactory' class, which is used to generate unique identifiers for the teams
    private val identifierFactory = IdentifierFactory()

    // Companion object allows the creation of static-like properties and methods (Kotlin stuff)
    companion object {

        // 'teamsStorage' is a mutable map that stores teams using their unique identifiers as the key (think PK)
        // It maps an 'Identifier' (Int) to a 'Team' object
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    // Define a method that generates a list of teams for one round, based on the number of teams needed
    // 'teamsNumber' is the count parameter that specifies how many teams to generate
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {

        // Create a list of 'teamsNumber' length
        // For each element, a new 'Team' object is created with a unique identifier generated by the 'IdentifierFactory'
        val teams = List(teamsNumber) {
            val id = identifierFactory.uniqueIdentifier()  // This will get a unique id for a team
            Team(id)  // This creates a new Team object with the unique identifier
        }

        // Iterate over each generated team and add it to the 'teamsStorage' map,
        // using the team's unique identifier as the key
        teams.forEach { teamsStorage[it.id] = it }

        // Returns the list of generated teams
        return teams
    }
}
