package shido.com.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SharedTransitionActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.exitBt)
    Button extButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Inside your activity (if you did not enable transitions in your theme)
        //For appCompat getWindows comes before onCreate
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_transition);
        ButterKnife.bind(this); //Como não há itens nos extras o bind ja pode ser chamado
        bindControl();
        setUpToolbar();

    }

    private void setUpToolbar() {
            setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared Element Transition");
    }

    private void bindControl() {
        extButton.setOnClickListener(v->{finishAfterTransition();});
    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }
}
