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

}


@Database(entities = [EmployeeEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract val employeeDao: EmployeeDao
}