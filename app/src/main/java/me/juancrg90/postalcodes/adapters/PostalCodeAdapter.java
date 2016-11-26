package me.juancrg90.postalcodes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.juancrg90.postalcodes.R;
import me.juancrg90.postalcodes.entities.PostalCode;

/**
 * Created by JuanCrg90 on 11/26/16.
 */

public class PostalCodeAdapter extends RecyclerView.Adapter<PostalCodeAdapter.ViewHolder> {

    private Context context;
    private List<PostalCode> dataset;

    public PostalCodeAdapter(Context context, List<PostalCode> dataset) {
        this.context = context;
        this.dataset = dataset;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostalCode element = dataset.get(position);
        String strPostalCode = "[" + element.getPostalCode() + "]: " + element.getPlaceName();

        holder.txtContent.setText(strPostalCode);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(PostalCode postalCode) {
        dataset.add(postalCode);
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
