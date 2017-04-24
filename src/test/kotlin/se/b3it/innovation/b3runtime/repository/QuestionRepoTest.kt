package se.b3it.innovation.b3runtime.repository

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import se.b3it.innovation.b3runtime.qa.model.Category
import se.b3it.innovation.b3runtime.qa.model.Question
import se.b3it.innovation.b3runtime.qa.repository.QuestionRepository

/**
 * Created by keyhan on 2017-04-24.
 */

@RunWith(SpringRunner::class)
@SpringBootTest
class QuestionRepoTest {
    @Autowired
    lateinit var questionRepository : QuestionRepository


    @Test
    fun testStoreDate() : Unit {
        val q1 = questionRepository.save(Question(question = "How long is a day?", rightAnswer = "24 Hours",
                faultyAnswers = listOf("10 Hours", "15 Hours", "16 Hours"),category = Category.SCIENCE,
                difficultyLevel = 1))

        val q2 = questionRepository.save(Question(question = "How many days in January?", rightAnswer = "31 days",
                faultyAnswers = listOf("10 days", "30 Hours", "29 Hours"),category = Category.SCIENCE,
                difficultyLevel = 1))

        println(q1.id)
        val r1 = questionRepository.findOne(q1.id)
        println(q2.id)
        val r2 = questionRepository.findOne(q1.id)
        println(r1)
        println(r2)

        val list = questionRepository.findAllByCategoryAndDifficultyLevel(Category.SCIENCE,1)

        println("The list is: " + list)

        questionRepository.delete(q1.id)
        val rs = questionRepository.findAll()
        println(rs)
    }
}