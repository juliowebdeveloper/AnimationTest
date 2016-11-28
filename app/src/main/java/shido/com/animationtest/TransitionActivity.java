package shido.com.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransitionActivity extends AppCompatActivity {

    Constants.AnimType type;
    String toolBarTitle, animName;
    @BindView(R.id.animName)
    TextView mtxvAnimName;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.exitButton)
    Button exitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Se transition não estiver habilitada no tema, precisa chamar esse trecho de codigo
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_transition);
        //        ButterKnife.bind(this); -> Se usar ActivityOptionsCompat e ter itens nos extras

        type  = (Constants.AnimType) getIntent().getSerializableExtra(Constants.KEY_TYPE);
        toolBarTitle = getIntent().getStringExtra(Constants.KEY_TITLE);
        animName = getIntent().getStringExtra(Constants.KEY_NAME);
        ButterKnife.bind(this); //Se usar ActivityOptions - Em caso de ter itens nos Extras

        setUpAnimation();
        setUpToolbar();
        bindControl();

         //For overlap between MainActivity and Entering TransitionActivity
        getWindow().setAllowEnterTransitionOverlap(false);

    }

    private void bindControl() {
        exitButton.setOnClickListener((v) -> {finishAfterTransition();});

        mtxvAnimName.setText(animName);

    }



    private  void setUpToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(toolBarTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }
    private void setUpAnimation() {
        Transition enterTransition;
        switch (type){
            case ExplodeJava:
                Explode explode =  new Explode();
                explode.setDuration(1000);
                getWindow().setEnterTransition(explode);

                break;

            case ExplodeXML:
                enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
            case FadeJava:
                Fade fadeAnimation = new Fade();
                fadeAnimation.setDuration(1000);
                fadeAnimation.setMode(Visibility.MODE_IN);//Enter the screen from the Right
               // fadeAnimation.setInterpolator(new AnticipateOvershootInterpolator());
                getWindow().setEnterTransition(fadeAnimation);

                break;
            case FadeXML:
                enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
            case SlideJava:
                Slide enterAnimation = new Slide();
                enterAnimation.setDuration(1000);
                enterAnimation.setSlideEdge(Gravity.RIGHT);//Enter the screen from the Right
                getWindow().setEnterTransition(enterAnimation);

                break;
            case SlideXML:
                enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
        }

    }


}
