package com.example.booknet.datastorage.user

import com.example.booknet.constants.ApiConstants
import com.example.booknet.datastorage.AppConfig
import com.example.booknet.datastorage.Keys
import com.example.booknet.extensions.toMD5

class UserDataStorage(private val appConfig: AppConfig) {

    var appName: String = ""
        get() = field.ifEmpty {
            appConfig.getString(Keys.APP_NAME)
        }
        set(value) {
            appConfig.commitString(Keys.APP_NAME, value)
            field = value
        }

    var deviceId: String = ""
        get() = field.ifEmpty {
            appConfig.getString(Keys.DEVICE_ID)
        }
        set(value) {
            appConfig.commitString(Keys.DEVICE_ID, value)
            field = value
        }

    var token: String = ""
        get() = field.ifEmpty {
            appConfig.getString(Keys.TOKEN)
        }
        set(value) {
            appConfig.commitString(Keys.TOKEN, value)
            field = value
        }

    var apiVersion: String = ""
        get() = field.ifEmpty {
            appConfig.getString(Keys.API_VERSION)
        }
        set(value) {
            appConfig.commitString(Keys.API_VERSION, value)
            field = value
        }

    val sign: String
        get() = "$deviceId${ApiConstants.secret}$token".toMD5()
}