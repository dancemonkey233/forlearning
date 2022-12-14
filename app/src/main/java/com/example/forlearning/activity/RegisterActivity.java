package com.example.forlearning.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.forlearning.R;
import com.example.forlearning.api.Api;
import com.example.forlearning.api.ApiConfig;
import com.example.forlearning.api.Callback;
import com.example.forlearning.util.StringUtils;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity {
    private EditText etAccount;
    private EditText etPwd;
    private Button btnRegister;


    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        etAccount=findViewById(R.id.et_account);
        etPwd=findViewById(R.id.et_pwd);
        btnRegister=findViewById(R.id.btn_register);
    }

    @Override
    protected void initData() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=etAccount.getText().toString().trim();
                String pwd=etPwd.getText().toString().trim();
                register(account,pwd);
            }
        });
    }

    private void register(String account,String pwd) {
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
        Api.config(ApiConfig.REGISTER,params).postRequest(new Callback() {
            @Override
            public void onSuccess(String res) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(res);
                    }
                });
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("OnFailure",e.toString());
            }
        });

    }
}