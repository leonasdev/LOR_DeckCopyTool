package com.example.lor_deckcopytool;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private Vector<Card> cards;
    private Context context;
    Dialog myDialog;
    public CardAdapter(Context context, Vector<Card> cards){
        this.cards = cards;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView title_cardView;
        public final TextView region_textView;
        public final ImageView region_iconView;
        public final ImageView card_imgView;
        public final TextView dscrp_cardView;

        ViewHolder(View itemView) {
            super(itemView);
            title_cardView = itemView.findViewById(R.id.title_card);
            dscrp_cardView = itemView.findViewById(R.id.dscrp_card);
            region_textView = itemView.findViewById(R.id.region_text);
            region_iconView = itemView.findViewById(R.id.region_icon);
            card_imgView = itemView.findViewById(R.id.card_img);
            myDialog = new Dialog(itemView.getContext());

            card_imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Card mCurrent = cards.get(getAdapterPosition());
                    myDialog.setContentView(R.layout.card_detail);
                    myDialog.setCanceledOnTouchOutside(true);
                    ImageView imgView;
                    imgView = myDialog.findViewById(R.id.card_detail);
                    imgView.setImageResource(mCurrent.GetImg());
                    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    myDialog.show();
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Card mCurrent = cards.get(getAdapterPosition());
//                    Intent intent = new Intent(context, DeckDetail.class);
//                    intent.putExtra("title", mCurrent.GetTitle());
//                    intent.putExtra("region", mCurrent.GetRegion());
//                    intent.putExtra("descrp", mCurrent.GetDescrp());
//                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // Inflate an item_deck view.

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapter.ViewHolder holder,
                                 int position) {
        // Retrieve the data for that position.
        //String mCurrent = mWordList.get(position).GetTier();
        Card mCurrent = (Card) cards.get(position);
        // Add the data to the view holder.
        holder.title_cardView.setText(mCurrent.GetTitle());
        holder.dscrp_cardView.setText(mCurrent.GetDescrp());
        holder.region_textView.setText(mCurrent.GetRegion());
        holder.card_imgView.setImageResource(mCurrent.GetImg());
        /*----------------------------Title Img Style----------------------------*/
        /*----------------------------Region Style----------------------------*/
        if(mCurrent.GetRegion().equals("諾克薩斯")){
            holder.region_textView.setTextColor(ContextCompat.getColor(context, R.color.noxus));
            holder.region_iconView.setImageResource(R.drawable.icon_noxus);
        }
        else if(mCurrent.GetRegion().equals("皮爾托福 & 左恩")){
            holder.region_textView.setTextColor(ContextCompat.getColor(context, R.color.piltover_zaun));
            holder.region_iconView.setImageResource(R.drawable.icon_piltover);
        }
        else if(mCurrent.GetRegion().equals("艾歐尼亞")){
            holder.region_textView.setTextColor(ContextCompat.getColor(context, R.color.ionia));
            holder.region_iconView.setImageResource(R.drawable.icon_ionia);
        }
        else if(mCurrent.GetRegion().equals("比爾吉沃特")){
            holder.region_textView.setTextColor(ContextCompat.getColor(context, R.color.bilgewater));
            holder.region_iconView.setImageResource(R.drawable.icon_bilgewater);
        }
        else if(mCurrent.GetRegion().equals("暗影島")){
            holder.region_textView.setTextColor(ContextCompat.getColor(context, R.color.shadow_isles));
            holder.region_iconView.setImageResource(R.drawable.icon_shadowisles);
        }
        else if(mCurrent.GetRegion().equals("弗雷卓爾德")){
            holder.region_textView.setTextColor(ContextCompat.getColor(context, R.color.freljord));
            holder.region_iconView.setImageResource(R.drawable.icon_freljord);
        }
        else if(mCurrent.GetRegion().equals("德瑪西亞")){
            holder.region_textView.setTextColor(ContextCompat.getColor(context, R.color.demacia));
            holder.region_iconView.setImageResource(R.drawable.icon_demacia);
        }

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return cards.size();
    }
}