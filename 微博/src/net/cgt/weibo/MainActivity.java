package net.cgt.weibo;

import net.cgt.weibo.factory.FragmentFactory;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 主控制界面
 * 
 * @author lijian-pc
 * 
 */
@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnCheckedChangeListener {

	private FragmentManager mFragmentManager;
	private RadioGroup mRg_tab;
	private int pageNumber = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cgt_activity_main);
		init();
	}

	private void init() {
		initUI();
		initData();
	}

	private void initUI() {
		mFragmentManager = getFragmentManager();
		mRg_tab = (RadioGroup) findViewById(R.id.cgt_rg_tab);
		mRg_tab.setOnCheckedChangeListener(this);
	}

	private void initData() {
		SharedPreferences sp = this.getSharedPreferences("config", MODE_PRIVATE);
		Editor mEditor = sp.edit();
		mEditor.putInt("pageNumber", pageNumber);
		int id = sp.getInt("pageNumber", 1);
		showPreviousPage(id);
	}

	/**
	 * 显示上次退出时的页面
	 * 
	 * @param id
	 */
	private void showPreviousPage(int id) {
		RadioButton mRb_show = null;
		switch (id) {
		case 1:
			mRb_show = (RadioButton) findViewById(R.id.cgt_rb_home);
			break;
		case 2:
			mRb_show = (RadioButton) findViewById(R.id.cgt_rb_message);
			break;
		case 3:
			mRb_show = (RadioButton) findViewById(R.id.cgt_rb_me);
			break;
		case 4:
			mRb_show = (RadioButton) findViewById(R.id.cgt_rb_discover);
			break;
		case 5:
			mRb_show = (RadioButton) findViewById(R.id.cgt_rb_more);
			break;
		default:
			mRb_show = (RadioButton) findViewById(R.id.cgt_rb_home);
			break;
		}
		mRb_show.setChecked(true);
		ShowFragmen(id);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		int id = 1;
		switch (checkedId) {
		case R.id.cgt_rb_home:
			id = 1;
			break;
		case R.id.cgt_rb_message:
			id = 2;
			break;
		case R.id.cgt_rb_me:
			id = 3;
			break;
		case R.id.cgt_rb_discover:
			id = 4;
			break;
		case R.id.cgt_rb_more:
			id = 5;
			break;
		default:
			id = 1;
			break;
		}

		ShowFragmen(id);
	}

	/**
	 * 显示Fragment页面
	 * 
	 * @param id
	 */
	private void ShowFragmen(int id) {
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		Fragment fragment = FragmentFactory.getInstanceByIndex(id);
		transaction.replace(R.id.cgt_fl_content, fragment);
		transaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
