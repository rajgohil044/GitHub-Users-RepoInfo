package com.test.meeshotest.utils

import android.util.Log

/**
 * Created by Rajender Gohil on 05/05/19.
 */
class LogUtils {

    companion object {

        private var enableLog = false

        fun setEnableLog(enableLog: Boolean) {
            this.enableLog = enableLog
        }

        private fun log(priority: Int, tag: String?, message: String?) {
            val finalTag = tag ?: ""
            val finalMessage = message ?: ""
            if (priority == Log.DEBUG && !enableLog) return
            Log.println(priority, finalTag, finalMessage)
        }

        private fun getMessage(e: Throwable?): String {
            return if (e?.message != null) return e.message!! else ""
        }

        private fun log(priority: Int, tag: String?, message: String, e: Throwable) {
            log(priority, tag, message + Log.getStackTraceString(e))
        }

        fun d(tag: String?, message: String?) {
            log(Log.DEBUG, tag, message)
        }

        fun v(tag: String?, message: String?) {
            log(Log.VERBOSE, tag, message)
        }

        fun i(tag: String?, message: String?) {
            log(Log.INFO, tag, message)
        }

        fun w(tag: String?, message: String?) {
            log(Log.WARN, tag, message)
        }

        fun e(tag: String?, message: String?) {
            log(Log.ERROR, tag, message)
        }

        fun e(tag: String?, e: Throwable) {
            log(Log.ERROR, tag, getMessage(e), e)
        }
    }
}