package app.axross.colorquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity";
    private int score = 0;
    private ColorQuestion question;
    private Button leftButton;
    private Button rightButton;
    private TextView questionColorTextView;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        questionColorTextView = findViewById(R.id.questionColor);
        scoreTextView = findViewById(R.id.score);

        setScore(0);
        setNewQuestion();

        leftButton.setOnClickListener((button) -> this.onLeftButtonTapped());
        rightButton.setOnClickListener((button) -> this.onRightButtonTapped());
    }

    private void onLeftButtonTapped() {
        Toast.makeText(
            this, "Left button is tapped!",
            Toast.LENGTH_SHORT
        ).show();

        decide(question.left);
    }

    private void onRightButtonTapped() {
        Toast.makeText(
            this, "Right button is tapped!",
            Toast.LENGTH_SHORT
        ).show();

        decide(question.right);
    }

    private void decide(ColorChoice chosen) {
        if (question.answer.equals(chosen)) {
            score += 1;
        } else {
            score -= 1;
        }

        setScore(score);

        setNewQuestion();
    }

    private void setScore(int score) {
        scoreTextView.setText(String.format("Score: %d", score));
    }

    private void setNewQuestion() {
        question = new ColorQuestion();

        leftButton.setBackgroundColor(question.left.getColor());
        rightButton.setBackgroundColor(question.right.getColor());
        questionColorTextView.setText(question.answer.getName());
    }
}
