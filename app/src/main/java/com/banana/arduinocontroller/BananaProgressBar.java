package com.banana.arduinocontroller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class BananaProgressBar extends FrameLayout {
    ImageButton imageButton;
    public BananaProgressBar(@NonNull Context context) {
        super(context);
        initilize();
    }

    public BananaProgressBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initilize();
    }

    public BananaProgressBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initilize();
    }

    public BananaProgressBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initilize();
    }
    private void initilize() {
        View view = inflate(getContext(), R.layout.layout_banana_progressbar, null);
        addView(view);

        imageButton = findViewById(R.id.imageButton);
        animation();
    }
        private void animation(){
            imageButton
                    .animate()
                    .setDuration(500)
                    .alpha(1)
                    .scaleX(50)
                    .scaleY(50)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() { ;
                            imageButton.setScaleX(10);
                            imageButton.setScaleY(10);
                            animation();
                        }
                    }).start();
        }


    }

