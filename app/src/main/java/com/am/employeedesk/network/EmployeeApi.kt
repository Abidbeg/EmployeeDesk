package com.am.employeedesk.network

import com.am.employeedesk.model.EmployeeList
import retrofit2.http.GET

interface EmployeeApi {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUser(): List<EmployeeList>
}