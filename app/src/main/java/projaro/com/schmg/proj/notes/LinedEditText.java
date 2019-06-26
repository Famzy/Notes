package projaro.com.schmg.proj.notes;

/* TODO: 26/06/2019
 * This is class is meant to handle the creation of lines on the edit Text
 * @Author Eric Lekwa
 * lekwaeric@yahoo.com
  *
  * */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class LinedEditText  extends android.support.v7.widget.AppCompatEditText{

    private Rect mRect;
    private Paint mPaint;



    // A construtor with at least one Attribute set has to be defined.
    public LinedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        //this.mRect = mRect;
        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(0xFFFFD966);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Get the height of the activity
        int height = ((View)this.getParent()).getHeight();

        int lineHeight = getLineHeight();
        // to determine the number of lines to be displayed we need to first of all divide the total
        // number of line by the height of the activity.
        int numberOfLines = height / lineHeight;


        // Really dont understand this part of the code.
        Rect r = mRect;
        Paint paint = mPaint;

        int baseline = getLineBounds(0, r);

        for(int i = 0; i < numberOfLines; i++){

            canvas.drawLine(r.left,baseline + 1, r.right, baseline + 1, paint);

            baseline += lineHeight;

        }
        
        super.onDraw(canvas);
    }
}
