﻿package cn.edu.sdwu.android.classroom.sn170507180224;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Main5Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout5);

    }

    public void toast1(View view){
        Toast.makeText(this,"toast1",Toast.LENGTH_SHORT).show();
    }
    public void toast2(View view){
        Toast toast=Toast.makeText(this,"toast2",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast .show();
    }
    public void toast3(View view) {
        //加载自定义的布局文件，将其转换为一个View类的实例
        LayoutInflater layoutInflater=getLayoutInflater();
        View view1=layoutInflater.inflate(R.layout.layout_toast,null);

        //设置显示的文本
        TextView textView=(TextView) view1.findViewById(R.id.tishi);
        textView.setText("toast3");

        Toast toast=new Toast(this);
        toast.setView(view1);//设置界面
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

    }
    public  void notification(View view){
        Notification.Builder builder=new Notification.Builder(this);
        //在构造器中，完成通知各种属性的设置
        builder.setContentTitle("title");
        builder.setContentText("massage");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统的资源
        //调用build方法，完成构造
        Notification notification=builder.build();
        //使用NotifiManager，发送通知
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(416,notification);
    }

    public void cancel_notification(View view){
        //使用NotificationManager取消通知
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(416);
    }
    public void alert_dialog(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //在构造器中设置对话框的属性
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_email);
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //添加点击按钮后的处理
                Toast.makeText(Main5Act.this,"confirm",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Main5Act.this,"exit",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Main5Act.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

}
