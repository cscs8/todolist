import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import spark.Spark.post
import todolist.JsonTransformer
import todolist.TaskController
import todolist.TaskRepository

fun main() {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskRepository = TaskRepository()
    val taskController = TaskController(objectMapper, taskRepository)

    get("/tasks", taskController.index(), jsonTransformer)

    get("/tasks/:id", taskController.show(), jsonTransformer)

    post("/tasks", taskController.create(), jsonTransformer)
}