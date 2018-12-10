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

        var title: String? = null
        var layoutContent = -1
        context.theme.obtainStyledAttributes(attrs, R.styleable.TitledLayout, 0, 0)
            .apply {
                try {
                    //prioritizing string resource over hardcoded title
                    title = getResourceId(R.styleable.TitledLayout_titleRes, -1)
                                .takeIf { it != -1 }
                                ?.let { getString(it) }
                            ?: getString(R.styleable.TitledLayout_title)
                    layoutContent = getResourceId(R.styleable.TitledLayout_layout_content, R.layout.title_layout_default_content)
                } finally {
                    recycle()
                }
            }
        with(borderLayout) {
            findViewById<TextView>(R.id.titled_layout_text_title).text =
                    title
            findViewById<ViewStub>(R.id.titled_layout_stub).apply {
                layoutResource = layoutContent
            }.inflate()
            Unit
        }
    }

}