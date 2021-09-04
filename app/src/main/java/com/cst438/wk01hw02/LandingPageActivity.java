package com.cst438.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * <h2><b>Landing Page Activity</b></h2>
 * The landing page activity is began after a user successfully log into an account.
 * They will then be displayed all of the posts that are associated with that particular account.
 *
 * @author Eric Chavez Velez
 */

public class LandingPageActivity extends AppCompatActivity {

    private TextView textViewResult;
    public static final String ACTIVITY_LABEL = "SECOND_ACTIVITY_COM_ECHAVEZ";

    // Code to integrate retrofit API referenced from
    // https://codinginflow.com/tutorials/android/retrofit/part-1-simple-get-request
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        textViewResult = findViewById(R.id.text_view_result);

        Bundle extras = getIntent().getBundleExtra(ACTIVITY_LABEL);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();


        String newMessage = "Welcome to the retrofit API App " + extras.getString("username") + "!!!\nID: " + extras.getString("userId") + "\n\n\n\n";
        textViewResult.setText(newMessage);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content ="";

                    if(Integer.parseInt(extras.getString("userId")) == post.getUserId()){
                        content += "ID:" + post.getId() + "\n";
                        content += "User ID: " + post.getUserId() + "\n";
                        content += "Title: " + post.getTitle() + "\n";
                        content += "Text: " + post.getText() + "\n\n";

                        textViewResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public static Intent getIntent(Context context, Bundle bundle){
        Intent intent = new Intent(context,LandingPageActivity.class);

        intent.putExtra(LandingPageActivity.ACTIVITY_LABEL, bundle);

        return intent;
    }
}