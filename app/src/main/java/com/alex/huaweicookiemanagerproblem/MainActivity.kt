package com.alex.huaweicookiemanagerproblem

import android.os.Bundle
import android.webkit.CookieManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cookieText = findViewById<TextView>(R.id.cookie)
        val url = "https://auth.zero.ru/zero/zeroauth?client=mobile"
        cookieText.text = "NO CALLBACK"
        CookieManager.getInstance().setCookie(
            url, "TEST"
        ) { value: Boolean ->
            if (value) {
                cookieText.text = CookieManager.getInstance().getCookie(url)
            } else {
                cookieText.text = "BAD CALLBACK"
            }
        }
    }
}