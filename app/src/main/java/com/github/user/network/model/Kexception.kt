package com.github.user.network.model

import okhttp3.ResponseBody

open class Kexception(val errorBody: ResponseBody?,
                      message: String?,
                      cause: Throwable?,
                      val statusCode: StatusCode
) : Exception(message, cause)