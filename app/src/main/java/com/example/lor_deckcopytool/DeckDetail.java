package com.example.lor_deckcopytool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NavUtils;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DeckDetail extends AppCompatActivity {

    Dialog myDialog;
    private String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref;
        sharedPref = new SharedPref(this);
        if(sharedPref.loadNightState()) {
            setTheme(R.style.DarkTheme);
        }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deck_detail);

        myDialog = new Dialog(this);
        String title = getIntent().getStringExtra("title");
        String tier = getIntent().getStringExtra("tier");
        String region_1 = getIntent().getStringExtra("region_1");
        String region_2 = getIntent().getStringExtra("region_2");
        String type = getIntent().getStringExtra("type");
        String descrp = getIntent().getStringExtra("descrp");
        String how = getIntent().getStringExtra("how");
        int hero_1 = getIntent().getIntExtra("hero_1",R.drawable.hero_elise);
        int hero_2 = getIntent().getIntExtra("hero_2",R.drawable.hero_elise);
        String heroname1 = getIntent().getStringExtra("heroname1");
        String heroname2 = getIntent().getStringExtra("heroname2");
        code = getIntent().getStringExtra("code");
        final Card card_1 = (Card) getIntent().getSerializableExtra("card_1");
        final Card card_2 = (Card) getIntent().getSerializableExtra("card_2");

        setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView titleView = findViewById(R.id.title2);
        TextView tierView = findViewById(R.id.tier2);
        TextView region1View = findViewById(R.id.region_12);
        ImageView region1_iconView = findViewById(R.id.region_1_icon2);
        ImageView region2_iconView = findViewById(R.id.region_2_icon2);
        TextView region2View = findViewById(R.id.region_22);
        ImageView type_iconView = findViewById(R.id.type_icon2);
        TextView typeView = findViewById(R.id.type2);
        TextView descrpView = findViewById(R.id.descrp);
        TextView howView = findViewById(R.id.how);
        ImageView hero_1View = findViewById(R.id.hero_1_2);
        ImageView hero_2View = findViewById(R.id.hero_2_2);
        TextView hero_name_1View = findViewById(R.id.hero_name_1);
        TextView hero_name_2View = findViewById(R.id.hero_name_2);

        hero_1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.card_detail);
                myDialog.setCanceledOnTouchOutside(true);
                ImageView imgView;
                imgView = myDialog.findViewById(R.id.card_detail);
                imgView.setImageResource(card_1.GetImg());
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            }
        });

        hero_2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.card_detail);
                myDialog.setCanceledOnTouchOutside(true);
                ImageView imgView;
                imgView = myDialog.findViewById(R.id.card_detail);
                imgView.setImageResource(card_2.GetImg());
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            }
        });


        titleView.setText(title);
        tierView.setText(tier);
        region1View.setText(region_1);
        region2View.setText(region_2);
        typeView.setText(type);
        descrpView.setText(descrp);
        howView.setText(how);
        hero_1View.setImageResource(hero_1);
        hero_2View.setImageResource(hero_2);
        hero_name_1View.setText(heroname1);
        hero_name_2View.setText(heroname2);
        /*----------------------------Title Style----------------------------*/
        /*----------------------------Tier Style----------------------------*/
        if(tier.equals("Tier S")){
            tierView.setBackgroundResource(R.drawable.tier_s_background);
            tierView.setTextColor(Color.parseColor("#FF2D2D"));
        }
        else if(tier.equals("Tier A")) {
            tierView.setBackgroundResource(R.drawable.tier_a_background);
            tierView.setTextColor(Color.parseColor("#FF8000"));
        }
        /*----------------------------Region1 Style----------------------------*/
        if(region_1.equals("諾克薩斯")){
            region1View.setTextColor(Color.parseColor("#a0524f"));
            region1_iconView.setImageResource(R.drawable.icon_noxus);
        }
        else if(region_1.equals("皮爾托福 & 左恩")){
            region1View.setTextColor(Color.parseColor("#e29f76"));
            region1_iconView.setImageResource(R.drawable.icon_piltover);
        }
        else if(region_1.equals("艾歐尼亞")){
            region1View.setTextColor(Color.parseColor("#cf829b"));
            region1_iconView.setImageResource(R.drawable.icon_ionia);
        }
        else if(region_1.equals("比爾吉沃特")){
            region1View.setTextColor(Color.parseColor("#8e473d"));
            region1_iconView.setImageResource(R.drawable.icon_bilgewater);
        }
        else if(region_1.equals("暗影島")){
            region1View.setTextColor(Color.parseColor("#3b7d6f"));
            region1_iconView.setImageResource(R.drawable.icon_shadowisles);
        }
        else if(region_1.equals("弗雷卓爾德")){
            region1View.setTextColor(Color.parseColor("#8fd7f3"));
            region1_iconView.setImageResource(R.drawable.icon_freljord);
        }
        else if(region_1.equals("德瑪西亞")){
            region1View.setTextColor(Color.parseColor("#e6d9b7"));
            region1_iconView.setImageResource(R.drawable.icon_demacia);
        }
        /*----------------------------Region2 Style----------------------------*/
        if(region_2.equals("諾克薩斯")){
            region2View.setTextColor(Color.parseColor("#a0524f"));
            region2_iconView.setImageResource(R.drawable.icon_noxus);
        }
        else if(region_2.equals("皮爾托福 & 左恩")){
            region2View.setTextColor(Color.parseColor("#e29f76"));
            region2_iconView.setImageResource(R.drawable.icon_piltover);
        }
        else if(region_2.equals("艾歐尼亞")){
            region2View.setTextColor(Color.parseColor("#cf829b"));
            region2_iconView.setImageResource(R.drawable.icon_ionia);
        }
        else if(region_2.equals("比爾吉沃特")){
            region2View.setTextColor(Color.parseColor("#8e473d"));
            region2_iconView.setImageResource(R.drawable.icon_bilgewater);
        }
        else if(region_2.equals("暗影島")){
            region2View.setTextColor(Color.parseColor("#3b7d6f"));
            region2_iconView.setImageResource(R.drawable.icon_shadowisles);
        }
        else if(region_2.equals("弗雷卓爾德")){
            region2View.setTextColor(Color.parseColor("#8fd7f3"));
            region2_iconView.setImageResource(R.drawable.icon_freljord);
        }
        else if(region_2.equals("德瑪西亞")){
            region2View.setTextColor(Color.parseColor("#e6d9b7"));
            region2_iconView.setImageResource(R.drawable.icon_demacia);
        }
        /*----------------------------Type Style----------------------------*/
        typeView.setTextColor(Color.parseColor("#6C6F93"));
        if(type.equals("快攻")){
            type_iconView.setImageResource(R.drawable.icon_aggro);
        }
        else if(type.equals("中速")){
            type_iconView.setImageResource(R.drawable.icon_midrange);
        }
        else if(type.equals("控制")){
            type_iconView.setImageResource(R.drawable.icon_control);
        }
        else if(type.equals("組合")){
            type_iconView.setImageResource(R.drawable.icon_combo);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void popup(View view) {
        TextView txtclose;
        TextView codeView;
        final Button btn_export;
        myDialog.setContentView(R.layout.export_popup);
        btn_export = myDialog.findViewById(R.id.btn_export);
        txtclose = myDialog.findViewById(R.id.txtclose);
        codeView = myDialog.findViewById(R.id.codeView);
        codeView.setText(code);
        txtclose.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        btn_export.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("code", code);
                clipboard.setPrimaryClip(clip);
                btn_export.setText("已複製!");
                Toast.makeText(getApplicationContext(),"已複製到剪貼簿",Toast.LENGTH_SHORT).show();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

}