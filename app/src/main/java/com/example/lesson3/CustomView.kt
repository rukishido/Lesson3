package com.example.lesson3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.lesson3.databinding.CustomViewBinding

class CustomView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet?,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrSet, defStyleAttr) {

    private val binding: CustomViewBinding

    init {

        binding = CustomViewBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

        context.theme.obtainStyledAttributes(
            attrSet,
            R.styleable.CustomView,
            defStyleAttr,
            0
        ).run {
            try {
                binding.ivTile.setImageDrawable(getDrawable(R.styleable.CustomView_image))
                binding.tvTitle.text = getString(
                    R.styleable.CustomView_android_text
                )
            } finally {
                recycle()
            }
        }
    }


}