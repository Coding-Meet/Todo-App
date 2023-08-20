package com.coding.meet.todo_app.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.coding.meet.todo_app.models.Task
import com.coding.meet.todo_app.repository.TaskRepository
import com.coding.meet.todo_app.utils.Resource

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskRepository = TaskRepository(application)

    fun getTaskList() = taskRepository.getTaskList()

    fun insertTask(task: Task): MutableLiveData<Resource<Long>> {
        return taskRepository.insertTask(task)
    }

    fun deleteTask(task: Task): MutableLiveData<Resource<Int>> {
        return taskRepository.deleteTask(task)
    }

    fun deleteTaskUsingId(taskId: String): MutableLiveData<Resource<Int>> {
        return taskRepository.deleteTaskUsingId(taskId)
    }

    fun updateTask(task: Task): MutableLiveData<Resource<Int>> {
        return taskRepository.updateTask(task)
    }

    fun updateTaskPaticularField(taskId: String,title:String,description:String): MutableLiveData<Resource<Int>> {
        return taskRepository.updateTaskPaticularField(taskId, title, description)
    }
}