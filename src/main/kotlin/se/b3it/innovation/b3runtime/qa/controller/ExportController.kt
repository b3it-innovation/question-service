package se.b3it.innovation.b3runtime.qa.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import se.b3it.innovation.b3runtime.qa.repository.QuestionRepository

/**
 * Created by keyhan on 2017-04-24.
 */
@RestController("/export")
class ExportController(val questionRepository : QuestionRepository) {
//
//    @GetMapping("/multi")
//    fun askForQuestions(@RequestParam category : Category, @RequestParam difficultyLevel: Int) : List<Question> {
//        return questionRepository.findAllByCategoryAndDifficultyLevel(category,difficultyLevel)
//    }

    //@RequestMapping(path = arrayOf("/question/{id}"), method = arrayOf(RequestMethod.GET))

    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun askForQuestion(@RequestParam id: String) =  questionRepository.findOne(id)
}