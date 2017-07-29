package com.mxt.anitrend.adapter.recycler.index;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mxt.anitrend.R;
import com.mxt.anitrend.api.model.Character;
import com.mxt.anitrend.custom.recycler.RecyclerViewAdapter;
import com.mxt.anitrend.custom.recycler.RecyclerViewHolder;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;

/**
 * Created by max on 2017/07/14.
 */

public class CharacterSearchAdapter  extends RecyclerViewAdapter<Character> {

    public CharacterSearchAdapter(List<Character> adapter, FragmentActivity context) {
        super(adapter, context);
    }

    @Override
    public RecyclerViewHolder<Character> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CharacterSearchAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_character_staff_v2, parent, false));
    }

    /**
     * <p>Returns a filter that can be used to constrain data with a filtering
     * pattern.</p>
     * <p>
     * <p>This method is usually implemented by {@link Adapter}
     * classes.</p>
     *
     * @return a filter used to constrain data
     */
    @Override
    public Filter getFilter() {
        return null;
    }

    class ViewHolder extends RecyclerViewHolder<Character> {

        @BindView(R.id.character_model_name) TextView name;
        @BindView(R.id.character_model_image) ImageView model_image;

        ViewHolder(View view) {
            super(view);
            model_image.setOnClickListener(this);
        }

        @Override
        public void onBindViewHolder(Character model) {

            Glide.with(mContext).load(model.getImage_url_lge())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(model_image);

            name.setText(String.format(Locale.getDefault(), "%s %s", model.getName_first(), model.getName_last()));
        }

        @Override
        public void onViewRecycled() {
            Glide.clear(model_image);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.character_model_image:
                    Toast.makeText(mContext, R.string.TBA, Toast.LENGTH_SHORT).show();
                    // TODO: 2017/07/14 send the full object or create a character small object
                    /*Intent intent = new Intent(mContext, CharacterActivity.class);
                    intent.putExtra(CharacterActivity.CHARACTER_OBJECT_PARAM, mAdapter.get(getAdapterPosition()));
                    mContext.startActivity(intent);*/
                    break;
            }
        }
    }
}