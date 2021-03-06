package org.mercury.oschina.explorer.adapter;

import org.mercury.oschina.explorer.bean.FindUserBean;
import org.mercury.oschina.explorer.holder.FindUserHolder;
import org.mercury.oschina.synthesis.adapter.BasicAdapter;
import org.mercury.oschina.synthesis.holder.BasicHolder;

/**
 * Created by Mercury on 2016-08-19 12:55:43.
 */
public class FindUserAdapter extends BasicAdapter<FindUserBean.ObjListBean> {
    @Override
    protected BasicHolder createHolder(int position) {
        return new FindUserHolder();
    }
}
