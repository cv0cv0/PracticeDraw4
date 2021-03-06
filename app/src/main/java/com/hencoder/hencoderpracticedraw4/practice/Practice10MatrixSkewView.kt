package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw4.R

class Practice10MatrixSkewView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    private val point1 = PointF(200f, 200f)
    private val point2 = PointF(600f, 200f)

    private val matrix1 = Matrix()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        matrix1.reset()
        matrix1.postSkew(0f, 0.5f, point1.x + bitmap.width / 2, point2.y + bitmap.height / 2)
        canvas.matrix = matrix1
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint)

        matrix1.reset()
        matrix1.postSkew(-0.5f, 0f, point2.x + bitmap.width / 2, point2.y + bitmap.height / 2)
        canvas.matrix = matrix1
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint)
    }
}
