import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.*
import todolist.JsonTransformer
import todolist.TaskController
import todolist.TaskRepository

fun main() {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskRepository = TaskRepository()
    val taskController = TaskController(objectMapper, taskRepository)

    path("/tasks") {
        get("", taskController.index(), jsonTransformer)

        post("", taskController.create(), jsonTransformer)

        get("/:id", taskController.show(), jsonTransformer)

        patch("/:id", taskController.update(), jsonTransformer)

        delete("/:id", taskController.destroy(), jsonTransformer)
    }
}