package com.thedeveloperworldisyours.avoidmultiplebuttonclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by javierg on 09/03/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private final Context context;
    private final String[] values;
    private View.OnClickListener onClickListener;

    static class ViewHolder {
        Button buttonRigth;
        Button buttonLeft;
    }

    public ListViewAdapter(Context context, String[] values, View.OnClickListener onClickListener) {
        this.context = context;
        this.values = values;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if(rowView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.row_main, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.buttonRigth = (Button) rowView.findViewById(R.id.row_main_right_button);
            viewHolder.buttonLeft = (Button) rowView.findViewById(R.id.row_main_left_button);

            viewHolder.buttonRigth.setOnClickListener(onClickListener);
            viewHolder.buttonLeft.setOnClickListener(onClickListener);

            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.buttonLeft.setText(values[position]);
        holder.buttonRigth.setText(values[position]);

        holder.buttonLeft.setTag(values[position]);
        holder.buttonRigth.setTag(values[position]);


        return rowView;
    }
}
