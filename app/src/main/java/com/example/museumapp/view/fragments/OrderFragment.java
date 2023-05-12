package com.example.museumapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.museumapp.R;
import com.example.museumapp.bean.OrderRecord;
import com.example.museumapp.bean.greendao.DatabaseManager;
import com.example.museumapp.bean.greendao.OrderRecordDao;
import com.example.museumapp.utils.DatePickerFragment;
import com.example.museumapp.utils.DialogManager;

import org.greenrobot.greendao.query.QueryBuilder;

public class OrderFragment extends Fragment {
    private TextView time_piker;
    private EditText input_name;
    private EditText input_phone;
    private EditText input_count;

    private Button order_button;
    private TextView cancel_order_tv;
    private OrderRecord orderRecord;
    private String id;

    boolean isRecorded;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        //检查数据库中是否有预约记录
        isRecorded = isExistRecord(id);
        initViews(view);
        return view;
    }

    public OrderFragment(String id) {
        this.id = id;
    }

    /**
     * 初始化界面控件
     * @param view
     */
    private void initViews(View view) {
        time_piker = (TextView) view.findViewById(R.id.time_piker);
        input_name = (EditText) view.findViewById(R.id.input_name);
        input_phone = (EditText) view.findViewById(R.id.input_phone);
        input_count = (EditText) view.findViewById(R.id.input_count);

        order_button = (Button) view.findViewById(R.id.order_btn);
        cancel_order_tv = (TextView) view.findViewById(R.id.cancel_order_tv);

        if(isRecorded){
            //如果有记录，只能查看和取消预约
            order_button.setText("查看预约");
            cancel_order_tv.setVisibility(View.VISIBLE);
        }
        else {
            order_button.setText("预   约");
            cancel_order_tv.setVisibility(View.GONE);
        }

        //设置按点击事件
        order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRecorded){
                    showOrder();
                }
                else {
                    order();
                }
            }
        });

        //设置取消预约点击事件
        cancel_order_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelOrder(id);
            }
        });

        //设置时间选择器打开事件
        time_piker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment(time_piker);
                datePickerFragment.show(getActivity().getSupportFragmentManager(), "日期选择器");
            }
        });
    }

    /**
     * 判断是否存在
     * @return
     */
    private boolean isExistRecord(String id){
        //构建查询体
        QueryBuilder<OrderRecord> result = DatabaseManager.getInstance().getOrderRecordDao().queryBuilder();
        result = result.where(OrderRecordDao.Properties.User_id.eq(id));
        if(result.list().isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * 查看预约信息
     */
    private void showOrder() {
        //构建查询体
        QueryBuilder<OrderRecord> result = DatabaseManager.getInstance().getOrderRecordDao().queryBuilder();
        result = result.where(OrderRecordDao.Properties.User_id.eq(id));
        OrderRecord orderRecord = result.list().get(0);
        String showInfo = "预约时间：\t" + orderRecord.getTime() + "\n"
                + "预约人：\t" + orderRecord.getUsername() + "\n"
                + "预约人数：\t" + orderRecord.getCount() + "\n"
                + "手机号：\t" + orderRecord.getPhone();
        DialogManager.warningDialogShow(getActivity(), "预约信息", showInfo);
    }

    /**
     * 预约
     */
    private void order(){
        //判断输入是否为空
        if(time_piker.getText().toString().equals("请选择日期") || input_name.getText().toString().isEmpty() || input_phone.getText().toString().isEmpty() || input_count.getText().toString().isEmpty()){
            DialogManager.warningDialogShow(getActivity(), "提示", "有预约项目为空，请检查！");
        }
        else {
            String time = time_piker.getText().toString();
            String userName = input_name.getText().toString();
            String phoneNumber = input_phone.getText().toString();
            String count = input_count.getText().toString();
            DatabaseManager.getInstance().getOrderRecordDao().insert(new OrderRecord(id, userName, time, phoneNumber, count));

            DialogManager.warningDialogShow(getActivity(), "提示", "插入成功！");
            order_button.setText("查看预约");
            cancel_order_tv.setVisibility(View.VISIBLE);
            isRecorded = true;
        }
    }

    private void cancelOrder(String id){
        QueryBuilder<OrderRecord> result = DatabaseManager.getInstance().getOrderRecordDao().queryBuilder();
        result = result.where(OrderRecordDao.Properties.User_id.eq(id));
        OrderRecord orderRecord = result.list().get(0);
        DatabaseManager.getInstance().getOrderRecordDao().deleteAll();

        order_button.setText("预   约");
        cancel_order_tv.setVisibility(View.GONE);
        isRecorded = false;
    }

}
