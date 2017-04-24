package se.b3it.innovation.b3runtime.qa.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by keyhan on 2017-04-24.
 */

enum class Category {
    SPORTS,
    MOVIES,
    SCIENCE,
    MUSIC,
    HISTORY,
    GEOGRAPHY,
    B3IT
}

@Document(collection = "questions")
data class Question @PersistenceConstructor constructor( @Id val id : String? = null,
                      val question: String,
                      val rightAnswer : String,
                      val faultyAnswers: List<String>,
                      val difficultyLevel: Int,
                      val category: Category)