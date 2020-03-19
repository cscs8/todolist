import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import todolist.Task

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()

    get("/tasks") { req, res ->
        val tasks = listOf(
            Task(1, "クリーニングに出す", false),
            Task(2, "住民票を取得する", true)
        )
        objectMapper.writeValueAsString(tasks)
    }
    get("/hello") { request, response ->
        val name: String? = request.queryParams("name")
        "Hello, ${name ?: "world!"}"
    }
}