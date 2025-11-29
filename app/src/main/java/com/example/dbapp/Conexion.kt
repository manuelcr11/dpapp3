package com.example.dbapp.utils

import android.content.Context

object Conexion {

    private const val PREF_NAME = "config"
    private const val KEY_IP = "server_ip"

    fun setIp(context: Context, ip: String) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sp.edit().putString(KEY_IP, ip).apply()
    }

    fun getIp(context: Context): String {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getString(KEY_IP, "") ?: ""
    }

    fun getUrl(context: Context, endpoint: String): String {
        val ip = getIp(context)
        return "http://$ip/dbapp/$endpoint"
    }
}
