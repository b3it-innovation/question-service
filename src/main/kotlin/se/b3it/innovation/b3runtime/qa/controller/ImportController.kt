package se.b3it.innovation.b3runtime.qa.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import se.b3it.innovation.b3runtime.qa.model.Question
import se.b3it.innovation.b3runtime.qa.repository.QuestionRepository

/**
 * Created by keyhan on 2017-04-24.
 */
@RestController("/question")
class ImportController {

    @Autowired
    lateinit var questionRepository : QuestionRepository

    @PostMapping("/import") @ResponseStatus(HttpStatus.CREATED)
    fun addQuestion(@RequestBody question: Question) : String? {
        return questionRepository.save(question).id
    }

    @GetMapping("/export")
    @ResponseStatus(HttpStatus.OK)
    fun askForQuestion(@RequestParam id: String) =  questionRepository.findOne(id)
}