package uz.mlsoft.mobilebankingcompose.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyShared @Inject constructor(@ApplicationContext context: Context) {

    private val pref = context.getSharedPreferences("my", Context.MODE_PRIVATE)

    var token
        get() = pref.getString("TOKEN", "")
        set(value) = pref.edit().putString("TOKEN", value).apply()
    var code
        get() = pref.getString("CODE", "")
        set(value) = pref.edit().putString("CODE", value).apply()
    var isReg
        get() = pref.getBoolean("REG", false)
        set(value) = pref.edit().putBoolean("REG", value).apply()

}