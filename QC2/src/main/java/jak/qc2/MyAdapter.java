package jak.qc2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {


    private static final int COUNT = 50;
    private int prevPosition;
    private boolean animate;

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listview_item, viewGroup, false);
        animatePostHc(position, rowView);

        ((TextView) rowView.findViewById(R.id.tvListItem)).setText("This is sample text " + position);

        return rowView;
    }

    private void animatePostHc(int position, View rowView) {
        if (animate) {
            TranslateAnimation translateAnim = new TranslateAnimation(100, 0, 100, 0);
            translateAnim.setDuration(500);
            translateAnim.setFillBefore(true);

            TranslateAnimation translateAnim2 = new TranslateAnimation(-100, 0, -100, 0);
            translateAnim2.setDuration(500);
            translateAnim2.setFillBefore(true);

            if (prevPosition < position) {
                rowView.startAnimation(translateAnim);
            } else {
                rowView.startAnimation(translateAnim2);
            }
            prevPosition = position;
        } else {
            rowView.clearAnimation();
        }

    }


    public void setAnimate(boolean animate) {
        this.animate = animate;
    }
}
