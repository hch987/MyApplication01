package cn.edu.sdwu.android.classroom.sn170507180224;

import android.app.WallpaperManager;
        import android.content.Intent;
        import android.media.MediaCodec;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity implements View.OnFocusChangeListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //加载界面，不要写文件android.R.attr名，使用资源id来引用资源
        setContentView(R.layout.ch41);

        //1）获取普通界面组件:必须在setContentView之后，调用findViewById方法
        Button button= (Button) findViewById(R.id.button1);
        ImageView imageView=(ImageView)findViewById(R.id.main2);
        //3)调用事件源的setXXXListener方法注册时间监听器
        button.setOnClickListener(new MyClickListener());

        //使用内部匿名类注册监听器

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //设置
                WallpaperManager wallpaperManager= (WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try{
                    wallpaperManager.setResource(R.raw.bizhi1);
                }catch(Exception e){
                    Log.e(Main2Activity.class.toString(),e.toString());
                }

                return true;
            }
        });
        EditText email= (EditText) findViewById(R.id.email1);
        email.setOnFocusChangeListener(this);

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ll);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x=motionEvent.getX();
                float y=motionEvent.getY();
                TextView textView=(TextView) findViewById(R.id.tishi1);
                textView.setText("x:"+x+",y:"+y);
                return true;
            }
        });

    }

    public void onFocusChange(View view, boolean b) {
        //参数b代表是否获取焦点
        //判断邮箱地址的合法性
        EditText editText=(EditText)view;
        if(!b){
            String content=editText.getText().toString();//得到EditText的内容
            //判断邮箱地址的正则表达式
            String regEx1="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern pattern= Pattern.compile(regEx1);
            Matcher matcher=pattern.matcher(content);
            TextView textView=(TextView)findViewById(R.id.tishi1);
            if(matcher.matches()){
                textView.setText("");
            }else{
                textView.setText("email invalidate");
            }
        }
    }

    //2）实现事件监听类，该监听类是一个特殊的java类，必须实现一个 XXXListener接口
    class  MyClickListener implements View.OnClickListener{
        public void onClick(View view){

            Log.i(Main2Activity.class.toString(),"button click");
        }
    }

    public void startMain(View view){
        //界面跳转
        Intent intent=new Intent(this,MainAct.class);
        startActivity(intent);

    }

}
