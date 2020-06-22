package com.example.lor_deckcopytool.ui.deck;

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
import com.example.lor_deckcopytool.Deck;
import com.example.lor_deckcopytool.R;
import com.example.lor_deckcopytool.DeckAdapter;

import java.util.Vector;

public class DeckFragment extends Fragment {

    private RecyclerView mRV;
    private DeckAdapter mAdapter;
    private Vector<Card> cards = new Vector<Card>();
    private Vector<Deck> decks = new Vector<Deck>();


    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_deck, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cards.add(new Card("伊莉絲","暗影島",getString(R.string.card_d1),R.drawable.card_elise));
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
        cards.add(new Card("伊澤瑞爾", "皮爾托福 & 左恩",getString(R.string.card_d13),R.drawable.card_ezreal));

        decks.add(new Deck("泡麵頭菲艾", "Tier S", "艾歐尼亞", "皮爾托福 & 左恩", "中速",
                getString(R.string.d1), getString(R.string.h1), R.drawable.hero_vi, R.drawable.hero_heimerdinger, R.drawable.hero_vi_2,R.drawable.hero_heimerdinger_2,
                "菲艾","漢默丁格",getString(R.string.code1), cards.get(7), cards.get(8)));

        decks.add(new Deck("好運豬", "Tier S", "比爾吉沃特", "弗雷卓爾德", "中速",
                getString(R.string.d2), getString(R.string.h2),R.drawable.hero_missfortune,R.drawable.hero_sejuani,R.drawable.hero_missfortune_2,R.drawable.hero_sejuani_2,
                "好運姊", "史瓦妮",getString(R.string.code1), cards.get(4), cards.get(9)));

        decks.add(new Deck("寒冰暴行", "Tier S", "暗影島", "弗雷卓爾德", "中速",
                getString(R.string.d3), getString(R.string.h3),R.drawable.hero_kalista,R.drawable.hero_elise,R.drawable.hero_kalista_2,R.drawable.hero_elise_2,
                "克黎思妲","伊莉絲",getString(R.string.code1), cards.get(2), cards.get(0)));

        decks.add(new Deck("隱密劫", "Tier S", "艾歐尼亞", "弗雷卓爾德", "快攻",
                getString(R.string.d4), getString(R.string.h4),R.drawable.hero_zed,R.drawable.hero_none,R.drawable.hero_zed_2,R.drawable.hero_none_2,
                "劫","",getString(R.string.code1), cards.get(3), cards.get(3)));

        decks.add(new Deck("卡瑪EZ", "Tier A", "艾歐尼亞", "皮爾托福 & 左恩", "控制",
                getString(R.string.d5), getString(R.string.h5),R.drawable.hero_karma,R.drawable.hero_ezreal,R.drawable.hero_karma_2,R.drawable.hero_ezreal_2,
                "卡瑪","伊澤瑞爾",getString(R.string.code1), cards.get(10), cards.get(12)));

        decks.add(new Deck("探底海怪", "Tier A", "比爾吉沃特", "暗影島", "組合",
                getString(R.string.d6), getString(R.string.h6),R.drawable.hero_nautilus,R.drawable.hero_maokai,R.drawable.hero_nautilus_2,R.drawable.hero_maokai_2,
                "納帝魯斯","茂凱",getString(R.string.code1), cards.get(11), cards.get(6)));

        decks.add(new Deck("犽宿卡特", "Tier B", "艾歐尼亞", "諾克薩斯", "中速",
                getString(R.string.d7), getString(R.string.h7),R.drawable.hero_yasuo,R.drawable.hero_katarina,R.drawable.hero_yasuo_2,R.drawable.hero_katarina_2,
                "犽宿","卡特蓮娜",getString(R.string.code1), cards.get(5), cards.get(1)));

        mRV = view.findViewById(R.id.recyclerview);
        mAdapter = new DeckAdapter(getActivity(), decks);
        mRV.setAdapter(mAdapter);
        mRV.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }
}