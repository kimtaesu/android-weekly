package com.hucet.weekly276.repository

import com.hucet.weekly276.data.LocalFeedData
import com.hucet.weekly276.data.LocalUserData

/**
 * Created by tyler on 2017. 10. 1..
 *
 * */
interface Repository {
    fun feedData(): LocalFeedData
    fun userData(): LocalUserData

    class RepositoryImpl(
            val userData: LocalUserData,
            val feedData: LocalFeedData
    ) : Repository {
        override fun feedData(): LocalFeedData {
            return feedData
        }

        override fun userData(): LocalUserData {
            return userData
        }

    }
}

