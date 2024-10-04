package com.topjohnwu.magisk.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.topjohnwu.magisk.R
import kotlin.random.Random

@SuppressLint("CustomSplashScreen")
class KokoroActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.kokoro_activity_splash)

        // hidden system bar
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.R)
            findViewById<RelativeLayout>(R.id.kokoro_splash).setSystemUiVisibility(View.VISIBLE)
        else window.insetsController?.hide(WindowInsets.Type.systemBars())

        // KokoroActivity => MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            // i know this vary stupid, but who care? :)
        }, Random.nextLong(100, 700))
    }
}