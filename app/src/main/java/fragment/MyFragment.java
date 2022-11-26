package fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forlearning.R;
import com.example.forlearning.activity.HomeActivity;
import com.example.forlearning.activity.LoginActivity;
import com.example.forlearning.entity.LoginResponse;
import com.example.forlearning.entity.MapResponse;
import com.example.forlearning.util.map;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringEscapeUtils;

public class MyFragment extends Fragment {
    public MyFragment() {
    }


    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //动态显示用户名
        SharedPreferences sp= getActivity().getSharedPreferences("sp_mmw", MODE_PRIVATE);
        String username =sp.getString("username","");
        TextView tv=getActivity().findViewById(R.id.username6);
        tv.setText(username);


        //ip
        TextView textView=getActivity().findViewById(R.id.ip);
        map map = new map();
        Thread thread = new Thread(map);
        thread.start();
        String s=null;
        try {
            thread.join(1000);
            s = map.getS();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String ss = StringEscapeUtils.unescapeJava(s);//此处获得转码中文后的字符串
        Gson gson=new Gson();
        MapResponse mapResponse=gson.fromJson(ss, MapResponse.class);
        if(mapResponse.getStatus()==0){
            String add=mapResponse.getAddress();
            String[] strings = add.split("\\|");
            textView.setText("IP:"+strings[1]);
        }else
            textView.setText("无法获取IP");


        //退出功能
        View button =  getActivity().findViewById(R.id.rl_logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeByKey("token");
                navigateToWithFlag(LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getActivity(), "已退出", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void removeByKey(String key) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_mmw", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        edit.commit();
    }
    public void navigateToWithFlag(Class cls, int flags) {
        Intent in = new Intent(getActivity(), cls);
        in.setFlags(flags);
        startActivity(in);
    }
}