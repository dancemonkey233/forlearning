package fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forlearning.R;
import com.example.forlearning.activity.LoginActivity;


public class CollectFragment extends Fragment {
    WebView wv;
    public CollectFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static CollectFragment newInstance() {
        CollectFragment fragment = new CollectFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collect, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         wv=getActivity().findViewById(R.id.web);
        WebSettings settings = wv.getSettings();

        settings.setUserAgentString(wv.getSettings().getUserAgentString()+"Android-APP");
        settings.setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://m.ixigua.com/video/6650215846482280974?utm_source=baidu_lvideo");


    }


}

