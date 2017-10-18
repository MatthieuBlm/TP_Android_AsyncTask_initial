package com.bellamy.tpandroidasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by bellamy on 12/10/17.
 */

public class ExtandedOperation extends AsyncTask<Integer, Integer, Void> {
    private Context applicationContext;
    private ProgressBar progressBar;


    public ExtandedOperation(Context context, ProgressBar progressBar){
        this.applicationContext = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(applicationContext, "Début du traitement asynchrone", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
        // Mise à jour de la ProgressBar
        progressBar.setProgress(values[0]);
    }

    @Override
    protected Void doInBackground(Integer... arg0) {
        int progress;

        for (progress=0; progress <= 100; progress++){
            for (int i=0; i < 10000000; i++){}

            // La méthode publishProgress met à jour l'interface en invoquant la méthode onProgressUpdate
            publishProgress(progress);
            progress++;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Toast.makeText(applicationContext, "Le traitement asynchrone est terminé", Toast.LENGTH_LONG).show();
    }

}
