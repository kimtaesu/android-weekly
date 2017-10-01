package com.hucet.weekly276.dao

import android.arch.persistence.room.*
import com.hucet.weekly276.domain.UserDish
import android.arch.paging.LivePagedListProvider

/**
 * Created by tyler on 2017. 10. 1..
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM user_dish")
    fun findAll(): List<UserDish>

    @Insert
    fun insert(users: List<UserDish>)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(user: UserDish)

    @Delete
    fun delete(user: UserDish)

}

