package com.am.employeedesk.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Query("select * from employeeentity")
    fun getEmployee(): Flow<List<EmployeeEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: List<EmployeeEntity>)

    @Query("select * from employeedetails where user Like:user")
    fun getDetails(user: String): Flow<EmployeeDetails?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetails(employeeDetails: EmployeeDetails)
}


@Database(
    entities = [EmployeeEntity::class, EmployeeDetails::class],
    version = 2,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract val employeeDao: EmployeeDao
}