package com.crskdev.lib.titledlayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.FrameLayout
import android.widget.TextView

/**
 * Created by Cristian Pela on 05.12.2018.
 */
class TitledLayout : FrameLayout {
    // @formatter:off
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { // @formatter:on
        val borderLayout = LayoutInflater.from(context).inflate(R.layout.titled_layout, null, false)
        addView(borderLayout)

        var title = ""
        var layoutContent = -1
        context.theme.obtainStyledAttributes(attrs, R.styleable.TitledLayout, 0, 0)
            .apply {
                try {
                    title = getString(R.styleable.TitledLayout_title) ?: ""
                    layoutContent = getResourceId(R.styleable.TitledLayout_layout_content, -1)
                } finally {
                    recycle()
                }
            }
        borderLayout.findViewById<TextView>(R.id.titled_layout_text_title).text = title
        borderLayout.findViewById<ViewStub>(R.id.titled_layout_stub).apply {
            layoutResource = layoutContent
        }.inflate()
    }

}