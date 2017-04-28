package se.b3it.innovation.b3runtime.repository

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.util.FileCopyUtils
import se.b3it.innovation.b3runtime.qa.model.Category
import se.b3it.innovation.b3runtime.qa.model.Question
import se.b3it.innovation.b3runtime.qa.model.QuestionData
import se.b3it.innovation.b3runtime.qa.repository.QuestionRepository
import java.util.*

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
        val cpr = ClassPathResource("si.jpg")
        val encoded = Base64.getEncoder().encode(FileCopyUtils.copyToByteArray(cpr.inputStream))
        val q1 = questionRepository.save(Question(question = QuestionData(text = "How long is a day?", data =
        String(encoded)),

                rightAnswers = listOf(QuestionData("24 Hours")),
                faultyAnswers = listOf(QuestionData("10 Hours"), QuestionData("15 Hours"), QuestionData("16 Hours"))
                ,category = Category.SCIENCE,
                difficultyLevel = 1))

        val q2 = questionRepository.save(Question(question = QuestionData("How many days in January?"),
                rightAnswers = listOf(QuestionData("31 days")),
                faultyAnswers = listOf(QuestionData("10 days"), QuestionData("30 Hours"), QuestionData("29 Hours")),
                        category = Category.SCIENCE,
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