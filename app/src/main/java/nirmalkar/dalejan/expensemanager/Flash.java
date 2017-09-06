package nirmalkar.dalejan.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Flash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
        Animation a1 = AnimationUtils.loadAnimation(Flash.this, R.anim.fadeout);
        iv1.startAnimation(a1);
        Timer t1 = new Timer();
        TimerTask tt = new TimerTask() {
            public void run() {
                Intent i1 = new Intent(Flash.this, MainActivity.class);
                startActivity(i1);
                Flash.this.finish();
            }
        };
        t1.schedule(tt, 1800);
    }
}
