package com.github.user.network.requesthandler

import androidx.lifecycle.Observer
import com.github.user.network.model.StatusCode
import com.github.user.network.model.Wrapper

/**
 *  @constructor Kobserver takes in a function to handle exceptions, note when
 *   you pass in a function the onException(exception:Exception) method will
 *   be ignored
 */
abstract class Kobserver<T>(private val exceptionHandler: ((Exception) -> Unit)? = null) : Observer<Wrapper<T>> {

    override fun onChanged(wrapper: Wrapper<T>?) {
        wrapper?.let {
            finish(it.statusCode)
            it.exception?.let { ex ->
                handleErrorInstance(ex)
            }
            it.data?.let { data ->
                onSuccess(data)
            }
            return
        }
        handleErrorInstance(Exception("Something went wrong"))
    }

    private fun handleErrorInstance(ex: Exception) {
        exceptionHandler?.let { func ->
            func.invoke(ex)
            return
        }
        onException(ex)
    }

    /**
     * Method to be called on successful load of data. This method is guaranteed to contain the returned data
     *
     * @param data
     */
    abstract fun onSuccess(data: T)

    /**
     * Method to handle exception that occurs during request processing.
     * @param exception
     */
    open fun onException(exception: Exception) {

    }

    /**
     * Triggered for any request by user, both successful and unsuccessful
     * takes in a StatusCode, so you can determine the state of the requests
     */

    open fun finish(statusCode: StatusCode) {
        //Check for 20x and perform operation
    }
}