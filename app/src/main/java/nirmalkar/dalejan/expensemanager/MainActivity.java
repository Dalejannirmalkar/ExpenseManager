package nirmalkar.dalejan.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button newexpe, showlist,byday,bymonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newexpe = (Button) findViewById(R.id.newexpe);
        showlist = (Button) findViewById(R.id.showlist);
        byday = (Button) findViewById(R.id.byday);
        bymonth = (Button) findViewById(R.id.bymonth);

        newexpe.setOnClickListener(this);
        showlist.setOnClickListener(this);
        byday.setOnClickListener(this);
        bymonth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.newexpe:
                startActivity(new Intent(MainActivity.this, Newexpense.class));
                break;

            case R.id.showlist:
                Intent i1=new Intent(MainActivity.this, ShowList.class);
                i1.putExtra("all","1");
                startActivity(i1);
                break;
                case R.id.byday:
                Intent i2=new Intent(MainActivity.this, ShowList.class);
                i2.putExtra("all","2");
                startActivity(i2);
                break;
                case R.id.bymonth:
                Intent i3=new Intent(MainActivity.this, ShowList.class);
                i3.putExtra("all","3");
                startActivity(i3);
                break;
        }
    }
}
