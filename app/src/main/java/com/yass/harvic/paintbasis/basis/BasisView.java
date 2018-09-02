package com.yass.harvic.paintbasis.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 画笔,画布   最基础的自定义控件
 * Created by wxyass on 2018/8/31.
 */

public class BasisView extends View {
    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 1.1.1 概述
        //        Paint paint = new Paint();
        //        paint.setColor(Color.RED);              // 设置画笔颜色
        //        paint.setStyle(Paint.Style.STROKE);     // 设置填充样式: 仅描边
        //        paint.setAntiAlias(true);               // 打开抗锯齿,是图像边缘更平滑
        //        paint.setStrokeWidth(50);               // 设置画笔宽度
        //        canvas.drawCircle(190, 200, 150, paint);   // 画画,半径150


        //1.1.2.1 setColor
        //        Paint paint = new Paint();
        //        paint.setColor(0xFFFF0000);          // 设置画笔颜色,不透明的红色
        //        paint.setStyle(Paint.Style.FILL);    // 设置填充样式: 仅填充内部
        //        paint.setAntiAlias(true);            // 打开抗锯齿,是图像边缘更平滑
        //        paint.setStrokeWidth(50);            // 设置画笔宽度
        //
        //        canvas.drawCircle(190, 200, 150, paint);// 画画,半径150
        //
        //        paint.setColor(0x7EFFFF00);          // 设置画笔新颜色,半透明的黄色
        //        canvas.drawCircle(190, 200, 100, paint);// 画画,半径100


        //1.1.3.1 画布背景设置
        //        canvas.drawRGB(255, 0, 255);


        //1.1.3.2 画直线
        //        Paint paint = new Paint();
        //        paint.setColor(Color.RED);  //设置画笔颜色
        //        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //        paint.setStrokeWidth(5);//设置画笔宽度
        //
        //        canvas.drawLine(100, 100, 200, 200, paint);


        //多条直线
        //        Paint paint = new Paint();
        //        paint.setColor(Color.RED);
        //        paint.setStrokeWidth(5);
        //
        //        float[] pts = {10, 10, 100, 100, 200, 200, 400, 400};
        //        canvas.drawLines(pts, paint);
        //        canvas.drawLines(pts, 2, 4, paint);


        //画点
        //        Paint paint = new Paint();
        //        paint.setColor(Color.RED);
        //        paint.setStrokeWidth(15);
        //        canvas.drawPoint(100, 100, paint);


        //多点
        //        Paint paint = new Paint();
        //        paint.setColor(Color.RED);
        //        paint.setStrokeWidth(25);
        //
        //        float[] pts = {10, 10, 100, 100, 200, 200, 400, 400};
        //        canvas.drawPoints(pts, 2, 4, paint);


        //矩形
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(15);

                //直接构造
                canvas.drawRect(10, 10, 100, 100, paint);

                //使用RectF构造
                paint.setStyle(Paint.Style.FILL);
                RectF rect = new RectF(210f, 10f, 300f, 100f);
                canvas.drawRect(rect, paint);


        //圆角矩形
        //        Paint paint=new Paint();
        //        paint.setColor(Color.RED);
        //        paint.setStyle(Paint.Style.FILL);
        //        paint.setStrokeWidth(15);
        //
        //        RectF rect = new RectF(100, 10, 300, 100);
        //        canvas.drawRoundRect(rect, 20, 10, paint);


        //圆
        //        Paint paint=new Paint();
        //        paint.setColor(Color.RED);
        //        paint.setStyle(Paint.Style.STROKE);
        //        paint.setStrokeWidth(15);
        //
        //        canvas.drawCircle(150, 150, 100, paint);

        //画椭圆
        //        Paint paint = new Paint();
        //        paint.setColor(Color.RED);
        //        paint.setStyle(Paint.Style.STROKE);
        //        paint.setStrokeWidth(5);
        //
        //        RectF rect = new RectF(100, 10, 300, 100);
        //        canvas.drawRect(rect, paint);
        //
        //        paint.setColor(Color.GREEN);//更改画笔颜色
        //        canvas.drawOval(rect, paint);//同一个矩形画椭圆


        //画弧
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setStrokeWidth(5);
//
//        RectF rect1 = new RectF(10, 10, 100, 100);
//        canvas.drawArc(rect1, 0, 90, true, paint);
//
//        RectF rect2 = new RectF(110, 10, 200, 100);
//        canvas.drawArc(rect2, 0, 90, false, paint);
    }
}
/**
 * 画笔抗锯齿
 * paint.setAntiAlias(true)
 * <p>
 * 画笔填充样式
 * paint.setStyle(Paint.Style.STROKE)
 * Paint.Style.STROKE              仅描边
 * Paint.Style.FILL                仅填充内部
 * Paint.Style.FILL_AND_STROKE     填充内部和描边
 * FILL_AND_STROKE是FILL和STROKE叠加在一起显示的效果,FILL_AND_STROKE比FILL多了一个描边的宽度
 * <p>
 * 画笔描边宽度值
 * paint.setStrokeWidth(50)
 * 单位是px,当画笔的Style样式是FILL和FILL_AND_STROKE时有效
 * <p>
 * <p>
 * 画布背景
 * canvas.drawColor(0xFFFF00FF)
 * canvas.drawARGB(0xFF,0xFF,0,0xFF)
 * canvas.drawRGB(255,0,255)
 * canvas.drawRGB(0xFF,0x00,0xFF)
 * <p>
 * 画直线
 * canvas.drawLine(100,100,200,200,paint);
 * (起始点x坐标,起始点y坐标,终点x坐标,终点y坐标,画笔)
 * 直线粗细与setStrokeWidth有关系,
 * 通常,paint.setStrokeWidth在Style起作用时,用于设置描边宽度,在Style不起作用时,用于设置画笔宽度
 * <p>
 * 画点
 * canvas.drawPoint(100,100,paint);
 * (点的x坐标,点的y坐标,画笔)
 * 点的大小只与paint.setStrokeWidth有关,位于paint.setStyle无关
 * <p>
 * 矩形工具类RectF(不常用,保存float类型矩形结构),Rect(常用,保存int类型矩形结构)
 * // 构造一个矩形结构①
 * Rect rect = new Rect(10,10,100,100);
 * // 构造一个矩形结构②
 * Rect rect = new Rect();
 * rect.set(10,10,100,100);
 * <p>
 * 绘制矩形
 * // 直接构造,并且填充为描边类型
 * paint.setStyle(Paint.Style.STROKE);
 * canvas.drawRect(10,10,100,100,paint);
 * // 使用RectF构造,并且仅填充内容
 * paint.setStyle(Paint.Style.FILL);
 * RectF rect = new RectF(210f,10f,300f,100f);
 * canvas.darwRect(rect,paint);
 * <p>
 * Color
 * Color.RED
 * <p>
 * 注意:
 * 在onDraw()函数中不能创建变量!一般在自定义控件的构造函数中创建变量,即在初始化时一次性创建.
 * 因为当控件需要重绘时,就会调用onDraw()函数,其中的变量会一直重复创建,引起频繁GC,进而卡顿.
 * 上面之所以在onDraw中创建Paint对象,因为可以提高代码可读性,这是不被允许的
 */
