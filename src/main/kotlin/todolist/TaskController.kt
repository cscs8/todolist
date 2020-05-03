package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import spark.Request
import spark.Response
import spark.Route
import spark.Spark
import spark.Spark.halt
import java.lang.Exception

class TaskController(
    private val objectMapper: ObjectMapper,
    private val taskRepository: TaskRepository
) {
    fun index(): Route = Route { _, _ ->
        taskRepository.findAll()
    }

    fun show(): Route = Route { req, res ->
        val id: Long? = req.params("id").toLongOrNull()
        id?.let { taskRepository::findById } ?: throw halt(404)
    }

    fun create(): Route = Route { req, res ->
        val request: TaskCreateRequest =
            objectMapper.readValue(req.bodyAsBytes()) ?: throw halt(400)
        val task = taskRepository.create(request.content)
        res.status(201)
        task
    }
}
