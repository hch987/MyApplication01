package cn.edu.sdwu.android.classroom.sn170507180224;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Main4Act extends AppCompatActivity {
    private ArrayList list;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);
        list=new ArrayList();
        textView=(TextView) findViewById(R.id.tishi2);
        //通过界面的容器，找到他包含的所有子元素，再来注册监听器
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.lay);
        int count=linearLayout.getChildCount();
        for(int i=0;i<count;i++){
            View view=linearLayout.getChildAt(i);
            if(view instanceof CheckBox){
                final CheckBox checkBox=(CheckBox) view;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            list.add(compoundButton);
                        }else{
                            list.remove(compoundButton);
                        }

                        String content="you select: ";
                        for(int t=0;t<list.size();t++){
                            CheckBox checkBox1=(CheckBox) list.get(t);
                            String sel=checkBox1.getText().toString();
                            content+=sel+",";
                        }
                        textView.setText(content);

                    }
                });
            }
        }
    }

}