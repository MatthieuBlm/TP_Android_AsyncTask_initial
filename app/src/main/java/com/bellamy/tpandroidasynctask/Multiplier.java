package com.bellamy.tpandroidasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Multiplier extends AsyncTask<Integer, Integer, Long> {
    private Context applicationContext;
    private ProgressBar progressBar;

    public Multiplier(Context context, ProgressBar progressBar){
        this.applicationContext = context;
        this.progressBar = progressBar;
    }

    @Override
    protected Long doInBackground(Integer... integers) {
        Long res = new Long(1);

        for (int i = 0; i < integers.length; i++) {
            res = res * integers[i];
            for (int j = 0; j < 10000000; j++){}
            publishProgress((int) ((i / (float) integers.length) * 100));
        }

        publishProgress(100);

        return res;
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
        // Mise à jour de la ProgressBar
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Long result) {
        Toast.makeText(applicationContext, "Résultat : " + result, Toast.LENGTH_LONG).show();
    }
}
