package nirmalkar.dalejan.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ShowList extends AppCompatActivity {
ListView listView;
    DbHandler dbHandler;
    List<DatabaseExpense> databaseAlarms;

    ArrayList<String> itmnam=new ArrayList<String>();
    ArrayList<String> itmpric=new ArrayList<String>();
    ArrayList<String> itmdate=new ArrayList<String>();
    ArrayList<String> itmpay=new ArrayList<String>();
    ArrayList<String> itmdesc=new ArrayList<String>();
    ArrayList<Integer> day=new ArrayList<>();
    ArrayList<Integer> month=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
    listView= (ListView) findViewById(R.id.showdetail);

dbHandler=new DbHandler(ShowList.this);
Intent i1=getIntent();
String get=i1.getStringExtra("all");
if(get.equals("1")){
    databaseAlarms=dbHandler.getAllAlarm();

} else if (get.equals("2")){
    databaseAlarms=dbHandler.getAllAlarmBYdaY();

}else {
    databaseAlarms=dbHandler.getAllAlarmBYmonth();

}
try {
    for (DatabaseExpense expense:databaseAlarms){
        for (int i=0;i<1;i++){
            itmnam.add(expense.getItemname());
            itmpric.add(expense.getItempric());
            itmdate.add(expense.getItemdate());
            itmpay.add(expense.getItempay());
            itmdesc.add(expense.getItemdescrip());
            day.add(expense.getDay());
            month.add(expense.getMonth());
            Log.d("kkkkkk",itmnam.toString());

        }
        }
}catch (Exception e){
    e.printStackTrace();
}

        DatabaseExpense user1[]=new DatabaseExpense[itmnam.size()];
        for (int i=0;i<user1.length;i++){
            user1[i]= new DatabaseExpense(itmnam.get(i),itmpric.get(i),itmdate.get(i),itmpay.get(i),itmdesc.get(i),day.get(i),month.get(i));
            Log.d("kkkkkk",user1[i].toString());
        }
        if (itmnam!=null||user1!=null){


            CustomizedAdapter customizedAdapter=new CustomizedAdapter(ShowList.this,R.layout.customlist,user1);
            listView.setAdapter(customizedAdapter);

        }
        }
}
