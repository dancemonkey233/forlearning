package com.example.forlearning.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.forlearning.R;
import com.example.forlearning.api.Api;
import com.example.forlearning.api.ApiConfig;
import com.example.forlearning.api.Callback;
import com.example.forlearning.entity.LoginResponse;
import com.example.forlearning.util.AppConfig;
import com.example.forlearning.util.StringUtils;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;



    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        etAccount=findViewById(R.id.et_account);
        etPwd=findViewById(R.id.et_pwd);
        btnLogin=findViewById(R.id.btn_login);
    }

    @Override
    protected void initData() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=etAccount.getText().toString().trim();
                String pwd=etPwd.getText().toString().trim();
                login(account,pwd);
            }
        });
    }

    private void login(String account,String pwd) {
        if(StringUtils.isEmpty(account)){
            showToast("请输入账号");
            return;
        }
        if(StringUtils.isEmpty(pwd)){
            showToast("请输入密码");
            return;
        }
        HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("mobile", account);
        params.put("password", pwd);
        Api.config(ApiConfig.LOGIN,params).postRequest(new Callback() {
            @Override
            public void onSuccess(final String res) {
//                Log.e("OnSuccess",res);
//                showToastSync(res);
                Gson gson=new Gson();
                LoginResponse loginResponse=gson.fromJson(res,LoginResponse.class);
                if(loginResponse.getCode()==0){
                    String token=loginResponse.getToken();
                    saveStringToSp("token",token);
                    saveStringToSp("username",account);
                    navigateToWithFlag(HomeActivity.class,
                            Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    showToastSync("登录成功");
                }else
                    showToastSync("登录失败");


//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        showToast(res);
//                   }
//                });
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    }

}