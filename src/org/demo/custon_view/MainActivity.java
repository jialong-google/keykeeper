package org.demo.custon_view;

//import com.example.box.DisplayMessageActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends BaseActivity {
    /** Called when the activity is first created. */
	boolean isLock=true;
	String pass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
 //  @Override
//public boolean onTouchEvent(MotionEvent event) {
//	// TODO Auto-generated method stub
//	   startActivity(new Intent(this, SecondActivity.class));
//	return super.onTouchEvent(event);
//}
    
    
    
    
//开启认证过程
   public void begin_my_progress(View view){
	   SharedPreferences preferences = getSharedPreferences("angellpay", MODE_WORLD_READABLE);
		pass=preferences.getString("gesturePass", null);
		if(pass!=null)
		{
			Log.d("password_init",pass);
			startActivity(new Intent(MainActivity.this,LockActivity.class));//验证锁
		}
		else
			startActivity(new Intent(MainActivity.this,GesturePassActivity.class));//设置锁
	//	Intent intent=new Intent(this, SecondActivity.class);//开启认证过程
	//	//A Context as its first parameter (this is used because the Activity class is a subclass of Context)
	//	startActivity(intent);//
		//return super.onTouchEvent(event);
	}
}