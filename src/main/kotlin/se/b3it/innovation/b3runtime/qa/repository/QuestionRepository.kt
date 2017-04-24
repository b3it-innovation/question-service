package se.b3it.innovation.b3runtime.qa.repository

import org.springframework.data.mongodb.repository.MongoRepository
import se.b3it.innovation.b3runtime.qa.model.Category
import se.b3it.innovation.b3runtime.qa.model.Question

/**
 * Created by keyhan on 2017-04-24.
 */

interface QuestionRepository : MongoRepository<Question, String> {
    fun findAllByCategoryAndDifficultyLevel(category: Category, difficultyLevel: Int): List<Question>
}
