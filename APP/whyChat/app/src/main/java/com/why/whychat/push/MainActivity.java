package com.why.whychat.push;

import android.widget.TextView;

import com.why.whychat.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity {
    @BindView(R.id.txt_test)
    TextView mTsetText;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTsetText.setText("Test Hello.");
    }
}
