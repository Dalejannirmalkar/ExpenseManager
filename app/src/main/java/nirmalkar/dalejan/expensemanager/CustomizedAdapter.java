package nirmalkar.dalejan.expensemanager;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by CG-DTE on 31-03-17.
 */

public class CustomizedAdapter extends ArrayAdapter<DatabaseExpense> {

    Context context;
    int layoutResourceId;
    DatabaseExpense image1[] = null;

    public CustomizedAdapter(Context context, int layoutResourceId, DatabaseExpense[] image) {
        super(context,layoutResourceId,image);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.image1 = image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User1 holder = null;
LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
          convertView=layoutInflater.inflate(layoutResourceId,null);

            holder = new User1();
            holder.name = (TextView) convertView.findViewById(R.id.itmname1);
            holder.pric = (TextView) convertView.findViewById(R.id.itmpric1);
            holder.date = (TextView) convertView.findViewById(R.id.itmdate1);
            holder.pay = (TextView) convertView.findViewById(R.id.itmpay1);
            holder.desc = (TextView) convertView.findViewById(R.id.itmdesc1);

            convertView.setTag(holder);
        }
        else
        {
            holder = (User1) convertView.getTag();
        }
DatabaseExpense hogya=image1[position];
        holder.name.setText(hogya.itemname);
        holder.pric.setText(hogya.itempric);
        holder.date.setText(hogya.itemdate);
        holder.pay.setText(hogya.itempay);
        holder.desc.setText(hogya.itemdescrip);

        return convertView;
    }

    static class User1 {
        TextView name;
        TextView pric;
        TextView date;
        TextView pay;
        TextView desc;

    }
}