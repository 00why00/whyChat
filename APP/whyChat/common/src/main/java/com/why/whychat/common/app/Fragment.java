package com.why.whychat.common.app;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author why
 */
public abstract class Fragment extends androidx.fragment.app.Fragment {
    protected View mRoot;
    protected Unbinder mRootUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 初始化参数
        initArgs(getArguments());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRoot == null) {
            int layId = getContentLayoutId();
            // 初始化当前的根布局，但是不在创建时就添加到container里面
            View root = inflater.inflate(layId, container, false);
            initWidget(root);
            mRoot = root;
        }else {
            if(mRoot.getParent() != null){
                // 把当前Root从其父控件中移除
                ((ViewGroup)mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 把View创建完成后初始化
        initData();
    }


    /**
     * 初始化相关参数
     * @param bundle 参数Bundle
     */
    protected void initArgs(Bundle bundle) {

    }

    /**
     * 得到当前界面的资源文件Id
     * @return 资源文件Id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化控件
     */
    protected void initWidget(View root) {
        mRootUnbinder = ButterKnife.bind(this,root);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     * @return 已处理返回逻辑返回True，Activity不用自己Finish
     *         未处理返回逻辑返回False，
     */
    public boolean onBackPressed() {
        return false;
    }

}
