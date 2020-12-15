package com.example.vrotarrowview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas

val parts : Int = 3
val strokeFactor : Float = 90f
val sizeFactor : Float = 3.9f
val backColor : Int = Color.parseColor("#BDBDBD")
val colors : Array<Int> = arrayOf(
    "#F44336",
    "#673AB7",
    "#2196F3",
    "#8BC34A",
    "#795548"
).map {
    Color.parseColor(it)
}.toTypedArray()
val scGap : Float = 0.02f / parts
val rot : Float = 45f
val arrowFactor : Float = 12.3f
val delay : Long = 20
val deg : Float = 45f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawVRotArrow(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val sc1 : Float = scale.divideScale(0, parts)
    val sc2 : Float = scale.divideScale(1, parts)
    val sc3 : Float = scale.divideScale(2, parts)
    val arrowSize : Float = Math.min(w, h) / arrowFactor
    save()
    translate(w / 2, h / 2)
    for (i in 0..1) {
        save()
        rotate(deg * (1f - 2 * i))
        drawLine(0f, -size * sc2, 0f, -size * sc1, paint)
        for (j in 0..1) {
            save()
            translate(0f, -size)
            rotate(deg * (1f - 2 * j))
            drawLine(0f, 0f, 0f, arrowSize * Math.floor(sc1.toDouble()).toFloat(), paint)
            restore()
        }
        restore()
    }
    restore()
}

fun Canvas.drawVRANode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawVRotArrow(scale, w, h, paint)
}

class VRotArrowView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}