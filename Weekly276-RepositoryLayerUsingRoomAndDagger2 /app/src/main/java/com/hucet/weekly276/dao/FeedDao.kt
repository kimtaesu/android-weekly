package com.hucet.weekly276.dao

import android.arch.persistence.room.*
import com.hucet.weekly276.domain.FeedDish

/**
 * Created by tyler on 2017. 10. 1..
 */
@Dao
interface FeedDao {

    @Query("SELECT * FROM feed_dish")
    fun findAll() : List<FeedDish>

    @Insert
    fun insert(feeds: List<FeedDish>)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(feed: FeedDish)

    @Delete
    fun delete(feed: FeedDish)

}

