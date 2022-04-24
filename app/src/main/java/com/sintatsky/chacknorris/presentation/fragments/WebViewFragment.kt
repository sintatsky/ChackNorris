package com.sintatsky.chacknorris.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.sintatsky.chacknorris.R


class WebViewFragment : Fragment() {

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewBrowser: ConstraintLayout =
            inflater.inflate(R.layout.fragment_web_view, container, false) as ConstraintLayout

        webView = viewBrowser.findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()

        webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
        }
        if (savedInstanceState == null){
            webView.loadUrl(URL)
        }else{
            webView.restoreState(savedInstanceState)
        }
        return viewBrowser
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    companion object {
        const val WEB_VIEW_FRAGMENT_TAG = "WEB_VIEW_FRAGMENT_TAG"
        private const val URL = "http://www.icndb.com/api/"
    }
}