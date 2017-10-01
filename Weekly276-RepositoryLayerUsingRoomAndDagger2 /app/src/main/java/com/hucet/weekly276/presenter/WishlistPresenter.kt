package com.hucet.weekly276.presenter

import android.content.Context
import com.hucet.weekly276.repository.Repository

/**
 * Created by tyler on 2017. 10. 1..
 */
interface WishlistPresenter {
    class WishlistPresenterImpl(val context: Context,
                                val repository: Repository) : WishlistPresenter {

    }
}