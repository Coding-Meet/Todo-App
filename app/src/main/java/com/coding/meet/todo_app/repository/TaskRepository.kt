package com.coding.meet.todo_app.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.coding.meet.todo_app.database.TaskDatabase
import com.coding.meet.todo_app.models.Task
import com.coding.meet.todo_app.utils.Resource
import com.coding.meet.todo_app.utils.Resource.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TaskRepository(application: Application) {

    private val taskDao = TaskDatabase.getInstance(application).taskDao


    fun getTaskList() = flow {
        emit(Loading())
        try {
            val result = taskDao.getTaskList()
            emit(Success(result))
        }catch (e:Exception){
            emit(Error(e.message.toString()))
        }
    }


    fun insertTask(task: Task) = MutableLiveData<Resource<Long>>().apply {
        postValue(Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.insertTask(task)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }


    fun deleteTask(task: Task) = MutableLiveData<Resource<Int>>().apply {
        postValue(Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.deleteTask(task)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }

    fun deleteTaskUsingId(taskId: String) = MutableLiveData<Resource<Int>>().apply {
        postValue(Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.deleteTaskUsingId(taskId)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }


    fun updateTask(task: Task) = MutableLiveData<Resource<Int>>().apply {
        postValue(Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.updateTask(task)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }
    fun updateTaskPaticularField(taskId: String,title:String,description:String) = MutableLiveData<Resource<Int>>().apply {
        postValue(Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.updateTaskPaticularField(taskId, title, description)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }

}