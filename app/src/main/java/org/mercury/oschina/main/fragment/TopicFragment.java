package org.mercury.oschina.main.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.mercury.oschina.R;
import org.mercury.oschina.adapter.CollectAdapter;
import org.mercury.oschina.base.AppContext;
import org.mercury.oschina.bean.Favorite;
import org.mercury.oschina.bean.FavoriteList;
import org.mercury.oschina.main.activity.NoteDetailActivity;
import org.mercury.oschina.utils.OschinaUri;
import org.mercury.oschina.utils.Utils;
import org.mercury.oschina.utils.XmlUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


/**
 * @创建者 Administrator
 * @创建时间 2016/8/15 2:29
 * @描述 ${TODU}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODU}
 */
public class TopicFragment extends BasicFragment implements AdapterView.OnItemClickListener {

    private PullToRefreshListView mPtrlistView;

    private List<Favorite> list = new ArrayList<>();
    private List<Favorite> mFavorites;

    @Override
    public View createView() {

        mPtrlistView =
                (PullToRefreshListView) View.inflate(AppContext.context, R.layout.refresh_list_view_layout, null);

        // 设置模式
        mPtrlistView.setMode(PullToRefreshBase.Mode.BOTH);

        mPtrlistView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                // 网络操作
                mMLoadPager.loadData();
            }
        });
       // mPtrlistView.setOnItemClickListener(this);
        return mPtrlistView;
    }

    @Override
    protected Object loadDataThread() {
        OkHttpUtils
                .get()
                .url(OschinaUri.COLLECT_2)

                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int i) {

                        Toast.makeText(AppContext.context, "请求失败!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        // Toast.makeText(AppContext.context, "请求成功!", Toast.LENGTH_SHORT).show();
                        FavoriteList favoriteList = XmlUtils.toBean(FavoriteList.class, s.getBytes());
                        mFavorites = favoriteList.getList();

                        Utils.runOnUIThread(new Runnable() {

                            private CollectAdapter mCollectAdapter;

                            @Override
                            public void run() {
                                mCollectAdapter = new CollectAdapter(mFavorites);

                                mPtrlistView.setAdapter(mCollectAdapter);
                                //停止刷新

                                mPtrlistView.onRefreshComplete();
                            }
                        });

                    }
                });
        return "";
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getContext(), NoteDetailActivity.class);
        if (list != null) {
            intent.putExtra("TianZi", mFavorites.get((int) id).getUrl());
              //intent.putExtra("TianZi", "http://www.oschina.net/question/2005680_243669");
            startActivity(intent);

        }

    }
}
