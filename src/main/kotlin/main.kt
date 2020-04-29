import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import todolist.JsonTransformer
import todolist.TaskController

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val taskController = TaskController()
    val jsonTransformer = JsonTransformer(objectMapper)

    get(
        "/tasks", taskController.index(),
        jsonTransformer
    )
//    get("/hello") { request, response ->
//        val name: String? = request.queryParams("name")
//        "Hello, ${name ?: "world!"}"
//    }
}