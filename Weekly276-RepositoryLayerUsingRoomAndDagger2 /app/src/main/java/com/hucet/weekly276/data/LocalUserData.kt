package com.hucet.weekly276.data

import com.hucet.weekly276.domain.FeedDish
import com.hucet.weekly276.domain.UserDish
import com.hucet.weekly276.infra.AppDatabase
import com.hucet.weekly276.infra.DataSource

/**
 * Created by tyler on 2017. 10. 1..
 */
class LocalUserData(val appDatabase: AppDatabase) : DataSource<UserDish> {
    override fun addItem(item: UserDish) {
        appDatabase.userObject().insert(item)
    }

    override fun removeItem(item: UserDish) {
        appDatabase.userObject().delete(item)
    }
}
