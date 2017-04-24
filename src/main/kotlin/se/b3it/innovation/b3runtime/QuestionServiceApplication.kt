package se.b3it.innovation.b3runtime

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class QuestionServiceApplication
    fun main(args: Array<String>) {
        SpringApplication.run(QuestionServiceApplication::class.java, *args)
    }