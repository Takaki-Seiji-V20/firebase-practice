package com.example.android.displayingbitmaps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment1 extends Fragment {


    public MyFragment1() {
        // Required empty public constructor
    }

    private WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_fragment1, container, false);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Fragment fragment = new MyFragment2();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contents,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        });

        mWebView= (WebView)view.findViewById(R.id.webview1);
        mWebView.setWebViewClient(new WebViewClient());
        //mWebView.loadUrl("http://www.google.co.jp");
        mWebView.loadUrl("file:///android_asset/html/index.html");

        //mWebView.getSettings().setJavaScriptEnabled(true);

        return view;
    }

}
