package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice01ClipRectView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val left = (width - bitmap.width) / 2f
        val top = (height - bitmap.height) / 2f
        canvas.save()
        canvas.clipRect(left + 50, top + 50, left + 300, top + 200)
        canvas.drawBitmap(bitmap, left, top, paint)
        canvas.restore()
    }
}
