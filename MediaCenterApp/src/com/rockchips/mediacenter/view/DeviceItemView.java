package com.rockchips.mediacenter.view;

import momo.cn.edu.fjnu.androidutils.data.CommonValues;
import momo.cn.edu.fjnu.androidutils.utils.DeviceInfoUtils;
import momo.cn.edu.fjnu.androidutils.utils.SizeUtils;
import momo.cn.edu.fjnu.androidutils.utils.ToastUtils;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.rockchips.mediacenter.R;
import com.rockchips.mediacenter.bean.DeviceItem;
import com.rockchips.mediacenter.data.ConstData;
import com.rockchips.mediacenter.service.OnDeviceSelectedListener;
import com.rockchips.mediacenter.utils.ImageHelper;

public class DeviceItemView extends View implements OnGestureListener
{
    private static final String TAG = "DeviceItemView";

    private static final int SCREEN_WIDTH = DeviceInfoUtils.getScreenWidth(CommonValues.application);
    
    private Context mContext;

    private static final int COUNTVISIABLE = 4;

    private static final int BITMAP_WIDTH = SizeUtils.dp2px(CommonValues.application, 280);

    private static final int BITMAP_HEIGHT = SizeUtils.dp2px(CommonValues.application, 180);

    private static final int NAMESIZE = 20;
    
    private Bitmap[] mIconReflectedImage = new Bitmap[COUNTVISIABLE];

    private static final float REFLECTRATESIZE = 0.3f;

    private Paint mPaint;

    private Paint mShadowPaint;
    private float mBitmapHeight;

    private int mOffset = 1;

    private boolean mRightKey = false;
    private boolean mLeftKey = false;
    private boolean mBeFristLoading = true;
    /**第一次绘制*/
    private boolean mIsFirstDraw = true;
    private GestureDetector mGestureDetector;
        
    private static final int[] IMAGEIDS =
    {  R.drawable.file_icon, R.drawable.photo_icon, R.drawable.music_icon, R.drawable.video_icon};

    private static final int[] TEXTIDS =
     { R.string.file, R.string.photo, R.string.view_music, R.string.view_video};

    public DeviceItemView(Context context)
    {
        super(context);
        mContext = context;
        initView();
    }

