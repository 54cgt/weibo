package net.cgt.weibo.factory;

import android.app.Fragment;

/**
 * Fragment工厂
 * 
 * @author lijian-pc
 * 
 */
public class FragmentFactory {
	public static Fragment getInstanceByIndex(int index) {
		Fragment fragment = null;
		switch (index) {
		case 1:// 首页
			fragment = new HomeFragment();
			break;
		case 2:// 消息
			fragment = new MessageFragment();
			break;
		case 3:// 我
			fragment = new MeFragment();
			break;
		case 4:// 广场
			fragment = new DiscoverFragment();
			break;
		case 5:// 更多
			fragment = new MoreFragment();
			break;
		}
		return fragment;
	}
}
