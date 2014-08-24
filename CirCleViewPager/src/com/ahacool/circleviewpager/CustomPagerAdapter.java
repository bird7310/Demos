package com.ahacool.circleviewpager;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * @ClassName ImageViewPagerAdapter
 * @Description TODO
 * @author Moto
 * @date 2014 2014-7-1
 * 
 */
public class CustomPagerAdapter extends PagerAdapter {

	private ArrayList<View> mViewList;

	public CustomPagerAdapter(ArrayList<View> pArrayList) {
		this.mViewList = pArrayList;
	}

	@Override
	public int getCount() {
		if (mViewList != null) {
			return mViewList.size();
		}
		return 0;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViewList.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int pPosition) {
		container.addView(mViewList.get(pPosition), 0);
		return mViewList.get(pPosition);
	}

	@Override
	public boolean isViewFromObject(View pView, Object pObject) {
		return (pView == pObject);
	}
}
