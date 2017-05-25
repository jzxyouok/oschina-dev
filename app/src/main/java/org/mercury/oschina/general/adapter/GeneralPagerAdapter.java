package org.mercury.oschina.general.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.mercury.oschina.R;
import org.mercury.oschina.base.AppContext;
import org.mercury.oschina.general.ui.BlogHeatFragment;
import org.mercury.oschina.general.ui.BlogNewestFragment;
import org.mercury.oschina.general.ui.FragmentInfo;
import org.mercury.oschina.general.ui.HotFragment;
import org.mercury.oschina.general.ui.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercury on 2016-08-02 19:49:25.
 *
 *
 */
public class GeneralPagerAdapter extends FragmentStatePagerAdapter {
    private  List<FragmentInfo> mDatas = new ArrayList<>();

    public  GeneralPagerAdapter(FragmentManager fm) {
        super(fm);
        String[] mTitles = AppContext.context.getResources().getStringArray(
                R.array.news_viewpage_arrays);
        mDatas.add(new FragmentInfo(mTitles[0], new NewsFragment()));
        mDatas.add(new FragmentInfo(mTitles[1], new HotFragment()));
        mDatas.add(new FragmentInfo(mTitles[2], new BlogNewestFragment()));
        mDatas.add(new FragmentInfo(mTitles[3], new BlogHeatFragment()));
    }

    @Override
    public Fragment getItem(int position) {
        return mDatas.get(position).fragment;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mDatas.get(position).title;
    }
}