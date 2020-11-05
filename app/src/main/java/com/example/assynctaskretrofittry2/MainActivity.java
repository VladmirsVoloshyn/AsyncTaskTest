package com.example.assynctaskretrofittry2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.assynctaskretrofittry2.data.Main;

import java.lang.ref.WeakReference;
import java.util.Timer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int[] resultArray = new int[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.resultTextView);
    }

    public void onProcess(View view) {
        RetrofitAsyncTask asyncTask = new RetrofitAsyncTask();
        asyncTask.setMainActivityWeakReference(new WeakReference<>(MainActivity.this));
        asyncTask.execute("BY");
    }

    void checkProgress(TaskStatus value){
        switch (value){
            case TASK_FINISHED:
               textView.append("\ntask finished\n");
               break;
            case TASK_PROCESSED:
                textView.setText("\ntask processed now");
                break;
        }
    }

    public static void doSomething(){

    }

    public static int doSomething(int value){

        return 0;
    }


    void setResultArray(String[] array) {
        textView.setText("");
//        for (String value : array) {
//            textView.append(value + "\n");
//        }
    }

    static class RetrofitAsyncTask extends AsyncTask<String, TaskStatus, String[]> implements com.example.assynctaskretrofittry2.RetrofitAsyncTask {



        protected Retrofit retrofit;
        protected WeakReference<MainActivity> mainActivityWeakReference;
        protected Main main;

        void setMainActivityWeakReference(WeakReference<MainActivity> mainActivityWeakReference) {
            this.mainActivityWeakReference = mainActivityWeakReference;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            final String BASE_URL = "https://holidayapi.com/v1/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        @Override
        protected String[] doInBackground(String... strings) {
            String[] arrayString = new String[2];
                retrofit.create(HolidaysPlaceHolderAPI.class)
                        .getListHolidays("65284ebd-3463-470f-b3eb-b7beaef774ae", strings[0], "2019")
                        .enqueue(new Callback<Main>() {
                            @Override
                            public void onResponse(@NonNull Call<Main> call, @NonNull Response<Main> response) {

                                main = response.body();

                                arrayString[0] = main.getWarning();
                                arrayString[1] = main.getHolidays().get(0).getCountry();
                            }

                            @Override
                            public void onFailure(@NonNull Call<Main> call, @NonNull Throwable t) {
                                t.printStackTrace();
                            }
                        });
            do {
                onProgressUpdate(TaskStatus.TASK_PROCESSED);
            } while (main == null);
            onProgressUpdate(TaskStatus.TASK_FINISHED);
            return arrayString;
        }

        @Override
        protected void onPostExecute(String[] strings) {
            super.onPostExecute(strings);
            mainActivityWeakReference.get().setResultArray(strings);

        }


        @Override
        protected void onProgressUpdate(TaskStatus... values) {
            super.onProgressUpdate(values);
            mainActivityWeakReference.get().checkProgress(values[0]);
        }

        @Override
        protected void onCancelled(String[] strings) {
            super.onCancelled(strings);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

   public enum TaskStatus{
        TASK_PROCESSED(0),
        TASK_FINISHED(1);
       TaskStatus(int codeStatus) {
       }
   }
}