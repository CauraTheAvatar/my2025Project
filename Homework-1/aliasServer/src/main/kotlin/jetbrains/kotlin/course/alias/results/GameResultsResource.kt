// Define the package related to game results in the alias course
package jetbrains.kotlin.course.alias.results

// Import necessary classes and functions from other packages
import alias.JsTeam
import jetbrains.kotlin.course.alias.util.toGameResult
import org.springframework.web.bind.annotation.*

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

// We can not use a typealias here because the Spring framework can not parse it
// So a separate class is defined for it instead
class GameJsResult : ArrayList<JsTeam>()

// Annotate this class with '@RestController' to indicate that it is a Spring RESTful controller
@RestController

// Map all the requests under the '/api/results/' URL path to this controller
@RequestMapping("/api/results/")
class GameResultsResource(val service: GameResultsService) {

    // Allow cross-origin requests (CORS) to this endpoint
    @CrossOrigin

    // Define a POST endpoint at '/api/results/save' for saving game results
    @PostMapping("/save")
    fun saveGameResults(@RequestBody result: GameJsResult) {

        // Convert the received game result to a format understood by the service and save it
        service.saveGameResults(result.toGameResult())
    }

    // Allow cross-origin requests (CORS) to this endpoint
    @CrossOrigin
    // Define a GET endpoint at '/api/results/all' to retrieve all saved games results
    @GetMapping("/all")
    fun getAllGameResults(): List<List<Team>> = service.getAllGameResults()
}
