package com.example.museumapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.museumapp.R;
import com.example.museumapp.utils.DialogManager;

public class SignUpActivity extends AppCompatActivity {
    private EditText input_id;
    private EditText input_pwd;
    private EditText input_confirm_pwd;
    private Button sig_up_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        StatusBarManager.setStatusBarFull(this, getWindow(), getResources());

        initViews();
    }

    /**
     * 初始化界面控件
     */
    private void initViews() {
        input_id = (EditText) findViewById(R.id.sp_input_id);
        input_pwd = (EditText) findViewById(R.id.sp_input_pwd);
        input_confirm_pwd = (EditText) findViewById(R.id.input_confirm_pwd);
        sig_up_btn = (Button) findViewById(R.id.sign_up_btn);

        //设置注册按钮点击事件
        sig_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = input_id.getText().toString();
                String pwd = input_pwd.getText().toString();
                String confirm = input_confirm_pwd.getText().toString();
                signUp(id, pwd, confirm);
            }
        });
    }

    /**
     * 用户注册操作
     * @param id 用户id
     * @param pwd 密码
     * @param confirm 确认密码
     */
    private void signUp(String id, String pwd, String confirm){
        if(id.isEmpty() || pwd.isEmpty() || confirm.isEmpty()){
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        }
        else if(!isExist(id)){
            //用户名未被注册，注册合法
            if(pwd.equals(confirm)){
                Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
                //TODO 插入数据库操作

                //返回登录界面
                Intent intent = new Intent();
                intent.putExtra("user_id", id);
                setResult(RESULT_OK, intent);
                finish();
            }
            else {
                Toast.makeText(this, "两次密码输入不符，请确认！", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            DialogManager.warningDialogShow(this, "提示", "用户名已注册！");
        }
    }

    /**
     * 判断用户名是否已经注册
     * @param id 用户名
     * @return
     */
    private boolean isExist(String id){
        return false;
    }
}