# question-service
This Service:
1. is a REST based Service.
1. can import questions, which will be saved into a MongoDB.
1. Can return questions within a specific field (for example GEOGRAPHY), and a difficulty level, (positive short value).
1. is written in Kotlin, but nothing stops you to write some parts of it in java since Kotlin is JVM-based and java interop.
1. supports pictures in the questions but they have to be formatted in Base64 in the JSON requests.

For this service to work, you need to:
1. Have access to a MongoDB
1. Configure the MongoDB properties (url, user, password) in the application.yml file of this service.
