package com.mingchu.positiondetaidemo.spannablestream.interfacer;

import android.view.View;

public interface IClickable {
    interface TextSetting<T> {
        T setClickText(CharSequence clickText);

        T setClickText(CharSequence clickText, int start, int end);
    }

    /**
     * There is a child class SimpleSpannableClickListener.class.
     * You can use it to simplify the code.
     */
    interface OnSpannableClickListener {

        void onSpannableItemClick(View widget, CharSequence str);

        void onPressedStateChanged(boolean isPressed);
    }
}
