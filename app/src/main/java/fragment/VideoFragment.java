package fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.forlearning.R;


public class VideoFragment extends Fragment {
    private String title;
private String content;

    public VideoFragment() {
    }

    public static VideoFragment newInstance(String content) {
        VideoFragment fragment = new VideoFragment();
        fragment.content=content;

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_video, container, false);
        TextView tv=v.findViewById(R.id.title);
        tv.setText(content);
        return v;
    }
}