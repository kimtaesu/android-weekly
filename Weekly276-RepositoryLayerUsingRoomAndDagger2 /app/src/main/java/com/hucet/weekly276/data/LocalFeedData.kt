package com.hucet.weekly276.data

import com.hucet.weekly276.domain.FeedDish
import com.hucet.weekly276.infra.AppDatabase
import com.hucet.weekly276.infra.DataSource

/**
 * Created by tyler on 2017. 10. 1..
 */
class LocalFeedData(val appDatabase: AppDatabase) : DataSource<FeedDish> {
    override fun addItem(item: FeedDish) {
        appDatabase.feedObject().insert(item)
    }

    override fun removeItem(item: FeedDish) {
        appDatabase.feedObject().delete(item)
    }
}
