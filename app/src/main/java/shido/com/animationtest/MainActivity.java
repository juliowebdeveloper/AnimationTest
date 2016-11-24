package shido.com.animationtest;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.txvRippleWithBorder)
    TextView txvRippleWithBorder;
    @BindView(R.id.txvRippleWithoutBorder)
    TextView txvRippleWithoutBorder;
    @BindView(R.id.txvCustomRippleWithBorder)
    TextView txvCustomRippleWithBorder;
    @BindView(R.id.txvCustomRippleWithpoutBorder)
    TextView txvCustomRippleWithoutBorder;


    @BindView(R.id.explodeJava)
    Button btExplodeJava;
    @BindView(R.id.explodeXML)
    Button btExplodeXml;
    @BindView(R.id.slideJava)
    Button btSlideJava;
    @BindView(R.id.slideXML)
    Button btSlideXml;
    @BindView(R.id.fadeJava)
    Button btFadeJava;
    @BindView(R.id.fadeXML)
    Button btFadeXml;

    @BindView(R.id.imgStarSharedElement)
    ImageView starView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bindControl();


    }


    private void bindControl(){
        txvCustomRippleWithBorder.setOnClickListener(this);
        txvCustomRippleWithoutBorder.setOnClickListener(this);
        txvRippleWithBorder.setOnClickListener(this);
        txvRippleWithoutBorder.setOnClickListener(this);
        btExplodeJava.setOnClickListener(this);
        btExplodeXml.setOnClickListener(this);
        btFadeJava.setOnClickListener(this);
        btFadeXml.setOnClickListener(this);
        btSlideJava.setOnClickListener(this);
        btSlideXml.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        switch (v.getId()){
            case  R.id.explodeJava:

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, starView,"star" );
                //ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                Intent i = new Intent(MainActivity.this,  TransitionActivity.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeJava );
                i.putExtra(Constants.KEY_TITLE, "EXPLODE JAVA");
                i.putExtra(Constants.KEY_NAME, "Exploded By Code"  );
                startActivity(i, options.toBundle());
                break;
            case  R.id.explodeXML:

                break;

            case R.id.fadeJava:

                break;

            case R.id.fadeXML:
                break;
            case R.id.slideJava:
                break;
            case R.id.slideXML:
                break;
        }


    }

}
