package com.example.lor_deckcopytool.ui.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lor_deckcopytool.Card;
import com.example.lor_deckcopytool.CardAdapter;
import com.example.lor_deckcopytool.R;

import java.util.Vector;

public class CardFragment extends Fragment {

    private RecyclerView mRV;
    private CardAdapter mAdapter;
    private Vector<Card> cards = new Vector<Card>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_card, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cards.add(new Card("伊莉絲","暗影島",getString(R.string.card_d1),R.drawable.card_elise));
        cards.add(new Card("伊澤瑞爾", "皮爾托福 & 左恩",getString(R.string.card_d13),R.drawable.card_ezreal));
        cards.add(new Card("卡特蓮娜","諾克薩斯",getString(R.string.card_d2),R.drawable.card_katarina));
        cards.add(new Card("克黎思妲","暗影島",getString(R.string.card_d3),R.drawable.card_kalista));
        cards.add(new Card("劫","諾克薩斯",getString(R.string.card_d4),R.drawable.card_zed));
        cards.add(new Card("好運姊","比爾吉沃特",getString(R.string.card_d5),R.drawable.card_missfortune));
        cards.add(new Card("犽宿","艾歐尼亞",getString(R.string.card_d6),R.drawable.card_yasuo));
        cards.add(new Card("茂凱","暗影島",getString(R.string.card_d7),R.drawable.card_maokai));
        cards.add(new Card("菲艾","皮爾托福 & 左恩",getString(R.string.card_d8),R.drawable.card_vi));
        cards.add(new Card("漢默丁格","皮爾托福 & 左恩",getString(R.string.card_d9),R.drawable.card_heimerdinger));
        cards.add(new Card("史瓦妮","弗雷卓爾德",getString(R.string.card_d10),R.drawable.card_sejuani));
        cards.add(new Card("卡瑪","艾歐尼亞",getString(R.string.card_d11),R.drawable.card_karma));
        cards.add(new Card("那帝魯斯","比爾吉沃特",getString(R.string.card_d12),R.drawable.card_nautilus));

        mRV = view.findViewById(R.id.recyclerview2);
        mAdapter = new CardAdapter(getActivity(), cards);
        mRV.setAdapter(mAdapter);
        mRV.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }
}