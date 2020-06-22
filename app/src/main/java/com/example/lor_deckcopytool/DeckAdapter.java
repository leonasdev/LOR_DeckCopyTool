package com.example.lor_deckcopytool;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.ViewHolder> {
    private Vector<Deck> decks;
    private Context context;
    public DeckAdapter(Context context, Vector<Deck> decks){
        this.decks = decks;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView titleView;
        public final TextView tierView;
        public final TextView region1View;
        public final ImageView region1_iconView;
        public final ImageView region2_iconView;
        public final TextView region2View;
        public final ImageView type_iconView;
        public final TextView typeView;
        public final ImageView hero1View;
        public final ImageView hero2View;

        ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
            tierView = itemView.findViewById(R.id.tier);
            region1View = itemView.findViewById(R.id.region_1);
            region1_iconView = itemView.findViewById(R.id.region_1_icon);
            region2_iconView = itemView.findViewById(R.id.region_2_icon);
            region2View = itemView.findViewById(R.id.region_2);
            type_iconView = itemView.findViewById(R.id.type_icon);
            typeView = itemView.findViewById(R.id.type);
            hero1View = itemView.findViewById(R.id.hero_1);
            hero2View = itemView.findViewById(R.id.hero_2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Deck mCurrent = decks.get(getAdapterPosition());
                    Intent intent = new Intent(context, DeckDetail.class);
                    intent.putExtra("title", mCurrent.GetTitle());
                    intent.putExtra("tier", mCurrent.GetTier());
                    intent.putExtra("region_1", mCurrent.GetRegion_1());
                    intent.putExtra("region_2", mCurrent.GetRegion_2());
                    intent.putExtra("type", mCurrent.GetType());
                    intent.putExtra("descrp", mCurrent.GetDescrp());
                    intent.putExtra("how", mCurrent.GetHow());
                    intent.putExtra("hero_1", mCurrent.GetHero_1_2());
                    intent.putExtra("hero_2", mCurrent.GetHero_2_2());
                    intent.putExtra("heroname1", mCurrent.GetHeroName_1());
                    intent.putExtra("heroname2", mCurrent.GetHeroName_2());
                    intent.putExtra("code", mCurrent.GetCode());

                    intent.putExtra("card_1", mCurrent.GetCard_1());
                    intent.putExtra("card_2", mCurrent.GetCard_2());

                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public DeckAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // Inflate an item_deck view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deck, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeckAdapter.ViewHolder holder,
                                 int position) {
        // Retrieve the data for that position.
        //String mCurrent = mWordList.get(position).GetTier();
        Deck mCurrent = (Deck) decks.get(position);
        // Add the data to the view holder.
        holder.titleView.setText(mCurrent.GetTitle());
        holder.tierView.setText(mCurrent.GetTier());
        holder.region1View.setText(mCurrent.GetRegion_1());
        holder.region2View.setText(mCurrent.GetRegion_2());
        holder.typeView.setText(mCurrent.GetType());
        holder.hero1View.setImageResource(mCurrent.GetHero_1());
        holder.hero2View.setImageResource(mCurrent.GetHero_2());
        /*----------------------------Title Style----------------------------*/
        /*----------------------------Tier Style----------------------------*/
        if(mCurrent.GetTier().equals("Tier S")){
            holder.tierView.setBackgroundResource(R.drawable.tier_s_background);
            holder.tierView.setTextColor(Color.parseColor("#FF2D2D"));
        }
        else if(mCurrent.GetTier().equals("Tier A")) {
            holder.tierView.setBackgroundResource(R.drawable.tier_a_background);
            holder.tierView.setTextColor(Color.parseColor("#FF8000"));
        }
        /*----------------------------Region1 Style----------------------------*/
        if(mCurrent.GetRegion_1().equals("諾克薩斯")){
            holder.region1View.setTextColor(ContextCompat.getColor(context, R.color.noxus));
            holder.region1_iconView.setImageResource(R.drawable.icon_noxus);
        }
        else if(mCurrent.GetRegion_1().equals("皮爾托福 & 左恩")){
            holder.region1View.setTextColor(ContextCompat.getColor(context, R.color.piltover_zaun));
            holder.region1_iconView.setImageResource(R.drawable.icon_piltover);
        }
        else if(mCurrent.GetRegion_1().equals("艾歐尼亞")){
            holder.region1View.setTextColor(ContextCompat.getColor(context, R.color.ionia));
            holder.region1_iconView.setImageResource(R.drawable.icon_ionia);
        }
        else if(mCurrent.GetRegion_1().equals("比爾吉沃特")){
            holder.region1View.setTextColor(ContextCompat.getColor(context, R.color.bilgewater));
            holder.region1_iconView.setImageResource(R.drawable.icon_bilgewater);
        }
        else if(mCurrent.GetRegion_1().equals("暗影島")){
            holder.region1View.setTextColor(ContextCompat.getColor(context, R.color.shadow_isles));
            holder.region1_iconView.setImageResource(R.drawable.icon_shadowisles);
        }
        else if(mCurrent.GetRegion_1().equals("弗雷卓爾德")){
            holder.region1View.setTextColor(ContextCompat.getColor(context, R.color.freljord));
            holder.region1_iconView.setImageResource(R.drawable.icon_freljord);
        }
        else if(mCurrent.GetRegion_1().equals("德瑪西亞")){
            holder.region1View.setTextColor(ContextCompat.getColor(context, R.color.demacia));
            holder.region1_iconView.setImageResource(R.drawable.icon_demacia);
        }
        /*----------------------------Region2 Style----------------------------*/
        if(mCurrent.GetRegion_2().equals("諾克薩斯")){
            holder.region2View.setTextColor(ContextCompat.getColor(context, R.color.noxus));
            holder.region2_iconView.setImageResource(R.drawable.icon_noxus);
        }
        else if(mCurrent.GetRegion_2().equals("皮爾托福 & 左恩")){
            holder.region2View.setTextColor(ContextCompat.getColor(context, R.color.piltover_zaun));
            holder.region2_iconView.setImageResource(R.drawable.icon_piltover);
        }
        else if(mCurrent.GetRegion_2().equals("艾歐尼亞")){
            holder.region2View.setTextColor(ContextCompat.getColor(context, R.color.ionia));
            holder.region2_iconView.setImageResource(R.drawable.icon_ionia);
        }
        else if(mCurrent.GetRegion_2().equals("比爾吉沃特")){
            holder.region2View.setTextColor(ContextCompat.getColor(context, R.color.bilgewater));
            holder.region2_iconView.setImageResource(R.drawable.icon_bilgewater);
        }
        else if(mCurrent.GetRegion_2().equals("暗影島")){
            holder.region2View.setTextColor(ContextCompat.getColor(context, R.color.shadow_isles));
            holder.region2_iconView.setImageResource(R.drawable.icon_shadowisles);
        }
        else if(mCurrent.GetRegion_2().equals("弗雷卓爾德")){
            holder.region2View.setTextColor(ContextCompat.getColor(context, R.color.freljord));
            holder.region2_iconView.setImageResource(R.drawable.icon_freljord);
        }
        else if(mCurrent.GetRegion_2().equals("德瑪西亞")){
            holder.region2View.setTextColor(ContextCompat.getColor(context, R.color.demacia));
            holder.region2_iconView.setImageResource(R.drawable.icon_demacia);
        }
        /*----------------------------Type Style----------------------------*/
        if(mCurrent.GetType().equals("快攻")){
            holder.type_iconView.setImageResource(R.drawable.icon_aggro);
        }
        else if(mCurrent.GetType().equals("中速")){
            holder.type_iconView.setImageResource(R.drawable.icon_midrange);
        }
        else if(mCurrent.GetType().equals("控制")){
            holder.type_iconView.setImageResource(R.drawable.icon_control);
        }
        else if(mCurrent.GetType().equals("組合")){
            holder.type_iconView.setImageResource(R.drawable.icon_combo);
        }

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return decks.size();
    }
}