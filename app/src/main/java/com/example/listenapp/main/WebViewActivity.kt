package com.example.listenapp.main

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import base.ActBind
import com.example.listenapp.databinding.WebviewBinding
import custom.loadInApp
import custom.onClick
import custom.viewBind
import kotlinx.android.synthetic.main.webview.*

class WebViewActivity : ActBind<WebviewBinding>() {
    override val binding: WebviewBinding by viewBind()
    lateinit var url: String

    override fun Bundle.onExtras() {
        url = getString("URL") ?: ""
    }
    override fun WebviewBinding.onBoundView() {
        backArrow.onClick {super.onBackPressed()}
        share.onClick{ startActivity(
                createChooser(
                        Intent().apply {
                            action = ACTION_SEND
                            type = "text/plain"
                            putExtra(EXTRA_TEXT, url)
                        }, "Texto do Menuzinho Bacana"
                )
        ) }
        webview.loadUrl(url)
        webview.loadInApp()
    }
    override fun onBackPressed() {
        if (webview.canGoBack()) webview.goBack() else super.onBackPressed()
    }
}



