package com.am.employeedesk.repository

import com.am.employeedesk.database.AppDataBase
import com.am.employeedesk.database.asDomainModel
import com.am.employeedesk.domain.Details
import com.am.employeedesk.model.asDatabaseModel
import com.am.employeedesk.network.EmployeeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class EmployeeDetailsRepository @Inject constructor(
    private val employeeApi: EmployeeApi,
    private val dataBase: AppDataBase
) {

    fun getUserDetails(user: String): Flow<Details?> =
        dataBase.employeeDao.getDetails(user).map { it?.asDomainModel() }


    suspend fun refereshDetails(user: String) {
        try {
            val userDetails = employeeApi.getDetails(user)
            dataBase.employeeDao.insertDetails(userDetails.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

    suspend fun getBackgroundEmpDetails() {
        val response = employeeApi.getDetails("passy")
        dataBase.employeeDao.insertDetails(response.asDatabaseModel())
    }

}