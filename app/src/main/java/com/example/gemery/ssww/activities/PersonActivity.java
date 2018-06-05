package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by gemery on 2018/4/12.
 */

public class PersonActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.img_user_avatar)
    CircleImageView imgUserAvatar;
    @BindView(R.id.tv_all_order)
    TextView tvAllOrder;
    @BindView(R.id.tv_all_account_arrow)
    IconTextView tvAllAccountArrow;
    @BindView(R.id.ll_pay)
    LinearLayout llPay;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.ll_receive)
    LinearLayout llReceive;
    @BindView(R.id.ll_evaluate)
    LinearLayout llEvaluate;
    @BindView(R.id.ll_after_market)
    LinearLayout llAfterMarket;
    @BindView(R.id.icon2)
    IconTextView icon2;
    @BindView(R.id.tv_account_arrow1)
    IconTextView tvAccountArrow1;
    @BindView(R.id.icom1)
    IconTextView icom1;
    @BindView(R.id.tv_arrow2)
    IconTextView tvArrow2;
    @BindView(R.id.icon3)
    IconTextView icon3;
    @BindView(R.id.tv_arrow3)
    IconTextView tvArrow3;
    @BindView(R.id.icon4)
    IconTextView icon4;
    @BindView(R.id.tv_arrow4)
    IconTextView tvArrow4;
    @BindView(R.id.sign_up_button)
    Button signUpButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_bar_back})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
        }
    }


}
