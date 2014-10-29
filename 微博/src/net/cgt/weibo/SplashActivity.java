package net.cgt.weibo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 欢迎界面
 * 
 * @author lijian-pc
 * 
 */
public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cgt_activity_splash);

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		};
		new Timer().schedule(timerTask, 3000);
	}
}
