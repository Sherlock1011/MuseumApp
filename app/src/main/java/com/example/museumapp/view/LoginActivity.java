package com.example.museumapp.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.museumapp.R;
import com.example.museumapp.bean.User;
import com.example.museumapp.bean.greendao.DatabaseManager;
import com.example.museumapp.bean.greendao.UserDao;
import com.example.museumapp.utils.DialogManager;

import org.greenrobot.greendao.query.QueryBuilder;

public class LoginActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 0;
    private EditText input_id;
    private EditText input_pwd;
    private Button login_btn;
    private TextView sign_up_tv;
    private User db_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //沉浸式显示页面
        StatusBarManager.setStatusBarFull(LoginActivity.this, getWindow(), getResources());

        initViews();
    }

    /**
     * 初始化界面控件
     */
    private void initViews() {
        input_id = (EditText) findViewById(R.id.input_id);
        input_pwd = (EditText) findViewById(R.id.input_pwd);
        login_btn = (Button) findViewById(R.id.login_btn);
        sign_up_tv = (TextView) findViewById(R.id.sign_up_tv);

        //设置登录按钮点击事件
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = input_id.getText().toString();
                String pwd = input_pwd.getText().toString();
                User user = new User(id,pwd);
                login(user);
            }
        });

        //设置注册按钮点击事件
        sign_up_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    /**
     * 登录操作
     * @param user 用户对象
     */
    private void login(User user){
        //验证账号或者密码是否为空
        if(user.getId().equals("") || user.getPwd().equals("")){
            DialogManager.warningDialogShow(this, "提示", "用户名或密码不能为空！");
        }
        else if(isExist(user.getId())){
            //TODO 读取数据库 获取密码
            String pwd = db_user.getPwd();
            if(user.getPwd().equals(pwd)){
                //登陆成功，跳转到主界面
                Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
                intent.putExtra("user_id",user.getId());//将id传给主界面，用于时间预约
                startActivity(intent);
            }
            else {
                DialogManager.warningDialogShow(this, "错误", "用户名或密码不正确");
            }
        }
        else {
            DialogManager.warningDialogShow(this, "提示", "用户不存在，请注册！");
        }

    }

    /**
     * 判断用户是否存在
     * @param id 用户名
     * @return 是否存在该用户
     */
    private boolean isExist(String id) {
        QueryBuilder<User> result = DatabaseManager.getInstance().getUserDao().queryBuilder();
        result = result.where(UserDao.Properties.Id.eq(id));
        if (!result.list().isEmpty()){
            db_user = result.list().get(0);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String id = data.getStringExtra("user_id");
            input_id.setText(id);
        }
    }
}