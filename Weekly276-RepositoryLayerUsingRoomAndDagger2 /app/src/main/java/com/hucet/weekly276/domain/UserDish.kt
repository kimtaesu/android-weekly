package com.hucet.weekly276.domain

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by tyler on 2017. 10. 1..
 */
@Entity()
data class UserDish(
        @PrimaryKey val dish_id: String,
        @Embedded val owner: DishOwner
)