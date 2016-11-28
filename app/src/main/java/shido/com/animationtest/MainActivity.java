package shido.com.animationtest;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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


    //Elementos responsaveis pelo SharedElementTransition, o texto e a estrela serão passados como parametros no pairs
    @BindView(R.id.txtSharedElement)
    TextView txtSharedElement;

    @BindView(R.id.imgStarSharedElement)
    ImageView starView;

    @BindView(R.id.layout_shared_element)
    LinearLayout layoutSharedElement;

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


        //Layout que ao ser clicado será chamada a SharedTransitionActivity
        layoutSharedElement.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        ActivityOptions options;
        Intent i;
        switch (v.getId()) {
            case R.id.explodeJava:

                options = ActivityOptions.makeSceneTransitionAnimation(this, starView, "star");
                //ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, TransitionActivity.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeJava);
                i.putExtra(Constants.KEY_TITLE, "EXPLODE JAVA");
                i.putExtra(Constants.KEY_NAME, "Exploded By Code");
                startActivity(i, options.toBundle());
                break;
            case R.id.explodeXML:
                options = ActivityOptions.makeSceneTransitionAnimation(this, starView, "star");
                //ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, TransitionActivity.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeXML);
                i.putExtra(Constants.KEY_TITLE, "EXPLODE XML");
                i.putExtra(Constants.KEY_NAME, "Exploded By XML");
                startActivity(i, options.toBundle());
                break;

            case R.id.fadeJava:
                options = ActivityOptions.makeSceneTransitionAnimation(this, starView, "star");
                //ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, TransitionActivity.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeJava);
                i.putExtra(Constants.KEY_TITLE, "Fade Java");
                i.putExtra(Constants.KEY_NAME, "Fade By code");
                startActivity(i, options.toBundle());
                break;

            case R.id.fadeXML:
                options = ActivityOptions.makeSceneTransitionAnimation(this, starView, "star");
                //ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, TransitionActivity.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeXML);
                i.putExtra(Constants.KEY_TITLE, "Fade XML");
                i.putExtra(Constants.KEY_NAME, "Fadde By XML");
                startActivity(i, options.toBundle());
                break;
            case R.id.slideJava:
                options = ActivityOptions.makeSceneTransitionAnimation(this, starView, "star");
                //ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, TransitionActivity.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideJava);
                i.putExtra(Constants.KEY_TITLE, "SLIDE JAVA");
                i.putExtra(Constants.KEY_NAME, "SLIDE BY CODE");
                startActivity(i, options.toBundle());
                break;
            case R.id.slideXML:
                options = ActivityOptions.makeSceneTransitionAnimation(this, starView, "star");
                //ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, TransitionActivity.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideXML);
                i.putExtra(Constants.KEY_TITLE, "SLIDE XML");
                i.putExtra(Constants.KEY_NAME, "SLIDE BY XML");
                startActivity(i, options.toBundle());
                break;


            case R.id.layout_shared_element:
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(starView, "star");
                pairs[1] = new Pair<View, String>(txtSharedElement, "text_shared");
                //Precisa usar a ActivityOptionsCompat para passar os Pairs dessa maneira
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
                i = new Intent(MainActivity.this, SharedTransitionActivity.class);
                startActivity(i, optionsCompat.toBundle());

                break;
        }







    }

}
