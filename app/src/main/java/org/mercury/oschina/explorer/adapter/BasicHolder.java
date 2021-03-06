package org.mercury.oschina.explorer.adapter;


import android.view.View;

import butterknife.ButterKnife;

/**
 * @创建者 Mercury
 * @创建时间 2016/8/16 16:43
 * @描述 ${TODO}
 */
public abstract class BasicHolder<T>{

    View view;

    public View getView() {
        return view;
    }

    public BasicHolder() {
        view = createView();

        ButterKnife.bind(this,view);

        view.setTag(this);

    }


    public abstract View createView();

    // 绑定数据
    public abstract void bindView(T appInfo);
}
