package com.coding.meet.todo_app.converters

import androidx.room.TypeConverter
import java.util.Date

class TypeConverter {

    @TypeConverter
    fun fromTimestamp(value:Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date:Date): Long {
        return date.time
    }
}