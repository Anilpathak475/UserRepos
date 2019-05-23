package com.github.user.network.errorhandler

import com.github.user.network.model.Kexception
import com.github.user.network.model.StatusCode

open class ApiErrorHandler {

    open fun getExceptionType(response: retrofit2.Response<*>): Exception {
        return Kexception(response.errorBody(), response.message(), null, StatusCode(response.code()))
    }


}