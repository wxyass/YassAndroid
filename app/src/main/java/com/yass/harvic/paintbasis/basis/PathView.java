package com.yass.harvic.paintbasis.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 画笔,画布   最基础的自定义控件
 * Created by wxyass on 2018/8/31.
 */

public class PathView extends View {
    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置设置画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);          //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);   //填充样式改为描边
        paint.setStrokeWidth(5);            //设置画笔宽度

        // 直线路径
        //        Path path = new Path();
        //        path.moveTo(10, 10); //设定起始点
        //        path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
        //        path.lineTo(300, 100);//画第二条直线
        //        path.close();//闭环
        //
        //        canvas.drawPath(path, paint);

        // 弧线路径
        //        Path path = new Path();
        //        path.moveTo(10, 10); //设定起始点
        //        RectF rectF = new RectF(100,10,200,100);
        //        path.arcTo(rectF,0,90);
        //        canvas.drawPath(path, paint);

        //矩形路径
        //                //先创建两个大小一样的路径
        //                //第一个逆向生成
        //                Path CCWRectpath = new Path();
        //                RectF rect1 = new RectF(50, 50, 240, 200);
        //                CCWRectpath.addRect(rect1, Path.Direction.CCW);
        //
        //                //第二个顺向生成
        //                Path CWRectpath = new Path();
        //                RectF rect2 = new RectF(290, 50, 480, 200);
        //                CWRectpath.addRect(rect2, Path.Direction.CW);
        //
        //                //先画出这两个路径
        //                canvas.drawPath(CCWRectpath, paint);
        //                canvas.drawPath(CWRectpath, paint);


        //依据路径方向布局文字
        //先创建两个大小一样的路径
        //第一个逆向生成
        Path CCWRectpath = new Path();
        RectF rect1 = new RectF(50, 50, 240, 200);
        CCWRectpath.addRect(rect1, Path.Direction.CCW);

        //第二个顺向生成
        Path CWRectpath = new Path();
        RectF rect2 = new RectF(290, 50, 480, 200);
        CWRectpath.addRect(rect2, Path.Direction.CW);

        //先画出这两个路径
        canvas.drawPath(CCWRectpath, paint);
        canvas.drawPath(CWRectpath, paint);

        //依据路径写出文字
        String text = "苦心人天不负,有志者事竟成";
        paint.setColor(Color.BLACK);
        paint.setTextSize(35);
        canvas.drawTextOnPath(text, CCWRectpath, 0, 18, paint);//逆时针生成
        canvas.drawTextOnPath(text, CWRectpath, 0, 18, paint);//顺时针生成


        //圆角矩形路径
        //        Path path = new Path();
        //        RectF rect1 =  new RectF(50, 50, 240, 200);
        //        path.addRoundRect(rect1, 10, 15 , Path.Direction.CCW);
        //
        //        RectF rect2 =  new RectF(290, 50, 480, 200);
        //        float radii[] ={10,15,20,25,30,35,40,45};
        //        path.addRoundRect(rect2, radii, Path.Direction.CCW);
        //
        //        canvas.drawPath(path, paint);

        //圆形路径
        //        Path path = new Path();
        //        path.addCircle(100, 100, 50, Path.Direction.CCW);
        //        canvas.drawPath(path, paint);


        //椭圆路径
        //        Path path = new Path();
        //        RectF rect = new RectF(10, 10, 200, 100);
        //        path.addOval(rect, Path.Direction.CCW);
        //        canvas.drawPath(path, paint);


        //添加弧线路径
        //        Path path = new Path();
        //        RectF rect = new RectF(10, 10, 100, 50);
        //        path.addArc(rect, 0, 100);
        //
        //        canvas.drawPath(path, paint);


        // 1.2.5 Path重置(注意使用真机,模拟器可能会并没有区别)
        //        Path path = new Path();
        //        path.setFillType(Path.FillType.INVERSE_WINDING);
        //        //path.rewind();
        //        path.reset();
        //        path.addCircle(100, 100, 50, Path.Direction.CW);
        //        canvas.drawPath(path, paint);

    }
}
/**
 * 直线路径
 * path.moveTo(10, 10);// 设置直线的初始坐标
 * path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
 * path.lineTo(300, 100);//画第二条直线
 * path.close();//闭环,路径的终点(300,100)就会自行向路径的起始点(10,10)画一条闭合线
 * canvas.drawPath(path, paint);// drawPath()是在Canvas中绘制路径的api
 * <p>
 * 弧线路径
 * path.arcTo(rectF,0,90);//(生成椭圆的矩形,弧开始的角度以X轴正方向为0°,弧持续的角度)
 */

