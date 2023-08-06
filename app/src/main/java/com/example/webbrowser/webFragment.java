package com.example.webbrowser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class webFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_web, container, false);

        webView = rootView.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        // Obtener la dirección del sitio web enviada desde la primera ventana
        Bundle args = getArguments();
        if (args != null) {
            String websiteUrl = args.getString("websiteUrl");
            if (websiteUrl != null) {
                webView.loadUrl(websiteUrl);
            }
        }

        return rootView;
    }
}
