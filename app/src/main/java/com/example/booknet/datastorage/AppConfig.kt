package com.example.booknet.datastorage

import android.content.Context
import android.content.SharedPreferences

class AppConfig(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("Default", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    fun getFloat(key: String, defValue: Float = 0f): Float {
        return sharedPreferences.getFloat(key, defValue)
    }

    fun getInt(key: String, defValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defValue)
    }

    fun getLong(key: String, defValue: Long = 0): Long {
        return sharedPreferences.getLong(key, defValue)
    }

    fun getString(key: String, defValue: String = ""): String {
        return sharedPreferences.getString(key, defValue) ?: ""
    }

    fun getStringNullable(key: String, defValue: String? = null): String? {
        return sharedPreferences.getString(key, defValue)
    }

    fun getStringSet(key: String, defValues: Set<String> = setOf()): MutableSet<String>? {
        return sharedPreferences.getStringSet(key, defValues)
    }

    fun putBoolean(key: String, value: Boolean): AppConfig {
        editor.putBoolean(key, value)
        return this
    }

    fun putFloat(key: String, value: Float): AppConfig {
        editor.putFloat(key, value)
        return this
    }

    fun putInt(key: String, value: Int): AppConfig {
        editor.putInt(key, value)
        return this
    }

    fun putLong(key: String, value: Long): AppConfig {
        editor.putLong(key, value)
        return this
    }

    fun putString(key: String, value: String): AppConfig {
        editor.putString(key, value)
        return this
    }

    fun putStringNullable(key: String, value: String?): AppConfig {
        editor.putString(key, value)
        return this
    }

    fun putStringSet(key: String, value: Set<String>?): AppConfig {
        editor.putStringSet(key, value)
        return this
    }

    fun commitBoolean(key: String, value: Boolean): AppConfig {
        editor.putBoolean(key, value).commit()
        return this
    }

    fun commitFloat(key: String, value: Float): AppConfig {
        editor.putFloat(key, value).commit()
        return this
    }

    fun commitInt(key: String, value: Int): AppConfig {
        editor.putInt(key, value).commit()
        return this
    }

    fun commitLong(key: String, value: Long): AppConfig {
        editor.putLong(key, value).commit()
        return this
    }

    fun commitString(key: String, value: String): AppConfig {
        editor.putString(key, value).commit()
        return this
    }

    fun commitStringNullable(key: String, value: String?): AppConfig {
        editor.putString(key, value).commit()
        return this
    }

    fun commitStringSet(key: String, value: Set<String>?): AppConfig {
        editor.putStringSet(key, value).commit()
        return this
    }

    fun commit(): AppConfig {
        editor.commit()
        return this
    }

    fun clear() {
        editor.clear()
        editor.commit()
    }
}