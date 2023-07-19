package com.example.news_pract.data

import com.example.news_pract.data.database.Dao
import com.example.news_pract.data.database.entities.User
import com.example.news_pract.data.database.entities.UserDbEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class UsersRepository(private val dao: Dao) {
    suspend fun saveUser(user: User) = withContext(Dispatchers.IO) {
        dao.insertNewUsersInfoData(user.toUserDbEntity())
    }

    suspend fun isUserLoggedIn(): Boolean? = withContext(Dispatchers.IO) {
        val user = dao.getUsersInfoData()
        if (user == null) {
            null
        } else {
            !user.pinCode.isEmpty()
        }
    }

    suspend fun getUsersInfo(): UserDbEntity = withContext(Dispatchers.IO) {
        dao.getUsersInfoData()
    }
}

