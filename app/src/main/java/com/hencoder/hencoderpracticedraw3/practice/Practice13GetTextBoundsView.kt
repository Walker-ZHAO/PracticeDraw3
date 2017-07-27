package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice13GetTextBoundsView : View {
    internal var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text1 = "A"
    internal var text2 = "a"
    internal var text3 = "J"
    internal var text4 = "j"
    internal var text5 = "Â"
    internal var text6 = "â"
    internal var top = 200
    internal var bottom = 400
    val rect = Rect()
    val offsets = IntArray(6)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(50f, top.toFloat(), (width - 50).toFloat(), bottom.toFloat(), paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        paint2.getTextBounds(text1, 0, 1, rect)
        offsets[0] = - (rect.top + rect.bottom) / 2
        paint2.getTextBounds(text2, 0, 1, rect)
        offsets[1] = - (rect.top + rect.bottom) / 2
        paint2.getTextBounds(text3, 0, 1, rect)
        offsets[2] = - (rect.top + rect.bottom) / 2
        paint2.getTextBounds(text4, 0, 1, rect)
        offsets[3] = - (rect.top + rect.bottom) / 2
        paint2.getTextBounds(text5, 0, 1, rect)
        offsets[4] = - (rect.top + rect.bottom) / 2
        paint2.getTextBounds(text6, 0, 1, rect)
        offsets[5] = - (rect.top + rect.bottom) / 2
        val middle = (top + bottom) / 2
        canvas.drawText(text1, 100f, middle.toFloat() + offsets[0], paint2)
        canvas.drawText(text2, 200f, middle.toFloat() + offsets[1], paint2)
        canvas.drawText(text3, 300f, middle.toFloat() + offsets[2], paint2)
        canvas.drawText(text4, 400f, middle.toFloat() + offsets[3], paint2)
        canvas.drawText(text5, 500f, middle.toFloat() + offsets[4], paint2)
        canvas.drawText(text6, 600f, middle.toFloat() + offsets[5], paint2)
    }
}