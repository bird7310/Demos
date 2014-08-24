package com.ahacool.circleviewpager;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * @ClassName MainActivity
 * @Description 循环滑动viewpager的一种方法，滑动很流畅。实现方法：在实际显示的界面头和尾分别增加一个界面。
 * @author Moto
 * @date 2014 2014-7-18
 * 
 */
public class MainActivity extends Activity implements OnPageChangeListener {

	private ViewPager mViewPager;
	private ViewGroup mPointViewGroup;
	private ArrayList<View> mViewPagerList;
	private boolean mIsChanged = false;
	private int mCurrentPagePosition = FIRST_ITEM_INDEX;
	private int mCurrentIndex;
	private static final int POINT_LENGTH = 3;
	private static final int FIRST_ITEM_INDEX = 1;
	private static final String TAG = "MOTO";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
	}

	private void initUI() {
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mPointViewGroup = (ViewGroup) findViewById(R.id.point_layout);

		mViewPagerList = new ArrayList<View>();
		// 增加第1个界面,实际上他显示的是最后一个界面
		addTextView(POINT_LENGTH - 1);
		// 增加实际显示的2、3、4界面
		for (int i = 0; i < 3; i++) {
			addTextView(i);
			addPoint(i);
		}
		// 增加最后的第5个界面，实际上他显示的是第一个界面
		addTextView(0);

		PagerAdapter pagerAdapter = new CustomPagerAdapter(mViewPagerList);
		mViewPager.setAdapter(pagerAdapter);
		mViewPager.setOnPageChangeListener(this);
		mViewPager.setCurrentItem(mCurrentPagePosition, false);
	}

	private void addTextView(int pIndex) {
		TextView textview = new TextView(this);
		textview.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		textview.setGravity(Gravity.CENTER);
		textview.setText("这是第" + (pIndex + 1) + "个页面");
		textview.setTextSize(50);
		mViewPagerList.add(textview);
	}

	private void addPoint(int pIndex) {
		ImageView pointImageView = new ImageView(this);
		LayoutParams layoutParams = new LayoutParams(20, 20);
		layoutParams.setMargins(10, 0, 10, 0);
		pointImageView.setLayoutParams(layoutParams);
		pointImageView.setBackgroundResource(R.drawable.point_style);
		if (0 == pIndex) {
			pointImageView.setEnabled(false);
		}
		mPointViewGroup.addView(pointImageView);
	}

	private void setCurrentDot(int positon) {
		// 界面实际显示的序号是第1, 2, 3。而点的序号应该是0, 1, 2.所以减1.
		positon = positon - 1;
		if (positon < 0 || positon > mViewPagerList.size() - 1 || mCurrentIndex == positon) {
			return;
		}
		mPointViewGroup.getChildAt(positon).setEnabled(false);
		mPointViewGroup.getChildAt(mCurrentIndex).setEnabled(true);
		mCurrentIndex = positon;
	}

	@Override
	public void onPageScrollStateChanged(int pState) {
		if (ViewPager.SCROLL_STATE_IDLE == pState) {
			if (mIsChanged) {
				mIsChanged = false;
				mViewPager.setCurrentItem(mCurrentPagePosition, false);
			}
		}
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int pPosition) {
		mIsChanged = true;
		if (pPosition > POINT_LENGTH) {
			mCurrentPagePosition = FIRST_ITEM_INDEX;
		} else if (pPosition < FIRST_ITEM_INDEX) {
			mCurrentPagePosition = POINT_LENGTH;
		} else {
			mCurrentPagePosition = pPosition;
		}
		Log.i(TAG,"当前的位置是"+mCurrentPagePosition);
		setCurrentDot(mCurrentPagePosition);
	}

}
