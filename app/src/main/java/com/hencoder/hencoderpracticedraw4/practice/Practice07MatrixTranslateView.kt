package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw4.R

class Practice07MatrixTranslateView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    private val point1 = Point(200, 200)
    private val point2 = Point(600, 200)

    private val matrix1 = Matrix()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        matrix1.reset()
        matrix1.postTranslate(-100f, -100f)
        canvas.matrix = matrix1
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)

        matrix1.reset()
        matrix1.postTranslate(100f, 100f)
        canvas.matrix = matrix1
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
    }
}
