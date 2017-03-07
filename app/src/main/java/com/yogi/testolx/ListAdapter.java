package com.yogi.testolx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yogi.model.Item;

import java.util.List;

/**
 * Created by yogi on 07/03/17.
 */
public class ListAdapter extends
        RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private static final String TAG = ListAdapter.class.getSimpleName();

    private Context context;
    private List<Item> list;
    private OnItemClickListener onItemClickListener;

    public ListAdapter(Context context, List<Item> list,
                       OnItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title ;
        TextView subtitle ;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            img= (ImageView) itemView.findViewById(R.id.img_item);


        }

        public void bind(final Item model,
                         final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getLayoutPosition());

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.items, parent, false);


        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = list.get(position);

        holder.title.setText(item.Title);
        holder.subtitle.setText(item.PrimaryCategoryName);
        Picasso.with(context).load(item.GalleryURL)
                .centerCrop()
                .fit()
                .into(holder.img);

        holder.bind(item, onItemClickListener);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}