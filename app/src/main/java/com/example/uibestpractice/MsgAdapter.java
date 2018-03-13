package com.example.uibestpractice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jared on 16/2/10.
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;

    static class ViewHolder  extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView head1;
        ImageView head2;

        public ViewHolder(View view){
            super(view);
            leftLayout = view.findViewById(R.id.left_layout);
            rightLayout = view.findViewById(R.id.right_layout);
            leftMsg = view.findViewById(R.id.left_msg);
            rightMsg = view.findViewById(R.id.right_msg);
            head1 = view.findViewById(R.id.head_left);
            head2 = view.findViewById(R.id.head_right);
        }
    }
    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.head2.setImageResource(View.VISIBLE);
            holder.leftMsg.setText(msg.getContent());
        }else if (msg.getType() == Msg.TYPE_SEND){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.head1.setImageResource(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }
    }
    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

}