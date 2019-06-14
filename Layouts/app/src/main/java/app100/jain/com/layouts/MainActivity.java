//package app100.jain.com.layouts;
//
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//
//import static android.widget.LinearLayout.*;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    LinearLayout ll;
//    ImageView iv[]=new ImageView[3];
//    @Override
//    public void onClick(View v) {
//
//    }
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ll=new LinearLayout(this);
//        ll.setOrientation(VERTICAL);
//        ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        for(int i=0;i<3;i++){
//            iv[i] = new ImageView(this);
//            iv[i].setImageResource(R.drawable.a);
//            iv[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
//            ll.addView(iv[i]);
//        }
//        //setContentView(R.layout.activity_main);
//
//        setContentView(ll);
//    }
//}
