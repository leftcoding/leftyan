package com.ling.leftyan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mvc.multiple.MultipleStatusView;

public class MainActivity extends Activity {
    MultipleStatusView mMultipleStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.multiple);

        mMultipleStatusView.showLoading();//显示加载界面
        // 数据请求开始 ....
        // new Thread()
        // 数据请求结束 ....

        mMultipleStatusView.showDisNetwork();

        //已经自定义DisNetwork
        View disNetWorkView = mMultipleStatusView.getDisNotWork();
        if (disNetWorkView != null) {
            TextView customText = (TextView) disNetWorkView.findViewById(R.id.custom_disnetwork_txt);
            customText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "自定义DisNetwork 控件点击了", Toast.LENGTH_SHORT).show();
                }
            });

            disNetWorkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "自定义DisNetwork 界面点击了", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //根据需求，显示不同的布局。
//        mMultipleStatusView.showContent();//显示内容界面
//        mMultipleStatusView.showDisNetwork();//显示无网络界面
//        mMultipleStatusView.showError();//显示加载错界面
//        mMultipleStatusView.showEmpty();//显示空数据界面
    }
}
