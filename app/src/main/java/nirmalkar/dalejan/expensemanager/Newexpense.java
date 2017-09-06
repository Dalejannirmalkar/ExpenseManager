package nirmalkar.dalejan.expensemanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Newexpense extends AppCompatActivity implements View.OnClickListener {

    private int year, month, day;

    EditText itmname,itmprice,itmpay,itemdescr;
 TextView itmdate;
Button save,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newexpense);
        itmname= (EditText) findViewById(R.id.itmname);
        itmprice= (EditText) findViewById(R.id.itmpric);
        itmpay= (EditText) findViewById(R.id.paytype);
        itemdescr= (EditText) findViewById(R.id.desc);
        itmdate= (TextView) findViewById(R.id.itmdate);

        save= (Button) findViewById(R.id.save);
        clear= (Button) findViewById(R.id.clear);
        itmdate.setOnClickListener(this);
        clear.setOnClickListener(this);
        save.setOnClickListener(this);
    }
    public void clearall(){
        itmname.setText("");
        itmdate.setText("1/1/1900");
        itemdescr.setText("");
        itmpay.setText("");
        itmprice.setText("");

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.save:
                DatabaseExpense dbe=new DatabaseExpense();
                dbe.setItemname(itmname.getText().toString());
                dbe.setItempric(itmprice.getText().toString());
                dbe.setItemdate(itmdate.getText().toString());
                dbe.setItempay(itmpay.getText().toString());
                dbe.setItemdescrip(itemdescr.getText().toString());
                dbe.setDay(day);
                dbe.setMonth(month);
                DbHandler dbh=new DbHandler(Newexpense.this);
                dbh.addAlarm(dbe);
                Toast.makeText(this, "Save the expenses", Toast.LENGTH_SHORT).show();
                    clearall();
                break;

            case R.id.clear:
                clearall();
                break;

            case R.id.itmdate:
                final Dialog setDate = new Dialog(Newexpense.this);
                setDate.requestWindowFeature(Window.FEATURE_NO_TITLE);
                setDate.setContentView(R.layout.activity_datepicker);
                setDate.show();
                DatePicker date = (DatePicker) setDate.findViewById(R.id.datepicker1);
                date.setMinDate(System.currentTimeMillis() - 1000);
                Calendar calender = Calendar.getInstance();

                DatePicker.OnDateChangedListener onDateChangedListener = new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
                        day = dayOfMonth;
                        year = years;
                        month = monthOfYear;
                        setDate.dismiss();
                        itmdate.setText( day + "/" + (month + 1) + "/" + year);

                    }
                };

                day = calender.get(Calendar.DAY_OF_MONTH);
                month = calender.get(Calendar.MONTH);
                year = calender.get(Calendar.YEAR);

                date.init(year, month, day, onDateChangedListener);


                break;
        }
    }
}
