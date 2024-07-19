package com.am.employeedesk.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.am.employeedesk.domain.Employee

@Entity
data class EmployeeEntity constructor(
    @PrimaryKey
    val id: Int,
    val avtar: String,
    val userName: String
)

fun List<EmployeeEntity>.asDomainModel(): List<Employee> {
    return map {
        Employee(id = it.id, avatar = it.avtar, username = it.userName)
    }
}