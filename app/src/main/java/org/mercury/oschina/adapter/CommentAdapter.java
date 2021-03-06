package org.mercury.oschina.adapter;

import org.mercury.oschina.bean.Active;
import org.mercury.oschina.holder.BasicHolder;
import org.mercury.oschina.holder.CommentViewHolder;

import java.util.List;

/**
 * @创建者 Administrator
 * @创建时间 2016/8/18 12:08
 * @描述 ${TODU}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODU}
 */
public class CommentAdapter extends BasicAdapter<Active> {


    public CommentAdapter(List<Active> showItems) {
        super(showItems);
    }

    @Override
    public BasicHolder createViewHolder(int postion) {
        return new CommentViewHolder();
    }
}
