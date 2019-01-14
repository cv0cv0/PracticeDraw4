package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice03TranslateView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private val point1 = PointF(200f, 200f)
    private val point2 = PointF(600f, 200f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.translate(-100f, -100f)
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(100f, 100f)
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint)
        canvas.restore()
    }
}