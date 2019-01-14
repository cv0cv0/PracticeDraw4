package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw4.R

class Practice08MatrixScaleView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    private val point1 = PointF(200f, 200f)
    private val point2 = PointF(600f, 200f)

    private val matrix1 = Matrix()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        matrix1.reset()
        matrix1.postScale(1.2f, 1.2f, point1.x + bitmap.width / 2, point1.y + bitmap.height / 2)
        canvas.matrix = matrix1
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint)

        matrix1.reset()
        matrix1.postScale(0.6f, 1.5f, point2.x + bitmap.width / 2, point2.y + bitmap.height / 2)
        canvas.matrix = matrix1
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint)
    }
}
