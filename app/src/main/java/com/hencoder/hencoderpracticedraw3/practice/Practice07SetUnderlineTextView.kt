package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice07SetUnderlineTextView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = 60f

        // 使用 Paint.setUnderlineText() 来设置下划线
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.isUnderlineText = true
        canvas.drawText(text, 50f, 100f, paint)
    }
}
