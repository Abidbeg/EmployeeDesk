package com.am.employeedesk.network

import com.am.employeedesk.model.DetailsApiModel
import com.am.employeedesk.model.EmployeeList
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeApi {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUser(): List<EmployeeList>

    @GET("/users/{user}")
    suspend fun getDetails(@Path("user") user: String): DetailsApiModel

}