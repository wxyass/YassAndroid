package com.yass.event;

import android.widget.Toast;

import com.core.initbase.InitFragment;
import com.core.web.event.Event;


/**
 * Created by 傅令杰
 */

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(), "123", Toast.LENGTH_LONG).show();
        /*if (getAction().equals("test")) {
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall();", null);
                }
            });
        }*/
        getDelegate().pop();
        return null;
    }
}
