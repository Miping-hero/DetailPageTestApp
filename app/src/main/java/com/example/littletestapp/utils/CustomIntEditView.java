package com.example.littletestapp.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.littletestapp.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mip
 * Describe: 自定义费率小数点增加减
 */

public class CustomIntEditView extends FrameLayout implements View.OnClickListener, TextWatcher {

    private LinearLayout up;
    private LinearLayout down;
    private int mCurrentNumber;
    private EditText editText;

    private int mMaxValue;
    private int mMinValue;
    private int mAddOrMinusValue;
    private int mDefaultValue;
    private int mPreValue;
    private boolean mCeilingValue_int;
    private Handler handler = new Handler();

    private boolean mCeilingValue; // 封顶值
    private boolean mflag_value;

    public CustomIntEditView(Context context) {
        this(context, null);
    }

    public CustomIntEditView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomIntEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.edit_text_adds, this);
        TypedArray arrayAttrs = getContext().obtainStyledAttributes(attrs, R.styleable.CustomIntEditView);
        mMaxValue = arrayAttrs.getInt(R.styleable.CustomIntEditView_maxValues, 99);
        mMinValue = arrayAttrs.getInt(R.styleable.CustomIntEditView_minValues, 0);
        mAddOrMinusValue = arrayAttrs.getInt(R.styleable.CustomIntEditView_addOrMinusValues, 1);
        mDefaultValue = arrayAttrs.getInt(R.styleable.CustomIntEditView_default_values, 0);
        mCeilingValue_int = arrayAttrs.getBoolean(R.styleable.CustomIntEditView_ceilingValue_int, false);
        arrayAttrs.recycle();
        initView();
    }

    private void initView() {
        up = (LinearLayout) findViewById(R.id.calendar_up);
        down = (LinearLayout) findViewById(R.id.calendar_down);
        editText = (EditText) findViewById(R.id.edit_ets);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
        editText.addTextChangedListener(this);

        if (editText != null) editText.setText(String.valueOf(mDefaultValue));
        mPreValue = mDefaultValue;
        setSelection(editText);
        setEditTextInhibitInputSpeChat(editText);
    }

    protected void setSelection(EditText selection) {
        if (!(selection.getText().equals(""))) {
            selection.setSelection(selection.getText().length());
        }
    }

    /**
     * 设置数据
     */
    public void setEditData(String number) {
        if (editText != null) editText.setText(number);
    }

    /**
     * 设置最大值
     */
    public void setmMaxValue(int maxValue) {
        mMaxValue = maxValue;
    }

    /**
     * 设置最大值
     */
    public void setmMinValue(int minValue) {
        mMinValue = minValue;
    }

    /**
     * 得到edittext值
     */
    public String getEditData() {
        if (editText != null) return editText.getText().toString();
        return "";
    }

    /**
     * 数据加减
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calendar_up:
                if (mMaxValue <= mCurrentNumber) {
//                    MyApplication.getmAppComponent().getToastUtils().showToast("不能高于：" + String.valueOf(mMaxValue));
                    mPreValue = mCurrentNumber;
                    return;
                }

                mCurrentNumber = mCurrentNumber + mAddOrMinusValue;
                editText.setText(String.valueOf(mCurrentNumber));
                break;
            case R.id.calendar_down:

                if (mMinValue >= mCurrentNumber) {
//                    MyApplication.getmAppComponent().getToastUtils().showToast("不能低于：" + String.valueOf(mMinValue));
                    mPreValue = mCurrentNumber;
                    return;
                }

                mCurrentNumber = mCurrentNumber - mAddOrMinusValue;
                editText.setText(String.valueOf(mCurrentNumber));
                break;
        }
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int i1, int i2) {
        setSelection(editText);
        if (start > 6) {
            String ss = editText.getText().toString().trim();
            editText.setText(ss.substring(0, 7));
            return;
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (delayRun != null) {
            //每次editText有变化的时候，则移除上次发出的延迟线程
            handler.removeCallbacks(delayRun);
        }
//                editString = s.toString();

        //延迟800ms，如果不再输入字符，则执行该线程的run方法
        if (!TextUtils.isEmpty(editText.getText())) {
            if (isNumericzidai(editText.getText().toString())) {
                handler.postDelayed(delayRun, 800);
            }
        }
    }

    /**
     * 延迟线程，看是否还有下一个字符输入
     */
    private Runnable delayRun = new Runnable() {
        @Override
        public void run() {
            if (isNumericzidai(editText.getText().toString())) {
                mCurrentNumber = Integer.parseInt(editText.getText().toString().trim());
                String s = String.valueOf(editText.getText().toString().trim());
                //在正常范围内  首字符不可以为0
                if (s.length() > 1) {
                    Log.d("yyb", "触发了f" + s.length());
                    if (s.charAt(0) == '0') {
                        StringBuilder builder = new StringBuilder(s);
                        String numb = builder.deleteCharAt(0).toString();
                        Log.d("yybd", "触发了charAt" + builder.deleteCharAt(0).toString());
                        editText.setText(numb);
                    }
                }

                if (mCeilingValue_int && mCurrentNumber == 0) {
//                    MyApplication.getmAppComponent().getToastUtils().showToast("设为不封顶");
                } else {
                    if (mCurrentNumber < mMinValue) {
                        editText.setText(String.valueOf(mMinValue));
//                        MyApplication.getmAppComponent().getToastUtils().showToast("不能低于：" + String.valueOf(mMinValue));
                    }
                    if (mCurrentNumber > mMaxValue) {
                        editText.setText(String.valueOf(mMaxValue));
//                        MyApplication.getmAppComponent().getToastUtils().showToast("不能高于：" + String.valueOf(mMaxValue));
                    }
                }
            }
            if (mCallCack != null) {
                if (editText.getText().toString().trim().contains("0"))
                    mCallCack.sendEvent(true);
                else
                    mCallCack.sendEvent(false);
            }
            if (editText.getText().toString().equals("")) {
                mCurrentNumber = 0;
                editText.setText("0");
            }
        }
    };

    /**
     * 禁止EditText输入特殊字符
     *
     * @param editText
     */
    public static void setEditTextInhibitInputSpeChat(EditText editText) {

        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                String speChat = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？ ]";
                Pattern pattern = Pattern.compile(speChat);
                Matcher matcher = pattern.matcher(source.toString());
                if (matcher.find()) return "";
                else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }


    /**
     * 判断是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumericzidai(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    /**
     * 设置颜色
     */
    public void setTextColor(boolean textColor) {
        editText.setTextColor(textColor ? getResources().getColor(R.color.text_black)
                : getResources().getColor(R.color.gray_A3A3A3));
    }

    private ICallCack mCallCack = null;

    public void setICallCack(ICallCack callCack) {
        mCallCack = callCack;
    }

    public interface ICallCack {
        void sendEvent(boolean isZero);
    }

}
