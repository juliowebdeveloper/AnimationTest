package shido.com.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Window;
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
        //        ButterKnife.bind(this); -> Se usar ActivityOptionsCompat

        type  = (Constants.AnimType) getIntent().getSerializableExtra(Constants.KEY_TYPE);
        toolBarTitle = getIntent().getStringExtra(Constants.KEY_TITLE);
        animName = getIntent().getStringExtra(Constants.KEY_NAME);
        ButterKnife.bind(this); //Se usar ActivityOptions

        setUpAnimation();
        setUpToolbar();
        bindControl();

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

        switch (type){
            case ExplodeJava:
                Explode explode =  new Explode();
                explode.setDuration(1000);
                getWindow().setEnterTransition(explode);

                break;

            case ExplodeXML:
                break;
            case FadeJava:
                break;
            case FadeXML:
                break;
            case SlideJava:
                break;
            case SlideXML:
                break;
        }

    }


}
