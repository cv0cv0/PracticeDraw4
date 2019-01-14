package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw4.R

class Practice02ClipPathView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    private val point1 = PointF(200f, 200f)
    private val point2 = PointF(600f, 200f)

    private val path1 = Path().apply {
        addCircle(point1.x + 200, point1.y + 200, 150f, Path.Direction.CW)
    }
    private val path2 = Path().apply {
        fillType = Path.FillType.INVERSE_WINDING
        addCircle(point2.x + 200, point2.y + 200, 150f, Path.Direction.CW)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint)
        canvas.restore()

        canvas.save()
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint)
        canvas.restore()
    }
}
