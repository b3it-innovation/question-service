package se.b3it.innovation.b3runtime.qa.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import se.b3it.innovation.b3runtime.qa.model.Category
import se.b3it.innovation.b3runtime.qa.model.Question
import se.b3it.innovation.b3runtime.qa.repository.QuestionRepository

/**
 * Created by keyhan on 2017-04-24.
 */
@RestController("/")
class QuestionController(val questionRepository : QuestionRepository) {

    @PostMapping("/import") @ResponseStatus(HttpStatus.CREATED)
    fun addQuestion(@RequestBody question: Question) : String? {
        return questionRepository.save(question).id
    }

    @GetMapping("/question/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun askForQuestion(@PathVariable id: String) =  questionRepository.findOne(id)

    @GetMapping("/questions")
    @ResponseStatus(HttpStatus.OK)
    fun askForQuestion(@RequestParam category: Category,
                       @RequestParam difficultyLevel: Int) = questionRepository
            .findAllByCategoryAndDifficultyLevel(category, difficultyLevel)

}