    public DeviceItemView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mContext = context;
        initView();

    }

    public DeviceItemView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mContext = context;
        initView();
    }

    private OnDeviceSelectedListener mOnSelectedListener;

    public void setOnDeviceSelectedListener(OnDeviceSelectedListener l)
    {
        mOnSelectedListener = l;
    }

    private DeviceItem mDeviceItem;

    public void setDeviceItem(DeviceItem deviceItem)
    {
        mDeviceItem = deviceItem;
    }
    
    
    private void initView()
    {
        mGestureDetector = new GestureDetector(mContext, this);
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
    	mPaint.setStrokeWidth(SizeUtils.dp2px(mContext, 4));
    	mPaint.setStyle(Style.STROKE);
        mShadowPaint = new Paint();
        mShadowPaint.setAntiAlias(true);
        mShadowPaint.setFilterBitmap(true);

        // 鍔犺浇鍥剧墖
        loadImages();

        // 鐢熸垚鍥剧墖楂樺害锛氬師鍥鹃珮+鍊掑奖楂�
        mBitmapHeight = BITMAP_HEIGHT * (1 + REFLECTRATESIZE);

    }

    private void loadImages()
    {
        Bitmap srcBitmap = null;

        for (int i = 0, len = IMAGEIDS.length; i < len; i++)
        {
            // 鍔犺浇鍥剧墖
            srcBitmap = ImageHelper.createBitmap(mContext, IMAGEIDS[i], BITMAP_WIDTH, BITMAP_HEIGHT);

            if (srcBitmap != null)
            {
                mIconReflectedImage[i] = ImageHelper.createReflectedImage(srcBitmap, REFLECTRATESIZE);
    
                ImageHelper.addText(mIconReflectedImage[i], mContext.getString(TEXTIDS[i]), NAMESIZE, Color.WHITE, BITMAP_WIDTH / 2, BITMAP_HEIGHT
                        - NAMESIZE);
                srcBitmap.recycle();
                srcBitmap = null;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        mGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
        {
        	mRightKey = false;
        	mLeftKey = true;
            invalidate();
          
        }
        else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
        {
        	mRightKey = true;
        	mLeftKey = false;
        	invalidate();
        }
        else if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
        {
            if (mOnSelectedListener != null)
            {
                mOnSelectedListener.onSelected(mDeviceItem.mObject, mOffset);
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas)
    {
    	Log.i(TAG, "onDraw");
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
        canvas.drawColor(Color.TRANSPARENT);
        if(mBeFristLoading){
        	initDraw(canvas);
        	mBeFristLoading = false;
        }else if(mRightKey && !mLeftKey){
        	leftMove(canvas);
        	mRightKey = false;
        }else if(mLeftKey && !mRightKey){
        	rightMove(canvas);
        	mLeftKey = false;
        }else{
        	rightMove(canvas);
        	leftMove(canvas);
        }
        
    }
    
    private void rightMove(Canvas canvas)
    {
    	int offsetX = (SCREEN_WIDTH - BITMAP_WIDTH * 4) / 2;
    	//mOffset = (4 + mOffset - 1 ) % 4;
    	canvas.save();
    	canvas.translate(offsetX, (getHeight() - mBitmapHeight) / 2);
    	int index = 0;
    	for(int i = (mOffset + 2) % 4; i < mIconReflectedImage.length; ++i){
    		canvas.drawBitmap(mIconReflectedImage[i], index * BITMAP_WIDTH, 0, null);
    		++index;
    	}
    	
    	for(int i = 0; i < (mOffset + 2) % 4; ++i){
    		canvas.drawBitmap(mIconReflectedImage[i], index * BITMAP_WIDTH, 0, null);
    		++index;
    	}
    	
    	canvas.restore();
    	
    	mOffset = (4 + mOffset - 1) % 4;
    	
    	canvas.save();
    	canvas.translate(offsetX + BITMAP_WIDTH, (getHeight() - mBitmapHeight) / 2);
    	canvas.scale(1.2f, 1.2f, BITMAP_WIDTH / 2, BITMAP_HEIGHT / 2);
    	canvas.drawBitmap(mIconReflectedImage[mOffset], 0, 0, null);
    	canvas.drawRect(0, 0, BITMAP_WIDTH, BITMAP_HEIGHT, mPaint);
    	canvas.restore();
    }
    
    private void leftMove(final Canvas canvas)
    {
    	
    	Log.i(TAG, "leftMove");
    	int offsetX = (SCREEN_WIDTH - BITMAP_WIDTH * 4) / 2;
    	canvas.save();
    	canvas.translate(offsetX, (getHeight() - mBitmapHeight) / 2);
    	int index = 0;
    	for(int i = mOffset; i < mIconReflectedImage.length; ++i){
    		canvas.drawBitmap(mIconReflectedImage[i], index * BITMAP_WIDTH, 0, null);
    		++index;
    	}
    	
    	for(int i = 0; i < mOffset; ++i){
    		canvas.drawBitmap(mIconReflectedImage[i], index * BITMAP_WIDTH, 0, null);
    		++index;
    	}
    	
    	canvas.restore();
    	
    	mOffset = (++mOffset) % 4;
    	
    	canvas.save();
    	canvas.translate(offsetX + BITMAP_WIDTH, (getHeight() - mBitmapHeight) / 2);
    	canvas.scale(1.2f, 1.2f, BITMAP_WIDTH / 2, BITMAP_HEIGHT / 2);
    	canvas.drawBitmap(mIconReflectedImage[mOffset], 0, 0, null);
    	canvas.drawRect(0, 0, BITMAP_WIDTH, BITMAP_HEIGHT, mPaint);
    	canvas.restore();
    }

    @Override
    public boolean onDown(MotionEvent arg0)
    {
        return false;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0)
    {
        if (mOnSelectedListener != null)
        {
            mOnSelectedListener.onSelected(mDeviceItem.mObject, mOffset);
        }
        return false;
    }

    @Override
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3)
    {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0)
    {
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3)
    {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0)
    {
    }

    public void recycle()
    {
        recycleReflectedImage();

    }


    private void recycleReflectedImage()
    {
        if (mIconReflectedImage == null || mIconReflectedImage.length == 0)
        {
            return;
        }

        for (int i = 0; i < mIconReflectedImage.length; i++)
        {
            if (mIconReflectedImage[i] != null)
            {
                if (!mIconReflectedImage[i].isRecycled())
                {
                    mIconReflectedImage[i].recycle();
                }
                mIconReflectedImage[i] = null;
            }
        }
    }
    
    
    
 
    public void initDraw(Canvas canvas){
    	int offsetX = (SCREEN_WIDTH - BITMAP_WIDTH * 4) / 2;
    	canvas.save();
    	canvas.translate(offsetX, (getHeight() - mBitmapHeight) / 2);
    	canvas.drawBitmap(mIconReflectedImage[0], 0, 0, null);
    	canvas.drawBitmap(mIconReflectedImage[1], BITMAP_WIDTH, 0, null);
    	canvas.drawBitmap(mIconReflectedImage[2], 2 * BITMAP_WIDTH, 0, null);
    	canvas.drawBitmap(mIconReflectedImage[3], 3 * BITMAP_WIDTH, 0, null);
    	canvas.restore();
    	
    	canvas.save();
    	canvas.translate(offsetX + BITMAP_WIDTH, (getHeight() - mBitmapHeight) / 2);
    	canvas.scale(1.2f, 1.2f, BITMAP_WIDTH / 2, BITMAP_HEIGHT / 2);
    	canvas.drawBitmap(mIconReflectedImage[1], 0 , 0, null);
    	canvas.drawRect(0, 0, BITMAP_WIDTH, BITMAP_HEIGHT, mPaint);
    	canvas.restore();
    	
    	Activity currentActivity = (Activity)mContext;
    	Intent currIntent = currentActivity.getIntent();
    	if(mIsFirstDraw && currIntent != null && ConstData.ActivityAction.INSTALL_APK.equals(currIntent.getAction())){
    		mIsFirstDraw = false;
    		rightMove(canvas);
    		ToastUtils.showToast(mContext.getResources().getString(R.string.apk_install_tip));
    	}
    		
    	
    }
    

    public void initData(){
    	mOffset = 1;
    	mBeFristLoading = true;
    }
    
}
