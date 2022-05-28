package zdz.imageURL.pref.core

import android.content.SharedPreferences
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

internal class StringPreference(
    override val key: String,
    override val defaultValue: String,
    private val sharedPreferences: SharedPreferences,
    private val coroutineContext: CoroutineContext
) : BasePreference<String>(key, sharedPreferences, coroutineContext) {
    
    override fun get() = sharedPreferences.getString(key, defaultValue)!!
    
    override fun set(value: String) = sharedPreferences.edit().putString(key, value).apply()
    
    override suspend fun setAndCommit(value: String) = withContext(coroutineContext) {
        sharedPreferences.edit().putString(key, value).commit()
    }
    
}