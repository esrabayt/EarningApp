package com.esrakaya.earningapp.domain.mapper

import com.esrakaya.earningapp.data.model.EarningResponse
import com.esrakaya.earningapp.domain.model.EarningModel
import com.esrakaya.earningapp.domain.model.UserModel
import com.esrakaya.earningapp.domain.utils.Mapper
import com.esrakaya.earningapp.domain.utils.mapWith
import com.esrakaya.earningapp.domain.utils.orFalse
import com.esrakaya.earningapp.domain.utils.orZero
import javax.inject.Inject

class EarningMapper @Inject constructor(
    private val userMapper: UserMapper
) : Mapper<EarningResponse, EarningModel> {

    override fun map(input: EarningResponse): EarningModel = with(input) {
        return EarningModel(
            userList = userList?.map { it.mapWith(userMapper) }.orEmpty(),
            totalEarned = totalEarned.orZero(),
            potentialEarned = potentialEarned.orZero(),
            maximumEarning = maximumEarning.orZero(),
            paidAmount = paidAmount.orZero()
        )
    }
}

class UserMapper @Inject constructor() :
    Mapper<EarningResponse.UserResponse, UserModel> {

    override fun map(input: EarningResponse.UserResponse): UserModel = with(input) {
        return UserModel(
            firstName = firstName.orEmpty(),
            lastName = lastName.orEmpty(),
            totalEarned = totalEarned.orZero(),
            isEarned = isEarned.orFalse()
        )
    }
}
