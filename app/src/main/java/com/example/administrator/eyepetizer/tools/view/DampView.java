package com.example.administrator.eyepetizer.tools.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Scroller;

/**
 * Created by Administrator on 2017/3/6.
 */

public class DampView extends ScrollView {
    private static final int LEN = 0xc8;
    private static final int DURATION = 500;
    private static final int MAX_DY = 200;

    float startX,startY,currentX,currentY;
    private int left,top;
    private int imageViewH;
    private int rootW,rootH;
    private boolean scrollerType;

    private Scroller mScroller;
    private ImageView imageView;
    private TouchTool tool;


    public DampView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DampView(Context context) {
        super(context);
        mScroller = new Scroller(context);
    }

    public DampView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {

        return 0;
    }


    private int[] li = new int[2];
    private int[] li2 = new int[2];
    private float lastLy;
    private boolean startIsTop = true;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);

        int action = ev.getAction();
        if (!mScroller.isFinished()){
            return super.onTouchEvent(ev);
        }

        currentX = ev.getX();
        currentY = ev.getY();

        imageView.getLocationInWindow(li);
        getLocationOnScreen(li2);
        imageView.getTop();

        switch (action){

            case MotionEvent.ACTION_DOWN:
            if (li[1] != li2[1]){//判断开始触摸屏幕时，imageView和窗口顶部对齐没有
                startIsTop = false;
            }
                left = imageView.getLeft();
                top = imageView.getBottom();
                rootW = getWidth();
                rootH = getHeight();

                imageViewH = imageView.getHeight();

                startX = currentX;
                startY = currentY;

                tool = new TouchTool(imageView.getLeft(),imageView.getBottom(),imageView.getLeft(),imageView.getBottom() + LEN);

                break;

            case MotionEvent.ACTION_MOVE:
                if (imageView.isShown() && imageView.getTop() >= 0){
                    if (tool != null){
                        int t = tool.getScrollY(currentY - startY);

                            if (!scrollerType && currentY < lastLy && imageView.getHeight() > imageViewH){

                                scrollTo(0,0);
                                imageView.getLocationInWindow(li);
                                getLocationOnScreen(li2);
                                android.view.ViewGroup.LayoutParams params = imageView.getLayoutParams();

                                params.height = t;
                                imageView.setLayoutParams(params);

                                if (imageView.getHeight() == imageViewH && li[1] == li2[1]){
                                    scrollerType = true;
                                }

                                if (startIsTop && li[1] != li2[1]){
                                    startIsTop = false;
                                }
                            }
                        if (t >= top && t <= imageView.getBottom() + LEN && li[1] == li2[1] && currentY > lastLy){
                            android.view.ViewGroup.LayoutParams params = imageView.getLayoutParams();
                            params.height = t;
                            imageView.setLayoutParams(params);
                        }
                    }
                    scrollerType = false;
                }

                lastLy = currentY;
                break;

            case MotionEvent.ACTION_UP:

                if (li[1] == li2[1]){
                    scrollerType = true;
                    mScroller.startScroll(imageView.getLeft(),imageView.getBottom(),0 - imageView.getLeft(),imageViewH - imageView.getBottom(),DURATION);
                    invalidate();
                }
                startIsTop = true;
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (mScroller.computeScrollOffset()){
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();

            imageView.layout(0,0,x + imageView.getWidth(),y);
            invalidate();
            if (!mScroller.isFinished() && scrollerType && y > MAX_DY){
                android.view.ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height = y;
                imageView.setLayoutParams(params);
            }
        }
    }

    public class TouchTool{

        private int startX,startY;

        public TouchTool(int startX, int startY,int endX,int endY) {
            this.startX = startX;
            this.startY = startY;
        }

      public int getScrollX(float dx){

          int xx = (int) (startX + dx / 2.5F);
          return xx;
      }

        public int getScrollY(float dy){

            int yy = (int) (startY + dy / 2.5F);
            return yy;
        }
    }

}
