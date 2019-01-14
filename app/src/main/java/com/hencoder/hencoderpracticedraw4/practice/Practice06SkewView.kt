package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice06SkewView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    private val point1 = Point(200, 200)
    private val point2 = Point(600, 200)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.skew(0f, 0.5f)
        canvas.translate(0f, -100f)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        canvas.skew(-0.5f, 0f)
        canvas.translate(200f, 0f)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
